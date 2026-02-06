Feature: Envoi d'un message avec un champ vide

  Scenario: Envoi d'un message sans remplir le champ Name
    Given Je suis sur la page du site
    When Je rentre "" dans le champ Name
    And Je rentre "chris@abc.com" dans le champ Email
    And Je rentre "12345678912" dans le champ Phone
    And Je rentre "Hello" dans le champ Subject
    And Je rentre "Je suis le meilleur testeur de l'ouest" dans Message
    And J'appuie sur le bouton Submit
    Then On voit "Name may not be blank" sur la page

  Scenario: Envoi d'un message sans remplir le champ Email
    Given Je suis sur la page du site
    When Je rentre "Chris" dans le champ Name
    And Je rentre "" dans le champ Email
    And Je rentre "12345678912" dans le champ Phone
    And Je rentre "Hello" dans le champ Subject
    And Je rentre "Je suis le meilleur testeur de l'ouest" dans Message
    And J'appuie sur le bouton Submit
    Then On voit "Email may not be blank" sur la page

  Scenario: Envoi d'un message sans remplir le champ Phone
    Given Je suis sur la page du site
    When Je rentre "Chris" dans le champ Name
    And Je rentre "chris@abc.com" dans le champ Email
    And Je rentre "" dans le champ Phone
    And Je rentre "Hello" dans le champ Subject
    And Je rentre "Je suis le meilleur testeur de l'ouest" dans Message
    And J'appuie sur le bouton Submit
    Then On voit "Phone must be between 11 and 21 characters." sur la page

  Scenario: Envoi d'un message sans remplir le champ Subject
    Given Je suis sur la page du site
    When Je rentre "Chris" dans le champ Name
    And Je rentre "chris@abc.com" dans le champ Email
    And Je rentre "12345678912" dans le champ Phone
    And Je rentre "" dans le champ Subject
    And Je rentre "Je suis le meilleur testeur de l'ouest" dans Message
    And J'appuie sur le bouton Submit
    Then On voit "Subject may not be blank" sur la page

  Scenario: Envoi d'un message sans remplir la boîte Message
    Given Je suis sur la page du site
    When Je rentre "Chris" dans le champ Name
    And Je rentre "chris@abc.com" dans le champ Email
    And Je rentre "12345678912" dans le champ Phone
    And Je rentre "Hello" dans le champ Subject
    And Je rentre "" dans Message
    And J'appuie sur le bouton Submit
    Then On voit "Message may not be blank" sur la page