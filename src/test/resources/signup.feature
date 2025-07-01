Feature: User Sign Up on Demoblaze

  @signup
  Scenario Outline: User Sign Up with Valid and Invalid Inputs
    Given User navigate to Demoblaze website
    When user click on signup button
    And user Enter username address "<user>"
    And user Enter Password "<password>"
    And User clicks the Sign up button
    Then web will show Success signup website "<expectedMessage>"

    Examples:
      | user      | password | expectedMessage                        |
      | Salma2025 | 4555555  | Sign up successful.                    |
      | Salma2025 | 4555555  | This user already exist.               |
      | Salma2025 |          | Please fill out Username and Password. |
      |           | 4555555  | Please fill out Username and Password. |
