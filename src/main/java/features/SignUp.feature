Feature: User Sign-Up Functionality

  @SignUp @InvalidSignUp
  Scenario: Unsuccessful Sign-Up with Invalid Credentials
    Given User is on the Sign-Up page
    When User enters the following credentials:
      | Username  | Password |
      |           | Jyothsna123 |  
       
    And Clicks on the Sign-Up button
    Then An error message should be displayed

    