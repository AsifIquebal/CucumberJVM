Feature: GitHub application testing
  Scenario: Git Hub Login Test
    Given user opens git hub login page
    When user enters login id and password
    And user clicks on signin button
    Then user getting unsuccessful login message