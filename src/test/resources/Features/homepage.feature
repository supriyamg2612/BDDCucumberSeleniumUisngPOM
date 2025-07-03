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
    When the user navigates to "https://magento.softwaretestingboard.com/"
    Then the page should load without errors
    And the header should be visible
    And the footer should be visible
    And the main sections should be displayed

  Scenario: Verify Magento logo is visible on the home page
    Given the user is on the home page
    Then the Magento logo should be visible at the top-left corner

  Scenario: Verify clicking Magento logo redirects to home page
    Given the user is on any page
    When the user clicks the Magento logo
    Then the user should be redirected to the home page

  Scenario: Verify 'Sign In' and 'Create an Account' links are visible in the header
    Given the user is on the home page
    Then the header should display a "Sign In" link
    And the header should display a "Create an Account" link

  Scenario: Verify clicking 'Sign In' link redirects to the login page
    Given the user is on the home page
    When the user clicks the "Sign In" link
    Then the user should be redirected to the login page

  Scenario: Verify clicking 'Create an Account' link redirects to registration page
    Given the user is on the home page
    When the user clicks the "Create an Account" link
    Then the user should be redirected to the registration page

  Scenario: Verify footer is visible with expected sections
    Given the user is on the home page
    Then the footer should be visible with all expected links and social icons

  Scenario: Verify no browser console errors on home page
    Given the user opens browser console
    When the user navigates to the home page
    Then no errors should be displayed in the console
