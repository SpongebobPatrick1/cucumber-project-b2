Feature: Passing multiple parameters to the same step

  @jaad
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following item
      | loop academy |
      | java         |
      | selenium     |
      | cucumber bdd |
      | sql          |
      | nadir        |
      | zahid        |
      | anna         |
      | jaad         |
# spaces between | | do NOT matter
  # spaces in steps DO matter