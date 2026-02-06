Feature: Tests aux limites

  Scenario: Test sous la limite inférieure (11) du champ Phone
    Given Je voudrais envoyer un message
    When J'écris "Chris" dans le champ Name
    And J'écris "chris@abc.com" dans le champ Email
    And J'écris "1234567891" dans le champ Phone
    And J'écris "Hello" dans le champ Subject
    And J'écris "Je suis le meilleur testeur de l'ouest" dans la boîte Message
    And J'appuie sur Submit
    Then On voit "Phone must be between 11 and 21 characters." affiché

  Scenario: Test sous la limite inférieure (5) du champ Subject
    Given Je voudrais envoyer un message
    When J'écris "Chris" dans le champ Name
    And J'écris "chris@abc.com" dans le champ Email
    And J'écris "12345678912" dans le champ Phone
    And J'écris "Hell" dans le champ Subject
    And J'écris "Je suis le meilleur testeur de l'ouest" dans la boîte Message
    And J'appuie sur Submit
    Then On voit "Subject must be between 5 and 100 characters." affiché

  Scenario: Test sous la limite inférieure (20) du champ Message
    Given Je voudrais envoyer un message
    When J'écris "Chris" dans le champ Name
    And J'écris "chris@abc.com" dans le champ Email
    And J'écris "12345678912" dans le champ Phone
    And J'écris "Hello" dans le champ Subject
    And J'écris "Je suis le meilleur" dans la boîte Message
    And J'appuie sur Submit
    Then On voit "Message must be between 20 and 2000 characters." affiché