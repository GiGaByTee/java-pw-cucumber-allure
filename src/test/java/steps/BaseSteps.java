package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.playwright.base.BasePage;
import org.playwright.pom.HomePage;

public class BaseSteps extends BasePage {
    HomePage homePage = new HomePage(getPage());

    @Given("I am on Recipe book")
    public void userGoToWebsite() {
        homePage.navigate();
    }

    @Given("I navigate to \"Shopping List\" tab")
    public void userGoToShoppingList() {
        homePage.navigateToShoppingList();
    }

    @And("I click on \"New Recipe\" button")
    public void clickOnNewRecipeButton() {
        homePage.clickOnNewRecipeButton();
    }

    @And("I click on \"Add Ingredient\" button")
    public void clickOnAddIngredientButton() {
        homePage.clickOnIngredientButton();
    }

    @And("I click on \"Save\" button")
    public void clickOnSaveButton() {
        homePage.clickOnSaveButton();
    }

    @And("I see \"New Recipe\" form is shown")
    public void newRecipeFormIsShown() {
        homePage.isNewRecipeFormShown();
    }

    @And("I fill {string} in {string} field")
    public void fillInField(String fieldValue, String fieldName) {
        homePage.fillInField(fieldValue, fieldName);
    }

    @And("I add {int} {string} as ingredient")
    public void addIngredient(Integer ingAmount, String ingName) {
        homePage.addIngredient(ingAmount, ingName);
    }

    @And("Recipe with {string} name and {string} description is shown")
    public void verifyRecipeIsAdded(String name, String description) {
        homePage.verifyRecipeIsAdded(name, description);
    }

    @And("Recipe with {string} name and {string} description is not shown")
    public void verifyRecipeIsNotShown(String name, String description) {
        homePage.verifyRecipeIsNotShown(name, description);
    }

    @And("I click on recipe with name {string}")
    public void clickOnRecipeItem(String name) {
        homePage.clickOnRecipeWithName(name);
    }

    @And("I click \"Manage Recipe\" button")
    public void clickOnManageRecipeButton() {
        homePage.clickOnManageRecipeButton();
    }

    @And("I select {string} option")
    public void selectOptionFromManageRecipeDropdown(String option) {
        homePage.selectOptionFromManageRecipeDropdown(option);
    }

    @And("Ingredients field shows {string}")
    public void verifyIngredientIsShownOnDetailsPage(String ingredient) {
        homePage.verifyIngredientIsShownOnDetailsPage(ingredient);
    }

    @And("Ingredients list contains {string}")
    public void verifyIngredientIsAddedToShoppingList(String ingredient) {
        homePage.verifyIngredientIsAddedToShoppingList(ingredient);
    }
}