Feature: Check Notifications section


Scenario: Verify Notifications option to receive marketing materials
Given FE user is able to login to FrontEnd
When user navigate Notifications page 
Then user verify Notifications menu is highlighted
Then user verify page heading 
Then user select Notifications checkbox
Then user verify success message display
