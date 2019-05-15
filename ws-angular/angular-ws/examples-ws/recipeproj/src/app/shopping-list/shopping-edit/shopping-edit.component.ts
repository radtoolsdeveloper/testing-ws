import { ShoppingListService } from './../shopping-list.service';
import { Component, OnInit } from '@angular/core';
import { ViewChild } from "@angular/core";
import { ElementRef } from "@angular/core";
import { Ingredient } from "src/app/shared/ingredient.model";

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit {
  @ViewChild('inputName') nameInputRef: ElementRef;
  @ViewChild('inputAmount') amountInputRef: ElementRef;
  constructor(private shoppingListService: ShoppingListService) { }

  ngOnInit() {
  }

  onAddItem() {
    const ingName = this.nameInputRef.nativeElement;
    const ingAmount = this.amountInputRef.nativeElement;
    const newIngredient = new Ingredient(ingName, ingAmount);
    this.shoppingListService.addIngredients(newIngredient); 
  }
}
