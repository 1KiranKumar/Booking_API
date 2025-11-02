Feature: To view the booking details

  Scenario: To Get the Booking Details from Booking Id
    Given user has access to the endpoints "/booking/{key1}"
    When user makes a request to view booking details using the booking ID
    And user should see all the details of that particular booking Id.

