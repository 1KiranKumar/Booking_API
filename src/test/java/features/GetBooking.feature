Feature: To view the booking details

  Scenario: To Get the Booking Details from Booking Id
    Given user has access to the endpoints "/booking/{key1}"
    When user makes a request to view booking IDs
    And user makes a request to view details of a booking ID