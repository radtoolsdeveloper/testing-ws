import { Component, OnInit } from '@angular/core';
import { Input } from "@angular/core";
import { Recipe } from "src/app/recipes/recipe.model";

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  @Input() recipe: Recipe;
  constructor() { }

  ngOnInit() {
  }

}
