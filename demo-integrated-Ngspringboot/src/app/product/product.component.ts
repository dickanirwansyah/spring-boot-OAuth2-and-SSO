import { Component, OnInit } from '@angular/core';
import { AuthService } from '../login/auth-service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(
    private authservice:AuthService
  ) { }

  ngOnInit() {
    this.authservice.checkCredentials()
  }

}
