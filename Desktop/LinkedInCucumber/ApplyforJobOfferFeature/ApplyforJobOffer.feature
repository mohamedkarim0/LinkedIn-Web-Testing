Feature: Apply for Job Offer
  Scenario: User applies for the Treasury Intern job on LinkedIn
    Given User is in the LinkedIn homepage "https://www.linkedin.com/feed/"
    When User types email and password
    And User clicks on Jobs icon
    And User clicks on Show All
    And User chooses the job "Treasury Intern"
    And User clicks on the Easy Apply button
    And User types the address "Cairo"
    And User clicks on submit
    Then Verify the job is applied successfully