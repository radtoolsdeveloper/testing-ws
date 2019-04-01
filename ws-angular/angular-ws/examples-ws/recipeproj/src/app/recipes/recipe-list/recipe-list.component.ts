import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {
  recipes: Recipe[] = [
    new Recipe("Recipe1", "recipe1", "https://countryrecipebook.com/wp-content/uploads/2016/08/country-recipe-book-logo-1.jpg"), 
    new Recipe("Recipe2", "recipe2", "https://upload.wikimedia.org/wikipedia/commons/1/15/Recipe_logo.jpeg")
  ];
  constructor() { }

  ngOnInit() {
  }

}
