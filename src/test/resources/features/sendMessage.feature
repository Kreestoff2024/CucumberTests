Feature: Envoi d'un message

  Scenario: Envoi d'un message avec champs valides
    Given Je suis sur la page principale
    When Je saisis "Chris" dans le champ Name
    And Je saisis "chris@abc.com" dans le champ Email
    And Je saisis "12345678912" dans le champ Phone
    And Je saisis "Hello" dans le champ Subject
    And Je saisis "Je suis le meilleur testeur de l'ouest" dans le champ Message
    And Je clique sur le bouton Submit
    Then Je vois "Hello" sur la page