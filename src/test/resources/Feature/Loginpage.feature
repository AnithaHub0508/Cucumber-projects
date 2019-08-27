Feature: Validate the automationtesting site

  Scenario: Validate Register details
    Given User is on Registration page
    When User enters the details  
    | Ani       | Sandi    | Chennai | ammuani@gmail.com | 7829392389 | Sandianitha@23  | Sandianitha@23         |
    Then verify url contains Register

         
