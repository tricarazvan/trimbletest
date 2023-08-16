#Author: razvan.prepelita@gmail.com
Feature: RepositoryInformation

  @tag1
  Scenario: Gather Repository Information
    Given the user is on the SeleniumHQ repository page
    When the user opens the Code dialog
    Then the repository clone URL is obtained from the input field
    And the number of releases is obtained
    Then the gathered information is represented as JSON to file

  @tag2
  Scenario: Retrieve Issues
    Given the user is on the SeleniumHQ repository page
    When user open Issues tab
    And the user clears the search field and enters "sort:comments-desc"
    And user press the Label filter
    And the user filters by the label "C-java"
    And the user clicks the Open button
    Then the user retrieves "Title" and add it to JSON

