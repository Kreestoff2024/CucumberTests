Feature: Tests aux limites sur champs Phone, Subject et Message


  Scenario Outline: Test sous les limites inférieures
    Given Je voudrais envoyer un message
    When Je remplis le formulaire avec des données valides
    And Je rends le champ "<field>" invalide avec <length> caractères
    And J'appuie sur Submit
    Then On voit "<error message>" affiché
    Examples:
      | field   | length    | error message                                  |
      | Phone   | 10        | Phone must be between 11 and 21 characters.    |
      | Subject | 4         | Subject must be between 5 and 100 characters.  |
      | Message | 19        | Message must be between 20 and 2000 characters.|


  Scenario Outline: Test au-dessus des limites supérieures
    Given Je voudrais envoyer un message
    When Je remplis le formulaire avec des données valides
    And Je rends le champ "<field>" invalide avec <length> caractères
    And J'appuie sur Submit
    Then On voit "<error message>" affiché
    Examples:
      | field   | length    | error message                                  |
      | Phone   | 22        | Phone must be between 11 and 21 characters.    |
      | Subject | 101       | Subject must be between 5 and 100 characters.  |
      | Message | 2001      | Message must be between 20 and 2000 characters.|


  Scenario Outline: Test aux limites inférieures valides (1)
    Given Je voudrais envoyer un message
    When Je remplis le formulaire avec des données valides
    And Je rends le champ "<field>" valide avec <length> caractères
    And J'appuie sur Submit
    Then La phrase "as soon as possible." est affichée
    Examples:
      | field   | length  |
      | Phone   | 11      |
      | Subject | 5       |
      | Message | 20      |


  Scenario Outline: Test aux limites inférieures valides (2)
    Given Je voudrais envoyer un message
    When Je remplis le formulaire avec des données valides
    And Je rends le champ "<field>" valide avec <length> caractères
    And J'appuie sur Submit
    Then La phrase "as soon as possible." est affichée
    Examples:
      | field   | length  |
      | Phone   | 12      |
      | Subject | 6       |
      | Message | 21      |


  Scenario Outline: Test aux limites supérieures valides (1)
    Given Je voudrais envoyer un message
    When Je remplis le formulaire avec des données valides
    And Je rends le champ "<field>" valide avec <length> caractères
    And J'appuie sur Submit
    Then La phrase "as soon as possible." est affichée
    Examples:
      | field   | length  |
      | Phone   | 20      |
      | Subject | 99      |
      | Message | 1999    |


  Scenario Outline: Test aux limites supérieures valides (2)
    Given Je voudrais envoyer un message
    When Je remplis le formulaire avec des données valides
    And Je rends le champ "<field>" valide avec <length> caractères
    And J'appuie sur Submit
    Then La phrase "as soon as possible." est affichée
    Examples:
      | field   | length  |
      | Phone   | 21      |
      | Subject | 100     |
      | Message | 2000    |