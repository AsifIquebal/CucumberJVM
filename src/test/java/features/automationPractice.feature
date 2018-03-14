
Feature: Automation Practice Application
  Open the application
  login
  perform some action

#  Background: setup browser and navigate to application URL
#    Given User open firefox browser
#    Then go to "http://automationpractice.com"

  Scenario: Automation Practice Test Scenario
    Given user navigate to the application URL
    And user opens Login Page
    And user enters "asu9421@gmail.com" on Username
    And user enters "aut555" on Password
    And user clicks on SignIn button
    Then user clicks on My Address section
    And user create a new address
    Then user delete the address
    Then user log out of the application

  Scenario Outline: Search for products
    Given user is on home page
    When user search for <Search_Query>
    Then user get <number_of_products> product as result

    Examples:
    | Search_Query | number_of_products |
    | Sari         | 0                  |
    | Jama         | 0                  |
    | CHIFFON      | 2                  |
