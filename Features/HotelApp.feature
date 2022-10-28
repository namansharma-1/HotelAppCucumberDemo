Feature: HotelApp Login
Description: This test is to check the login functionality of the HotelApp

Scenario: Login Successful
Given User is on HotelApp homepage
When User enters Username  
And User enters Password  
And User clicks on Login button
Then Login is Successful