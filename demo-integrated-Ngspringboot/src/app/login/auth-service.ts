import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Cookie } from 'ng2-cookies';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthService{

     AUTH_TOKEN = '/oauth/token';

   constructor(
       private _router:Router,
       private _http:Http
   ){}

   obtainAccessToken(loginData){
       let params = new URLSearchParams();
       params.append('username',loginData.username);
       params.append('password',loginData.password);
       params.append('grant_type','password');
       params.append('client_id','clientGojekApp');

       let headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Basic '+btoa("clientGojekApp:mysecret")});
       let options = new RequestOptions({ headers: headers});
       console.log(params.toString());

       this._http.post(this.AUTH_TOKEN, params.toString(), options)
       .map(res => res.json())
       .subscribe(
           data => this.saveToken(data),
           error => alert('Invalid Credentials')
       );
   }

   saveToken(token){
        var expireTokenDate = new Date().getTime() + (1000 * token.expires_in);
        Cookie.set("access_token", token.access_token, expireTokenDate);
        console.log('Obtained Access Token');
        this._router.navigate(['/']);
   }

   checkCredentials(){
       if(!Cookie.check('access_token')){
           this._router.navigate(['/login']);
       }
   }

   logout(){
       Cookie.delete("access_token");
       window.location.reload();
       console.log('cookies access_toke di clear dari cookies')
   }

}