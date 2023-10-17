Feature: Inventory functionality

  Scenario: Accessing invalid inventory ID on inventory-item page
    Given user login as standard_user
    When user click link in product title
    Then user on inventory-item page
    When user change id parameter in url with invalid inventory ID
    Then user get info that item is not found

  Scenario: Accessing inventory-item page when click title on inventory page
    Given user login as standard_user
    When user click link in product title
    Then user on inventory-item page
    Then user get correct inventory-item page