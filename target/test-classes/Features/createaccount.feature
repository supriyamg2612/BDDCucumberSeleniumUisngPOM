# Project: Magento E-Commerce Website Testing
# Application: Magento Software Testing Board
# Module: Create Account Page
# Feature: Create Account Page Validation
# Author: Supriya
# Description: Comprehensive validation of the Create Account page including UI visibility, input validation (positive & negative), mandatory field enforcement, and successful account creation with valid credentials.
Feature: Create Account Page Validation
  In order to register as a new user
  As a visitor
  I want to ensure the Create Account page loads and behaves correctly

  Background: 
    Given the user has opened the browser
    And the user navigates to the Create Account page

  #Create Account Page UI Validation
  Scenario: Verify Create Account page loads successfully
    Then the page title should be "Create New Customer Account"
    And the URL should be "https://magento.softwaretestingboard.com/customer/account/create/"
    And the page should be secure

  Scenario: Verify section headings are visible
    Then the page title heading "Create New Customer Account" should be visible
    Then the "Personal Information" section should be visible
    And the "Sign-in Information" section should be visible

 
  Scenario: Verify personal information and sign-in information fields are visible and editable
    Then the "First Name" field should be visible and editable
    And the "Last Name" field should be visible and editable
    And the "Email" field should be visible and editable
    And the "Password" field should be visible and editable
    And the "Confirm Password" field should be visible and editable
    And "Create an Account" button should be visible

       @Test
      Scenario: Verify placeholders for registration fields
    Then the "First Name" field should have placeholder "First Name"
    And the "Last Name" field should have placeholder "Last Name"
    And the "Email" field should have placeholder "Email"
    And the "Password" field should have placeholder "Password"
    And the "Confirm Password" field should have placeholder "Confirm Password"