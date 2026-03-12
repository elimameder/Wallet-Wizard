@regression @loggedIn
Feature: Pay and Transfer via Zelle

  @positive
  Scenario: User request money successfully via Zelle
    Given user is on Pay and Transfer page
    When user clicks on Send Money button
    And user enters recipient "testuser1@email.com"
    And user enters amount "50"
    And user enters memo "Rent"
    And user clicks on Request via Zelle button
    Then user should see a requested message displayed

  @negative @bug
  Scenario: System accepts invalid email or phone number format
    Given user is on Pay and Transfer page
    When user clicks on Send Money button
    And user enters recipient "invalid123"
    And user enters amount "50"
    And user enters memo "Rent"
    And user clicks on Request via Zelle button
    Then user should see a requested message displayed


  @negative
  Scenario: User cannot send money with empty fields
    Given user is on Pay and Transfer page
    When user clicks on Send Money button
    And user clicks on Request via Zelle button
    Then user should see a fill in all fields notification

  @negative
  Scenario: User cannot send money with empty amount
    Given user is on Pay and Transfer page
    When user clicks on Send Money button
    And user enters recipient "testuser1@email.com"
    And user clicks on Request via Zelle button
    Then user should see a fill in all fields notification

  @negative
  Scenario: User cannot send money with empty recipient
    Given user is on Pay and Transfer page
    When user clicks on Send Money button
    And user enters amount "50"
    And user clicks on Request via Zelle button
    Then user should see a fill in all fields notification


  @smoke
  Scenario: User sends money successfully via Zelle
    Given user is on Pay and Transfer page
    When user clicks on Send Money tab
    And user enters send recipient "testuser1@email.com"
    And user enters send amount "50"
    And user enters send memo "Rent"
    And user clicks on Send via Zelle button
    Then user should see Fraud Warning message
    When user clicks on Confirm and Send button
    Then user should see Payment Sent message

  @negative @bug
  Scenario: System accepts negative amount when sending money
    Given user is on Pay and Transfer page
    When user clicks on Send Money tab
    And user enters send recipient "testuser1@email.com"
    And user enters send amount "-50"
    And user enters send memo "Rent"
    And user clicks on Send via Zelle button
    Then user should see Fraud Warning message
    When user clicks on Confirm and Send button
    Then user should see Payment Sent message





   # Then user should see fraud warning message
   # When user clicks on Confirm and Send button
   # Then money should be sent successfully