import { RecipeService } from './../../recipe.service';
import { Component, OnInit } from '@angular/core';
import { Recipe } from "src/app/recipes/recipe.model";
import { Input } from "@angular/core";

@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css']
})
export class RecipeItemComponent implements OnInit {
  @Input() recipe: Recipe;
  constructor(private recipeService: RecipeService) { }

  ngOnInit() {

  }

  onSelected() {
    this.recipeService.recipeSelected.emit(this.recipe);
  }
}
