Feature: Wallapop automated test

  @Kingtest
  Scenario: user login with Facebook on Wallapop
    Given Wallapop apk has been installed and launched
    And the user has opened pre-login page
    And the user selects button Continue with Facebook
    When the user types valid Facebook credentials and taps login button
    Then the user will be successfully logged in