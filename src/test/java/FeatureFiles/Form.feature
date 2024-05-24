Feature: Form

  Scenario: Fill the Form
    Given Navigate to Url
    And Fill the Form
    Then Click Registered Interested Button
    Then Verify Success message

    Scenario: Response Code Control in Api
      Given Get Request Data From Backend
      When  Check the Response Code
