@asus
Feature: Cucumber Learning Session
# Comment

  @demo
  Scenario: Cucumber Learning Session Scenarios
    Given user is on selenium practice home page
    Then user enters "CGroup" on text box
    Then user selects value from Select drop down
    Then click on Home
    Then user wants to know the OS
    Then user enters "asif" on username
    And user enters "123" on password

  @DT
  Scenario: Data Table Element Verification
    Given user is on selenium practice home page
    Then we verify following data exists
      | name            | position         | office        |
      | Tiger Nixon     | System Architect | Edinburgh     |
      | Garrett Winters | Accountant       | Tokyo         |
      | Asif 1          | Tester           | San Francisco |

  @SO
  Scenario Outline: Scenario Outline Demo
    Given user greeting
    Then print member name "<col1>"
    Then print member location "<col2>"
    Examples:
      | col1    | col2    |
      | Asif    | Pune    |
      | Picasso | Chennai |

  @demo1
  Scenario: String, integer, list demo
    Given My name is "Asif"
    And I am 32 years old
    And I have been to : "Kolkata, Bhubaneswar, Pune" for work

  @dt
  Scenario: Data Table Conversion
    Given the following datatable and convert to list
      | name            | position         | office        |
      | Tiger Nixon     | System Architect | Edinburgh     |
      | Garrett Winters | Accountant       | Tokyo         |
      | Asif 1          | Tester           | San Francisco |
    Given the following datatable and convert to map
      | name            | position         |
      | Tiger Nixon     | System Architect |
      | Garrett Winters | Accountant       |
      | Asif 1          | Tester           |

  @dataTable @demoY
  Scenario: Data Table Conversion Automatic
    Given the following datatable and convert to list automatically
      | name            | position         |
      | Tiger Nixon     | System Architect |
      | Garrett Winters | Accountant       |
      | Asif 1          | Tester           |
    # A DataTable can only be converted to a Map when there are 2 columns
    # Otherwise it will throw : cucumber.runtime.CucumberException


