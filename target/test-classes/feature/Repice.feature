@Web
Feature: Recipe Book tests

  @Smoke
  Scenario: Add new recipe
    Given I am on Recipe book
    When I click on "New Recipe" button
    Then I see "New Recipe" form is shown
    When I fill "recipe1" in "Name" field
    And I fill "temp" in "Image URL" field
    And I fill "description auto test" in "Description" field
    And I click on "Add Ingredient" button
    And I add 5 "cucumber" as ingredient
    And I click on "Save" button
    Then Recipe with "recipe1" name and "description auto test" description is shown

  @Smoke
  Scenario: Create and edit recipe
    Given I am on Recipe book
    When I click on "New Recipe" button
    Then I see "New Recipe" form is shown
    When I fill "recipe1" in "Name" field
    And I fill "temp" in "Image URL" field
    And I fill "description auto test" in "Description" field
    And I click on "Add Ingredient" button
    And I add 5 "cucumber" as ingredient
    And I click on "Save" button
    Then Recipe with "recipe1" name and "description auto test" description is shown
    # edit
    When I click on recipe with name "recipe1"
    And I click "Manage Recipe" button
    And I select "Edit Recipe" option
    Then I see "New Recipe" form is shown
    When I fill "newRecipe1" in "Name" field
    And I fill "newTemp" in "Image URL" field
    And I fill "updated description auto test" in "Description" field
    And I add 10 "cucumber" as ingredient
    And I click on "Save" button
    Then Recipe with "newRecipe1" name and "updated description auto test" description is shown
    When I click on recipe with name "newRecipe1"
    Then Ingredients field shows "cucumber - 10"

  @Smoke
  Scenario: Create and delete recipe
    Given I am on Recipe book
    When I click on "New Recipe" button
    Then I see "New Recipe" form is shown
    When I fill "recipe1" in "Name" field
    And I fill "temp" in "Image URL" field
    And I fill "description auto test" in "Description" field
    And I click on "Add Ingredient" button
    And I add 5 "cucumber" as ingredient
    And I click on "Save" button
    Then Recipe with "recipe1" name and "description auto test" description is shown
    # delete
    When I click on recipe with name "recipe1"
    And I click "Manage Recipe" button
    And I select "Delete Recipe" option
    Then Recipe with "recipe1" name and "description auto test" description is not shown

  @Smoke
  Scenario: Create recipe and add to shopping list
    Given I am on Recipe book
    When I click on "New Recipe" button
    Then I see "New Recipe" form is shown
    When I fill "recipe1" in "Name" field
    And I fill "temp" in "Image URL" field
    And I fill "description auto test" in "Description" field
    And I click on "Add Ingredient" button
    And I add 5 "cucumber" as ingredient
    And I click on "Save" button
    Then Recipe with "recipe1" name and "description auto test" description is shown
    # add to shopping list
    When I click on recipe with name "recipe1"
    And I click "Manage Recipe" button
    And I select "To Shopping List" option
    And I navigate to "Shopping List" tab
    Then Ingredients list contains "cucumber (5)"