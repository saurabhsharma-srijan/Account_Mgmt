Feature: Create and Delete temporary stop on newspaper self service page 

Scenario: Verify to Create temporary stop on newspaper self service page 
Given FE user is able to login to FrontEnd
When user navigate newspaper self service page from left menu panel
Then user verify to Create temporary stop on newspaper self service page 
Then user verify success message displaying for created a temporary stop


Scenario: Verify to delete temporary stop on newspaper self service page 
Given FE user is able to login to FrontEnd
When user navigate newspaper self service page from left menu panel
Then user verify to delete temporary stop on newspaper self service page 
Then user verify success message displaying for deleted a temporary stop
