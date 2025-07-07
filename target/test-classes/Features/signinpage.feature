# Project: Magento E-Commerce Website Testing
# Application: Magento Software Testing Board
# Module: Login Page
# Feature: Login Page Validation
# Author: [Your Name]
# Description: Verify that the login page loads correctly, UI elements are visible, and login functionality works as expected.
#@LoginPage
Feature: Login Page Validation
  In order to securely access my account
  As a user
  I want to verify that the login page UI elements are visible and login functionality behaves correctly with valid and invalid inputs.

  Background: 
    Given the user has opened the browser
    And the user navigates to the login page

  # UI Scenarios
  Scenario: Verify login page fields and buttons are visible
    Then the email input field should be visible
    And the password input field should be visible
    And the "Sign In" button should be visible
    And the "Forgot Your Password?" link should be visible
    And the "Create an Account" link should be visible

  Scenario: Verify placeholders for email and password fields
    Then the email input field should have placeholder "Email"
    And the password input field should have placeholder "Password"

  Scenario: Verify password field masks input characters
    When the user enters "Password123" into the password field
    Then the password input should mask the characters

  # Functional Positive Scenario
  @hello
Scenario Outline: Successful login with valid credentials
    Given the user enters a valid "<email>" and "<password>"
    And the user clicks the "Sign In" button
  Then the user should see the welcome message "<username>"
  
  Examples:
    
     | email                        | password        | username        |
    | celinaredden123@gmail.com   | Celinaredden123 | Celina Redden   |
    | jones20@gmail.com           | Jones@12345     | Vendy Jones     |
