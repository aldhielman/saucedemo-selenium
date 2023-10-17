Feature: Cart functionality

  Scenario: Add/Remove item to cart correctly
    Given user login as standard_user
    Given cart item is empty
    When user click 'add to cart' button on item
    Then cart icon have 1 item
    When user click remove button on added item
    Then cart item is empty
    And cart page have no item