import { Component, OnInit } from '@angular/core';
import { AuthService } from '../login/auth-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {

  public loginData = {username : "",password : ""};

  constructor(
    private authservice:AuthService
  ) {}

  login(){
    this.authservice.obtainAccessToken(this.loginData);
  }

}
