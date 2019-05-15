import { Recipe } from './recipe.model';
import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private recipes: Recipe[] = [
    new Recipe("Recipe3", "recipe1", "https://countryrecipebook.com/wp-content/uploads/2016/08/country-recipe-book-logo-1.jpg"),
    new Recipe("Recipe4", "recipe2", "https://upload.wikimedia.org/wikipedia/commons/1/15/Recipe_logo.jpeg")
  ];
  recipeSelected = new EventEmitter<Recipe>();

  getRecipes() {
    return this.recipes.slice();
  }
}
