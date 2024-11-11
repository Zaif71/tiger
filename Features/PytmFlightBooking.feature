Feature: Flight Ticket Booking
  @zfr
  Scenario: User successfully books a flight ticket
    Given user launch browser and enter url
    Given the user is on the Paytm flight booking page
    When the user selects a departure city as "DELHI"
    And the user selects a destination city as "MUMBAI"
    And the user selects the departure date as "2024-10-10"

    And the user selects 1 adult traveler
    And the user clicks on the "Search Flights" button
#    Then the user should see a list of available flights
#    When the user selects a flight from the list
#    And the user clicks on the "Continue" button
#    And the user enters passenger details
#     | Name   | Age | Gender |
#     | Zaffar | 23  | Male   |
#    And the user selects "Paytm Wallet" as the payment method
#    And the user confirms the payment
#    Then the user should see a confirmation message for the flight booking