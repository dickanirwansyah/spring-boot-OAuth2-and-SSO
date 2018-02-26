import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Response } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { Headers } from '@angular/http';
import { URLSearchParams } from '@angular/http';
import { Category } from '../category/category';
import { Observable } from 'rxjs';
import { Cookie } from 'ng2-cookies';

@Injectable()
export class CategoryService{

    constructor(private http:Http){}

    URI_CATEGORYS = "/category/secure/";

    private getDataJson(res:Response){
        let body = res.json();
        return body;
    }

    private getHandlingError(error:Response | any){
        console.log(error.message | error);
        return Observable.throw(error.status);
    }

    public getServiceListCategory():Observable<Category[]>{
       var headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer '+Cookie.get('access_token')});
       var options = new RequestOptions({headers: headers});

       return this.http.get(this.URI_CATEGORYS+'list', options)
       .map((res:Response) => res.json())
       .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
    }
}