
Feature: Frontend

  Background:
  Given Navigate to Url

  Scenario: The visibility of the form fields
  And Check the Fields on the Form
  Then Check the Registered Interested Button

  Scenario: Leaving the Required Field Blank
  And Leave the Phone Number Field on the Form Blank
  Then Click Registered Interested Button

  Scenario: Invalid phone number entered
  And Enter an invalid number in the Phone Number field on the form.
  Then Click Registered Interested Button

  @Priority=1
  @SmokeTest
  Scenario: Successful registration of the form
  And Fill the Form
  Then Click Registered Interested Button
  Then Verify Success message






