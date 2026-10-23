@feature_login
Feature: Login Feature
@Smoke @Login
Scenario: Valid Login Test
Given user is on Login Page
When user enters valid username and password
Then user should able to log in successfully

@regression @Login
Scenario: InValid Login Test
Given user is on Login Page
When user enters invalid username and password
Then error must be displayed