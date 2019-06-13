# language: en

Feature: Do a login

  I have an account on Cypress

  Scenario: Login with valid credentials
    Given My register is valid
    When Authenticate with valid credentials
    Then the home page is showed

Scenario: Login with invalid credentials
    Given My register is valid
    When Authenticate with invalid credentials
    Then an error message is showed
