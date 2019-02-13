Feature: Outbreak counter

  Scenario: Single outbreak
    Given PARIS infection level is 3
    And outbreak counter is 0
    When PARIS gets infected
    Then the outbreak counter should be 1
#
  @occidental
  Scenario: Final outbreak of Armageddon
    Given PARIS infection level is 3
    And outbreak counter is 7
    When PARIS gets infected
    Then the outbreak counter should be 8
    And the game should be lost