Feature: Enter login details

  @smoke
  @e2e
  Scenario Outline: Successful login
    Given I start the application
    When I click email field
    And I enter valid email <email>
    And I close the keyboard
    And I click password field
    And I enter valid password <password>
    And I close the keyboard
    And I click sign in button
    Then I expect to see successful login message
    Examples:
      | email        | password |
      | abv@mail.com | 123456   |
      | test@gmail.com | somePassWithVeryLongValue   |