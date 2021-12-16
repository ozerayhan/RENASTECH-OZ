Feature: Gateway website order process verification
  @TC1 @Smoke @regression
  Scenario: Verify home page header matches expected header
    Given The user on the home page of the application
    And The user should be able to see the header
    Then The header should be as "Mother Elephant With Babies Soft Toy"
  @TC2 @Smoke
  Scenario: Verify toy price
    Given The user on the home page of the application
    When The user check the toy price
    Then The price should be as "20$"

  @TC3 @Smoke
  Scenario: Verify the url title
    Given The user on the home page of the application
    When the user on the application the url should contain "payment-gateway"
  @TC4 @Smoke @regression
  Scenario: place an order of 5 toys and verify the confirmation message
    Given The user on the home page of the application
    When The user selects "5" toys
    Then The user can click Buy Now
    And The user will be able to provide the payment information as
      |CNumber | 1212121212121212 |
      |EMonth  |    09            |
      |EYear   |   2026           |
      |CVVCode |    123           |
    And The user will submit the payment
    Then The user will get a confirmation text as "Payment successfull!"
  @TC5 @Smoke @regression
  Scenario Outline: Place different orders for different quantities and verify the confirmation message
    Given The user on the home page of the application
    When The user selects the toy quantity as "<quantity>"
    Then The user can click Buy Now
    Then The user will be able to provide sixteen digits card number
    And The user will enter the expiration month
    Then The user will enter the expiration year
    And The user will enter the CVV code
    And The user will submit the payment
    Then The user will get a confirmation text as "Payment successfull!"
    Examples:
      |quantity|
      |5       |
      |8       |
      |9       |
      |2       |
      |4       |