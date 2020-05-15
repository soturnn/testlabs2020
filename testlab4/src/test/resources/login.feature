Feature: login
  Scenario:
    Given open browser
    Given open page "https://github.com/ossu/computer-science"
    When log in to github account with username "soturnn@gmail.com" and password "1234"
    And close browser

  Scenario:
    Given open browser
    Given open page "https://www.kinopoisk.ru//"
    When log in to kinopoisk account with username "name" and password "12345"
    And close browser