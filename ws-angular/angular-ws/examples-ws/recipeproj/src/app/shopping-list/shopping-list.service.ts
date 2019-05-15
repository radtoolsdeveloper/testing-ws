import { EventEmitter } from '@angular/core';
import { Ingredient } from './../shared/ingredient.model';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {
  ingredientsChanged = new EventEmitter<Ingredient[]>();
  ingredients: Ingredient[] = [
    new Ingredient('Tomato', 5),
    new Ingredient('Potato', 10),
  ];;
  constructor() { }

  getIngredients() {
    return this.ingredients;
  }

  addIngredients(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
    this.ingredientsChanged.emit(this.getIngredients());
  }
}
