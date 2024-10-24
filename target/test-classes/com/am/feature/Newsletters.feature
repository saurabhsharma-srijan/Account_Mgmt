Feature: Verify to Subscribe for a newsletter 

Scenario: Verify to Subscribe a newsletter when navigate through left manu
Given FE user is able to login to FrontEnd
When User navigate newsletter page from left menu panel
Then User Verify to click on Subscribe button
Then User Verify Subscribe label change into Unsubscribe
Then User Verify to click on Unsubscribe button
Then User Verify Unsubscribe label change back into Subscribe


Scenario: Verify to Subscribe a newsletter when navigate through dashboard home
Given FE user is able to login to FrontEnd
When User navigate newsletter page from dashboard home
Then User Verify to click on Subscribe button
Then User Verify Subscribe label change into Unsubscribe
Then User Verify to click on Unsubscribe button
Then User Verify Unsubscribe label change back into Subscribe
