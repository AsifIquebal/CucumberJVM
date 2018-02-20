Feature: Cucumber Learning Session
# Comment
  Scenario: Cucumber Learning Session Scenarios
    Given user is on selenium practice home page
    Then user enters "CGroup" on text box
    Then user selects value from Select drop down
#    Then click on Home
    Then user wants to know the OS
    Then user enters "asif" on username
    And user enters "123" on password

  Scenario: Data Table Element Verification
    Given user is on selenium practice home page
    Then we verify following data exists
      | name            | position         | office        |
      | Tiger Nixon     | System Architect | Edinburgh     |
      | Garrett Winters | Accountant       | Tokyo         |
      | Asif 1          | Tester           | San Francisco |
