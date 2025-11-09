Feature: To view the booking details

  Scenario: To Get the Booking Details from Booking Id
    Given user has access to the endpoint "/booking/{key}"
    When user makes a request to view booking details using the booking ID
    And user should see all the details of that particular booking Id.

  Scenario Outline: To Get the booking Id using First and Last Name
    Given user has access to the endpoint "/booking"
    When user makes a request to view booking IDs from "<firstname>" and "<lastname>"
    Then user should get a response code 200
    And user should see the booking Id of that particular firstname and lastname
    Examples:
      | firstname  | lastname |
      | Kiran      | Kumar    |