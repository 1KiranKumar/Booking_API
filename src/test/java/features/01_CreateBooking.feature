Feature: To create a new Booking

  Scenario: To create a new Booking
    Given user has access to the endpoint "/booking"
    When user creates a booking using the required body
    Then user should get a response code 200
    And verify that the Id is not null

