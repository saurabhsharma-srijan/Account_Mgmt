Feature: Verify to newspaper self service page 

Scenario: Verify to add Subscriber ID and Last name for newspaper subscription
Given FE user is able to login to FrontEnd
When user navigate newspaper page from left menu panel
Then user add Subscriber ID and Last name 
Then user clik on Add button for newspaper subscription
Then user Verify details available on next screen for newspaper subscription 


