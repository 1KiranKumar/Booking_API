Feature: To update a booking

  Scenario: To Create an auth token
    Given user has access to the endpoint '/auth'
    When user creates a auth token with credential "admin" & "password123"
    Then user should get a response code 200

    Scenario Outline: To update a booking
      Given user has access to the endpoint "/booking/{key}"
      When user makes a request to view booking details using the booking ID
      And user updates the details of a booking "<firstname>" "<lastname>" "<totalprice>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
      Then user should get a response code 200

      Examples:
        | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
        | John      | Rambo    |      10000 | true        | 2021-05-15 | 2021-06-11 | Breakfast       |

#      @runThis
      Scenario Outline: To update a booking partially
        Given user has access to the endpoint "/booking/{key}"
        When user makes a request to view booking details using the booking ID
        And user makes a request to update first name "<firstname>" & Last name "<lastname>"
        Then user should get a response code 200

        Examples:  
          | firstname | lastname |
          | TwoPeople | Lastname |