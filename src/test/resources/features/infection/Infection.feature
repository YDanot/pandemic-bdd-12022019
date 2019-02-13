Feature: Infection

  Scenario Outline: Infection number <current-infection-level>
    Given PARIS infection level is <previous-infection-level>
    When PARIS gets infected
    Then infection level of PARIS should be <current-infection-level>
    Examples:
      | previous-infection-level | current-infection-level |
      | 0                        | 1                       |
      | 1                        | 2                       |
      | 2                        | 3                       |

  Scenario: don't increase infection on fourth infection
    Given PARIS infection level is 3
    When PARIS gets infected
    Then infection level of PARIS should remain at 3
