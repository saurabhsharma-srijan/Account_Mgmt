Feature: Check login application with valid credentials

@login
Scenario: Check login with valid credentials
Given User validate login application
Then User navigate to Homepage 
