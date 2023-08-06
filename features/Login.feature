#Author: Bharath
Feature: Login module of Orange Application

  Background: 
    Given user open the browser
    When user navigates to the login URL

  @sanity
  Scenario: User should be able to login when valid credentails are provided
    And user inputs valid "Admin" and "admin123"
    And clicks on login button
    Then the home page is displayed

  Scenario: User should see error message when login with invalid credentails
    And user inputs invalid "Admin" and "Welcome2"
    And clicks on login button
    Then the login page is displayed with error message
