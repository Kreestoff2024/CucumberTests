Feature: Envoi d'un message avec un champ vide

  Scenario Outline: Envoi d'un message sans remplir les champs
    Given Je suis sur la page du site
    When Je rentre "<name>" dans le champ Name
    And Je rentre "<email>" dans le champ Email
    And Je rentre "<phone>" dans le champ Phone
    And Je rentre "<subject>" dans le champ Subject
    And Je rentre "<message>" dans Message
    And J'appuie sur le bouton Submit
    Then On voit "<error message>" sur la page
  Examples:
    |name |email        |phone      |subject|message                    |error message           |
    |     |chris@abc.com|12345678912|Hello  |Je suis le meilleur testeur|Name may not be blank   |
    |Chris|             |12345678912|Hello  |Je suis le meilleur testeur|Email may not be blank  |
    |Chris|chris@abc.com|           |Hello  |Je suis le meilleur testeur|Phone may not be blank  |
    |Chris|chris@abc.com|12345678912|       |Je suis le meilleur testeur|Subject may not be blank|
    |Chris|chris@abc.com|12345678912|Hello  |                           |Message may not be blank|