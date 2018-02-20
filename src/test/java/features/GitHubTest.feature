Feature: GitHub application testing

  Scenario: Git Hub Login Test

    Given user opens git hub login page
    Then user enters login id
    Then user enters password
    And user clicks on signin button
    #And close the browser