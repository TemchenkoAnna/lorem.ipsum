Feature: test
  As a user
  I want to test site functionality

  Scenario Outline: Check that the word "рыба" correctly appears in the first paragraph
    Given User opens '<homePage>' page
    When User switches to Russian language
    Then User verifies that the text of the first  element, contains  word '<keyword>'

    Examples:
      | homePage            | keyword |
      | https://lipsum.com/ | рыба    |


  Scenario Outline: Check that default setting result in text starting with Lorem ipsum
    Given User opens '<homePage>' page
    When User presses button “Generate Lorem Ipsum”
    Then User checks that the first paragraph starts with '<keyword>'

    Examples:
      | homePage            | keyword                                                 |
      | https://lipsum.com/ | Lorem ipsum dolor sit amet, consectetur adipiscing elit |


  Scenario Outline:  Check that Lorem Ipsum is generated with correct words size
    Given User opens '<homePage>' page
    And User clicks on button Words
    When User inputs '<keyword>' into the number field
    And User presses button “Generate Lorem Ipsum”
    Then User checks the result has '<keyword>' words


    Examples:
      | homePage            | keyword |
      | https://lipsum.com/ | 10      |
      | https://lipsum.com/ | -1      |
      | https://lipsum.com/ | 0       |
      | https://lipsum.com/ | 5       |
      | https://lipsum.com/ | 20      |

  Scenario Outline:  Check that Lorem Ipsum is generated with correct bytes size
    Given User opens '<homePage>' page
    And User clicks on button bytes
    When User inputs '<keyword>' into the number field
    And User presses button “Generate Lorem Ipsum”
    Then User checks the result has '<keyword>' words


    Examples:
      | homePage            | keyword |
      | https://lipsum.com/ | 5       |
      | https://lipsum.com/ | 10      |
      | https://lipsum.com/ | 100     |


  Scenario Outline: Check that result in text is no longer starts with Lorem ipsum
    Given User opens '<homePage>' page
    And User unchecks start with Lorem Ipsum checkbox
    When User presses button “Generate Lorem Ipsum”
    Then User checks that the first paragraph no longer starts with '<keyword>'

    Examples:
      | homePage            | keyword    |
      | https://lipsum.com/ | Lorem ipsum |

  Scenario Outline: Check that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%
    Given User opens '<homePage>' page
    When User presses button “Generate Lorem Ipsum”
    And User gets text from each paragraph and determine the number of paragraphs containing the word '<keyword>'

    Examples:
      | homePage            | keyword    |
      | https://lipsum.com/ | lorem |