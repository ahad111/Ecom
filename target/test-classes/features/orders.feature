@Regression
Feature: Purchase and order from Ecommerce website

  Background:
  Given Landed in ecommerce website

  @Regression
  Scenario Outline:Positive test submiting the order

    Given Enter the username <name> and password <password>
    When Select the product <product> from the product catalouge
    And Checkout with the product <product> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed in confirmation page
    Examples:
      | name                      | password | product         |
      | abdulahaduitian@gmail.com | Test@123 | ADIDAS ORIGINAL |
