Feature: Login functionality

  Scenario Outline: Ensure login functionality
    Given user is on SwagLabs login page
    When user input <username> as username
    And user input <password> as password
    And user click login button
    Then user verify <status> login result

    Examples:
    | username        | password        | status  |
    | standard_user   | secret_sauce    | success |
    | standard_user   | wrong_password  | failed  |
    | locked_out_user | secret_sauce    | failed  |

  Scenario: Logged user as standard_user
    Given user login as standard_user
    Then user on inventory page

  Scenario Outline: Access protected page without authentication
    Given user on protected page <page>
    Then user is redirected to SwagLabs login page
    And user get auth error message accessing <page>

    Examples:
    | page           |
    | inventory      |
    | cart           |
    | inventory-item |