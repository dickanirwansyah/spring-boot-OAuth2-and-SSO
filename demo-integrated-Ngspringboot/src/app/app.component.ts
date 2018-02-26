import { Component } from '@angular/core';
import { AuthService } from './login/auth-service';
import { Cookie } from 'ng2-cookies';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  constructor(private authservice:AuthService){}

  isAuthenticated(){
    if(!Cookie.check('access_token')){
        return false;
    }else{
      return true;
    }
  }

  logout(){
    if(confirm('do you want clear the cookies?')){
      this.authservice.logout();
    }
  }
}
