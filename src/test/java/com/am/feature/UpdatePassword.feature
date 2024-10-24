Feature: Verify to change password on Account detail page

Scenario: Verify to update password on Account detail page
Given FE user is able to login to FrontEnd
When user navigate account detail page from left panel
Then User verify the labels in account access section
Then User change valid password on account access section
Then user verify success message displayed after password update

Scenario: Verify user should not be login with old password
Given FE user login with email and old password 
Then User should not able to login with old password

Scenario: Verify user should be login with new password
Given FE user login with email and new password 
Then User should be able to login successfully with new password

Scenario: Teardown scenario to revert to old password
Given FE user login with email and new password 
When user navigate account detail page from left panel
Then User updating back old password on account access section
Then user verify success message displayed after password update

