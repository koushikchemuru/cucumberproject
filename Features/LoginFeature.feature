Feature: Login feature file

@login @regression
Scenario: User should be able to login to the application

Given User is in login page
When User enters email id "prashanthi.skvl@gmail.com"
And User enters password "Test@123"
And User clicks the signin button
Then User should be logged in successfully


@logout @regression
Scenario: User should be able to logout from the application


When User clicks the profile button
And User clicks the signout button
Then User should be logged out successfully


@invalidlogin @regression
Scenario: User should not login with invalid credentials


#Given User is in login page
When User enters email id "test345678123@gmail.com"
And User enters password "test@123"
And User clicks the signin button
Then User should see error message on the screen