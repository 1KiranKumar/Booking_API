Feature: To delete a Booking

  Scenario: To delete a Booking
    Given user has access to the endpoint "/booking/{key}"
    And user makes a request to view booking details using the booking ID
    When user makes a request to delete booking
    Then user should get a response code 201