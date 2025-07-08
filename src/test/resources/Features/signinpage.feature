# Project: Magento E-Commerce Website Testing
# Application: Magento Software Testing Board
# Module: Login Page
# Feature: Login Page Validation
# Author: [Supriya]
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
  Scenario Outline: Successful login with valid credentials
    When the user enters a valid "<email>" and "<password>"
    And the user clicks the "Sign In" button
    Then the user should see the welcome message "<username>"

    Examples: 
      | email                     | password        | username      |
      | celinaredden123@gmail.com | Celinaredden123 | Celina Redden |
      | jones20@gmail.com         | Jones@12345     | Vendy Jones   |

  # Functional Negative Scenarios
  Scenario Outline: Display appropriate error message for invalid login credentials
    When user enters "<email>" and "<password>"
    And user clicks the "Sign In" button
    Then the user should see an error message "<errorMessage>"

    Examples: 
      | email            | password    | errorMessage                                                                                                |
      |                  |             | This is a required field.                                                                                   |
      |                  | Password123 | This is a required field.                                                                                   |
      | user@example.com |             | This is a required field.                                                                                   |
      | user@example.com | wrongpass   | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |
      | invalidemail     | Password123 | Please enter a valid email address (Ex: johndoe@domain.com).                                                |
      | user@.com        | Password123 | Please enter a valid email address (Ex: johndoe@domain.com).                                                |
      | user@example.com |         123 | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |

  # Navigation
  Scenario: Verify 'Forgot Password' link redirects to password recovery page
    When the user clicks the "Forgot Your Password?" link on the Sign In page
    Then the user should be redirected to the password recovery page

  Scenario: Verify 'Create an Account' link redirects to registration page
    When the user clicks the "Create an Account" link on sign in page
    Then the user should be redirected to the page with title "Create New Customer Account"

  Scenario: Pressing Enter key submits login form
    Given the user enters a valid email "celinaredden123@gmail.com"
    And the user enters a valid password "Celinaredden123"
    When the user presses the Enter key while focused on the password field
    Then the user should see welcome message "Celina Redden"
@HI
  Scenario: Verify tab order of fields and buttons
    Then the tab order should navigate in logical sequence: Email → Password → Sign In
