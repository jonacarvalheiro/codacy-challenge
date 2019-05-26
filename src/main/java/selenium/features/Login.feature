Feature: Login

  @Login
  Scenario: Login with Google account
    Given I navigate to Codacy Page
    When I login with google account
    Then I expected to My Projects page