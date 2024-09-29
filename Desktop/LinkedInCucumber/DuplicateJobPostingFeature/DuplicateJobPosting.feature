Feature: Duplicate Job Posting
  Scenario: Verify duplicate job posting handling
    Given User navigate to "https://www.linkedin.com/feed/"
    When User sign in with username and password
    Then User should be on the home page
    When User navigates to job postings
    And User select a job posting
    Then User should see the feedback option
    When User provides job title "Software Engineer IIIIII"
    And User provides company name "Egyineer"
    And User chooses workplace type
    And User types job location "H91 HDF8, Galway, County Galway, Ireland"
    Then User should not be able to submit the job posting
