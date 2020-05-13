Feature: Wallapop automated test

  @Kingtest
  Scenario: user login with Facebook on Wallapop
    Given Wallapop apk has been installed and launched
    And the user has opened pre-login page
    And the user selects button 'Continue with Facebook'
    When the user introduces valid Facebook credentials
    And the user taps login button
    Then the user successfully logs in