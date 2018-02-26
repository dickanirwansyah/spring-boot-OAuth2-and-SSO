import { Component, OnInit } from '@angular/core';
import { CategoryService } from './category.service';
import { Category } from './category';
import { AuthService } from '../login/auth-service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  title = "Manage Category";
  statusHttpResponse: number;
  Category: Array<any>;

  constructor(private categoryservice: CategoryService, private authservice:AuthService) { }

  ngOnInit():void {
    this.authservice.checkCredentials()
    this.getComponentCategoryList();
  }

  public getComponentCategoryList(){
    this.categoryservice.getServiceListCategory()
      .subscribe(data => this.Category = data, 
      errorCode => this.statusHttpResponse = errorCode)
  }

}
