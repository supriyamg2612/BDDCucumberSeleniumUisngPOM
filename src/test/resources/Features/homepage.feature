# Project: Magento E-Commerce Website Testing
# Application: Magento Software Testing Board
# Module: Home Page
# Feature: Home Page Validation
# Author: [Supriya Ghuge]
# Description: Verify that the Magento home page loads correctly with all essential UI components and navigation links.
Feature: Home Page Validation
  In order to ensure the Magento e-commerce site funsctions correctly
  As a user
  I want to verify that the home page loads successfully and contains all key UI elements and navigation links.

  Background: 
    Given the user has opened the browser

  Scenario: Verify home page loads successfully
    When the user navigates to Home Page
    Then the page should load without errors
    And the header should be visible
    And the footer should be visible

  