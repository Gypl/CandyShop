package com.company.candyshop.screen.ingredient;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Ingredient;

@UiController("Ingredient.edit")
@UiDescriptor("ingredient-edit.xml")
@EditedEntityContainer("ingredientDc")
public class IngredientEdit extends StandardEditor<Ingredient> {
}