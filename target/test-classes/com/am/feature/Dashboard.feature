Feature: Verify the sections available on dashboard home page (Newspaper, Newsletters, Account Details) 

@dashboard
Scenario: Verify the Newspaper self service block available
Given FE user is able to login to FrontEnd
When user navigate dashboard home page 
Then user verify dashboard menu is highlighted
Then user verify Newspaper self service block

@dashboard
Scenario: Verify the Account Details block available
Given FE user is able to login to FrontEnd
When user navigate dashboard home page 
Then user verify Account Details block

@dashboard
Scenario: Verify the Newsletters block available
Given FE user is able to login to FrontEnd
When user navigate dashboard home page 
Then user verify Newsletters block

