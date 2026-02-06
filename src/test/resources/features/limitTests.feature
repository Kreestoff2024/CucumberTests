Feature: Tests aux limites sur champs Phone, Subject et Message

  Scenario Outline: Test sous les limites inférieures
    Given Je voudrais envoyer un message
    When J'écris "Chris" dans le champ Name
    And J'écris "chris@abc.com" dans le champ Email
    And J'écris "<phone>" dans le champ Phone
    And J'écris "<subject>" dans le champ Subject
    And J'écris "<message>" dans la boîte Message
    And J'appuie sur Submit
    Then On voit "<error message>" affiché
  Examples:
    |phone      |subject|message                    |error message                                  |
    |1234567891 |Hello  |Je suis le meilleur testeur|Phone must be between 11 and 21 characters.    |
    |12345678912|Hell   |Je suis le meilleur testeur|Subject must be between 5 and 100 characters.  |
    |12345678912|Hello  |Je suis le meilleur        |Message must be between 20 and 2000 characters.|