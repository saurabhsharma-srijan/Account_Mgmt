Feature: Check Mini panel working

@MiniPanel
Scenario: Verify the items present on minipanel
Given FE user is able to login to FrontEnd
When user open minipanel 
Then user verify Kia Ora

Then user verify your account label
Then user verify logout label
And verify your account link navigation

@MiniPanel
Scenario: Verify the logout on minipanel
Given FE user is able to login to FrontEnd
When user open minipanel 
Then user verify logout label
And User validate logout application
