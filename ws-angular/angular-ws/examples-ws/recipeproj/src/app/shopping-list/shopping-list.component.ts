import { ShoppingListService } from './shopping-list.service';
import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../shared/ingredient.model';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent implements OnInit {
  ingredients: Ingredient[];

  constructor(private shoppingListService: ShoppingListService) { }

  ngOnInit() {
    //this.ingredients = this.shoppingListService.getIngredients();
    //console.log(this.ingredients);
    this.shoppingListService.ingredientsChanged
      .subscribe(
      (ingredients: Ingredient[]) => {
        //Array.prototype.push.apply(this.ingredients, ingredients);
        this.ingredients = ingredients;
      });
  }
}
