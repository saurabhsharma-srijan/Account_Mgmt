Feature: Validate the Personal information section

Scenario: Verify the items available in Personal information section when navigate through left manu
Given FE user is able to login to FrontEnd
When user navigate account detail page from left panel
Then user verify items available in Personal information section 

Scenario: Verify to edit-update Personal information section
Given FE user is able to login to FrontEnd
When user navigate account detail page from left panel
Then user verify edit-update Personal information section
Then user verify success message display on personal info

Scenario: Verify to updating the old data in Personal information section 
Given FE user is able to login to FrontEnd
When user navigate account detail page from left panel
Then user edit-updating the old data in Personal information section 

Scenario: Verify the items available in Personal information section when navigate through dashboard home
Given FE user is able to login to FrontEnd
When user navigate account detail page from dashboard home
Then user verify items available in Personal information section 

