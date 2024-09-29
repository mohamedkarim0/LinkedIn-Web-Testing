Feature: Reopen Job Offer
  Scenario: User reopens a closed job offer on LinkedIn successfully
    Given User is on the LinkedIn homepage "https://www.linkedin.com/feed/"
    When User enters email and password
    And User clicks on the Jobs icon
    And User clicks on Manage job posts
    And User selects Closed
    And User selects the requested job offer "Fresh Software Engineer"
    And User clicks ...
    Then Verify the job offer is reopened successfully
