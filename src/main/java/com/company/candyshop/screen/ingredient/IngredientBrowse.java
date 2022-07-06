package com.company.candyshop.screen.ingredient;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Ingredient;

@UiController("Ingredient.browse")
@UiDescriptor("ingredient-browse.xml")
@LookupComponent("ingredientsTable")
public class IngredientBrowse extends StandardLookup<Ingredient> {
}