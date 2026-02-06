Feature: Envoi d'un message avec un format d'e-mail non valide

  Scenario Outline: Format d'e-mail non valide
    Given Je veux envoyer un message
    When Je saisis "Chris" dans Name
    And Je saisis "<email>" dans Email
    And Je saisis "12345678912" dans Phone
    And Je saisis "Hello" dans Subject
    And Je saisis "Je suis le meilleur testeur de l'ouest" dans Message
    And Je clique sur Submit
    Then On peut voir "must be a well-formed email address" sur la page
  Examples:
    |email     |
    |chris.com |
    |chris@    |
    |chris@.com|
    |chris@abc |
    |@abc.com  |