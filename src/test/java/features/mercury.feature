@mercury
Feature: Mercury Tour Application
  Open the application
  login
  perform some action
  Background: setup browser and navigate to application URL
    Given User open firefox browser
    Then go to "http://newtours.demoaut.com/mercurysignon.php"
    #Then go to "https://www.phptravels.net/"

  Scenario: Mercury Tour Application Test Scenario
    Given user opens mercury tour application
    And user enters "asif" on Username
    And user enters "asif" on Password
    And user clicks on Submit button
    Then user perform some action on Flight Finder Page
    And user clicks on Continue button
    Then user should be on Select a Flight page
    Then user closes the browser