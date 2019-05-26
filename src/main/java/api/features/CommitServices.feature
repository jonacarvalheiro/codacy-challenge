Feature: Commit API

  @CommitStatus
  Scenario: Get commit status
    Given I do a commit on my project
    Then I make a commit status api request and the status should be analysed