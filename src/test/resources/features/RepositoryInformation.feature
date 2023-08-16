#Author: razvan.prepelita@gmail.com
Feature: RepositoryInformation

  @tag1
  Scenario: Gather Repository Information
    Given the user is on the SeleniumHQ repository page
    When the user opens the Code dialog
    Then the repository clone URL is obtained from the input field
    And the number of releases is obtained
    And the "url" is added to JSON file "selenium-meta-data.json"
    And the "releases" is added to JSON file "selenium-meta-data.json"

  @tag2
  Scenario: Retrieve Issues
    Given the user is on the SeleniumHQ repository page
    When user open Issues tab
    And the user clears the search field and enters "sort:comments-desc"
    And user press the Label filter
    And the user filters by the label "C-java"
    Then the user clicks the Open button
    And the "title" is added to JSON file "most-discussed-java-issue.json"
    And the "numberOfComments" is added to JSON file "most-discussed-java-issue.json"
    #And the "issueId" is added to JSON file "most-discussed-java-issue.json"
    #And the "author" is added to JSON file "most-discussed-java-issue.json"
    #And the "dateCreated" is added to JSON file "most-discussed-java-issue.json"
