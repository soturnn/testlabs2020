
  Feature: search
    Scenario: Search in KannonDance
      Given open browser
      Given open page "https://www.kannondance.ru/"
      When search in KannonDance "contemporary"
      Then first result in KannonDance is "Курс с нуля по contemporary dance"
      And close browser

    Scenario: Search in Ossu
      Given open browser
      Given open page "https://github.com/ossu/computer-science"
      When search in Ossu "course"
      Then first result in Ossu is "CHANGELOG.md"
      And close browser


    Scenario: Search in KinoPoisk
      Given open browser
      Given open page "https://www.kinopoisk.ru//"
      When search in KinoPoisk "Кролик Джоджо"
      Then first result in KinoPoisk is "Кролик Джоджо 2019"
      And close browser







