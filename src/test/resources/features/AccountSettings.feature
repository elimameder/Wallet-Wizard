@regression
Feature: Account Settings

  @loggedIn
  Scenario: User can open Account Settings page
    When user clicks "Profile & settings"
    And user clicks Account settings
    And user enables Go Paperless
    Then Go Paperless should be enabled

  Scenario: User can hide account
    When user enables Hide Account
    Then account should be hidden from dashboard