Feature: Products



  @regression
  Scenario Outline: User Login
    When user should enter "<item>" to Search
    Then items should be displayed

    Examples:
      | item                 |
      | Nike Shoes For Women |


  Scenario Outline: User login and checking if all the dropdown are getting selected
    When user should enter "<item>" to Search
    And user should be able to click on every Dropdown
    Examples:
      |item  |
      | Nike Shoes For Women |

@smoke
  Scenario Outline: User login and checking if all the shoeSizes are getting selected

    When  user should enter "<item>" to Search
    And user should be able to click on all shoeSizes
    Examples:
      | item |
      | Nike Shoes For Women |

  @smoke
  Scenario Outline: User login and checking if a particular brandName can be selected
    When  user should enter "<item>" to Search
    And user should be able to click on "<Brand>"
    Examples:
      | item |               |Brand|
      | iphone cover for 15 | | Speck |

  @sneha
  Scenario Outline: User login and checking if a particular brandName can be selected which is less than a 30 dollar

    When  user should enter "<item>" to Search
    And user should be able to click on "<Brand>"
    Then user should add only those elements that are less than $30
    Examples:
      | item || Brand |
      | iphone cover for 15 | | Speck |


  @sneha
  Scenario Outline: User should only select those items that are pink in color

    When  user should enter "<item>" to Search
    And user should be able to click on "<Brand>"
    Then user should select "Pink" color
    Examples:
      | item || Brand |
      | Flask | | MILTON |

  @smoke
  Scenario Outline: User should only display those items that have color options

    When  user should enter "<item>" to Search
    And user should be able to click on "<Brand>"
    And user should select "<color>" if present

    Examples:
      | item || Brand | |color|
      | Flask | | MILTON | |Pink|
      | Hydro Flask | |Takeya| |Black|

  @sneha
  Scenario Outline: User should navigate to other pages if product not found in current page

    When  user should enter "<item>" to Search
    Then user should check the product "<description>" and find the product
#    And user should add that item to the cart
    Examples:
      | item || description |
      | Hydro Flask | |64 Oz Growler Birch|