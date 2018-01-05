
Feature: Test Facebook Smoke Scenario



Background: Test login with valid credentials
     Given Open chrome and start application
     When I enter valid  "8788948300" and "ashikalimaner"
     Then  user should be able to login successfully
  
@FriendRequest
Scenario: Search and Find friend on facebook
     Given Enter search in Search Box
       | ashikali |
     When  click search
     Then  I should get my friend in the list and send him friend request
     

@ProfilePicChange    
Scenario: Change profile Photo
    Given Click Profile Photo
    When steps done to add photo
    Then Add from given path
    Then click add Profile Photo
     
 
         