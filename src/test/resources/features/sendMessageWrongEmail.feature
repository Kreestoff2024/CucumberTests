Feature: Envoi d'un message avec un format d'e-mail non valide

  Scenario: Format d'e-mail non valide 1
    Given Je veux envoyer un message
    When Je saisis "Chris" dans Name
    And Je saisis "chris.com" dans Email
    And Je saisis "12345678912" dans Phone
    And Je saisis "Hello" dans Subject
    And Je saisis "Je suis le meilleur testeur de l'ouest" dans Message
    And Je clique sur Submit
    Then On peut voir "must be a well-formed email address" sur la page


  Scenario: Format d'e-mail non valide 2
    Given Je veux envoyer un message
    When Je saisis "Chris" dans Name
    And Je saisis "@abc.com" dans Email
    And Je saisis "12345678912" dans Phone
    And Je saisis "Hello" dans Subject
    And Je saisis "Je suis le meilleur testeur de l'ouest" dans Message
    And Je clique sur Submit
    Then On peut voir "must be a well-formed email address" sur la page

  Scenario: Format d'e-mail non valide 3
    Given Je veux envoyer un message
    When Je saisis "Chris" dans Name
    And Je saisis "chris@" dans Email
    And Je saisis "12345678912" dans Phone
    And Je saisis "Hello" dans Subject
    And Je saisis "Je suis le meilleur testeur de l'ouest" dans Message
    And Je clique sur Submit
    Then On peut voir "must be a well-formed email address" sur la page

  Scenario: Format d'e-mail non valide 4
    Given Je veux envoyer un message
    When Je saisis "Chris" dans Name
    And Je saisis "chris@.com" dans Email
    And Je saisis "12345678912" dans Phone
    And Je saisis "Hello" dans Subject
    And Je saisis "Je suis le meilleur testeur de l'ouest" dans Message
    And Je clique sur Submit
    Then On peut voir "must be a well-formed email address" sur la page

  Scenario: Format d'e-mail non valide 5
    Given Je veux envoyer un message
    When Je saisis "Chris" dans Name
    And Je saisis "chris@abc" dans Email
    And Je saisis "12345678912" dans Phone
    And Je saisis "Hello" dans Subject
    And Je saisis "Je suis le meilleur testeur de l'ouest" dans Message
    And Je clique sur Submit
    Then On peut voir "must be a well-formed email address" sur la page