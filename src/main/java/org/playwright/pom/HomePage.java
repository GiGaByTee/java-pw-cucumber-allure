package org.playwright.pom;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.playwright.base.BasePage.clearAndType;


public class HomePage {
    private final Page page;

    public static final String logoButton = "//a[.='Recipe Book']";
    public static final String shoppingListButton = "//a[.='Shopping List']";
    public static final String newRecipeButton = "//button[.='New Recipe']";
    public static final String addIngredientButton = "//button[.='Add Ingredient']";
    public static final String saveButton = "//button[.='Save']";
    public static final String cancelButton = "//button[.='Cancel']";
    public static final String inputSelector = "//label[text()='%s']/following-sibling::*";
    public static final String ingredientNameInput = "//div[@formarrayname='ingredients']//input[@formcontrolname='name']";
    public static final String ingredientAmountInput = "//div[@formarrayname='ingredients']//input[@formcontrolname='amount']";
    public static final String recipeItemName = "//app-recipe-item//h4[text()='%s']";
    public static final String recipeItemDescription = "//app-recipe-item//p[text()='%s']";
    public static final String manageRecipeButton = "//button[contains(text(),'Manage Recipe')]";
    public static final String manageRecipeOptions = "//button/following-sibling::ul[@class='dropdown-menu']//a[.='%s']";
    public static final String ingredientOnDetailsPage = "//li[@class='list-group-item' and text() = ' %s ']";
    public static final String ingredientsOnShoppingList = "//ul/a[@class='list-group-item' and contains(text(),' %s')]";

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://d3kjkarok860tb.cloudfront.net/recipes");
    }

    public void navigateToShoppingList() {
        page.click(shoppingListButton);
    }

    public void clickOnNewRecipeButton() {
        page.click(newRecipeButton);
    }

    public void clickOnIngredientButton() {
        page.click(addIngredientButton);
    }

    public void clickOnSaveButton() {
        page.click(saveButton);
    }

    public void isNewRecipeFormShown() {
        assertThat(page.locator(saveButton)).isVisible();
        assertThat(page.locator(cancelButton)).isVisible();
    }

    public void fillInField(String value, String name) {
        clearAndType(String.format(inputSelector, name), value);
    }

    public void addIngredient(Integer amount, String name) {
        clearAndType(ingredientNameInput, name);
        clearAndType(ingredientAmountInput, String.valueOf(amount));
    }

    public void verifyRecipeIsAdded(String name, String description) {
        assertThat(page.locator(String.format(recipeItemName, name))).isVisible();
        assertThat(page.locator(String.format(recipeItemDescription, description))).isVisible();
    }

    public void verifyRecipeIsNotShown(String name, String description) {
        assertThat(page.locator(String.format(recipeItemName, name))).not().isVisible();
        assertThat(page.locator(String.format(recipeItemDescription, description))).not().isVisible();
    }

    public void clickOnRecipeWithName(String name) {
        page.click(String.format(recipeItemName, name));
    }

    public void clickOnManageRecipeButton() {
        page.click(manageRecipeButton);
    }

    public void selectOptionFromManageRecipeDropdown(String option) {
        page.click(String.format(manageRecipeOptions, option));
    }

    public void verifyIngredientIsShownOnDetailsPage(String ingredient) {
        assertThat(page.locator(String.format(ingredientOnDetailsPage, ingredient))).isVisible();
    }

    public void verifyIngredientIsAddedToShoppingList(String ingredient) {
        assertThat(page.locator(String.format(ingredientsOnShoppingList, ingredient))).isVisible();
    }
}
