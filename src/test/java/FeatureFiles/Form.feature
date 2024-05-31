
Feature: Form


  Scenario: The visibility of the form fields
  Given Navigate to Url
  And Check the Fields on the Form
  Then Check the Registered Interested Button

  Scenario: Leaving the Required Field Blank
  Given Navigate to Url
  And Leave the Phone Number Field on the Form Blank
  Then Click Registered Interested Button

  Scenario: Invalid phone number entered
  Given Navigate to Url
  And Enter an invalid number in the Phone Number field on the form.
  Then Click Registered Interested Button

  @SmokeTest
  Scenario: Fill the Form
  Given Navigate to Url
  And Fill the Form
  Then Click Registered Interested Button
  Then Verify Success message

  @SmokeTest
  Scenario: Response Code Control in Api
    Given Get Request Data From Backend
    When  Check the Response Code




