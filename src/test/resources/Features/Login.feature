@sanity
Feature: Valid Login feature

Background: 
Read configuration

Scenario: valid Login
Given : Application should be launched with <url>
When : user enters valid userid and password
And : user clicks on login button
Then : user should be navigated on home page
And : user can see logout link available at home page
Then close browser

@run
Scenario Outline: valid Login
Given : Application should be launched with <url>
When : user enters valid "<UserName>" and password "<Password>"
And : user clicks on login button
Then close browser
Examples:
|UserName | Password |
|admin1   |admin1    |
#|admin2   |admin2    |
#|admin3   |admin3    |

