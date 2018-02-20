@mercury
Feature: Mercury Tour Application
  Open the application
  login
  perform some action
  Background: setup browser and navigate to application URL
    Given User open firefox browser
    Then go to "http://newtours.demoaut.com/mercurysignon.php"

  Scenario: Mercury Tour Application Test Scenario
    Given user opens mercury tour application
    And user enters "a" on Username
    And user enters "a" on Password
    And user clicks on Submit button
    Then user perform some action on Flight Finder Page
    And user clicks on Continue button
    Then user should be on Select a Flight page
    Then user closes the browser

  Scenario Outline: Scenario Outline Demo
    Given user greeting
    Then print member name "<col1>"
    Then print member location "<col2>"
    Examples:
    |col1    |col2    |
    |Asif    |Pune    |
    |Picasso |Chennai |

  Scenario: String, integer, list demo
    Given My name is "Asif"
    And I am 32 years old
    And I have been to : Kolkata, Bhubaneswar, Pune for work

  Scenario: Data Table Demo
    Given user get the OS printed
    Then print the following
      | name            | position         | office        |
      | Tiger Nixon     | System Architect | Edinburgh     |
      | Garrett Winters | Accountant       | Tokyo         |
      | Asif 1          | Tester           | San Francisco |
