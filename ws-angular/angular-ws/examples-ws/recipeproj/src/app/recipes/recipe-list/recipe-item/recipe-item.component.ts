import { Component, OnInit } from '@angular/core';
import { Recipe } from "src/app/recipes/recipe.model";
import { Input, Output, EventEmitter } from "@angular/core";

@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css']
})
export class RecipeItemComponent implements OnInit {
  @Input() recipe : Recipe;
  constructor() { }
  @Output() recipeSelected  = new EventEmitter<void>();

  ngOnInit() {
    
  }

  onSelected(){
    this.recipeSelected.emit();
  }
}
