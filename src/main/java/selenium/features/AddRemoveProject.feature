Feature: Add and Remove Project

  @AddRemoveProject
  Scenario: Add Project
    Given I navigate to Codacy Page
    And I login with google account
    And I expected to My Projects page
    And I click on add project button
    When I select project
    And I expected to My Projects page
    Then The project should appear on My Projects page
    And I open the project
    And I expected to be on Dashboard page
    And I go to settings
    And I expected to be on Settings page
    When I remove the project
    Then I expected to My Projects page
    And The project shouldn't appear on My Projects page