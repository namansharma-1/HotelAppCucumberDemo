Feature: HotelApp login Parm
Description: This test is to check the login functionality of the HotelApp

Scenario: Login Successful
Given User is on HotelApp homepage
When User enters Username "vasuvespag"
And User enters Password "vasu1234"
And User clicks on Login button
Then Login is Successful
