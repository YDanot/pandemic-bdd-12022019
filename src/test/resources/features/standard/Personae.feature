Feature: Standard Definition

  Scenario: Occident network definition

#             (LONDON)------------------(ESSEN)
#            /    \                     /  |
#          /         \                /    |
#        /              \           /      |
#  (NEW-YORK)              (PARIS)         |
#        \              /    |     \       |
#          \         /       |        \    |
#            \    /          |           \ |
#            (MADRID)        |          (MILAN)
#                \           |
#                   \        |
#                      \     |
#                         \  |
#                         (ALGIERS)

  Scenario: Occidental sub-network (quite satisfying)
    Given the occident initial sub-network
    Then the network should be:
      |          | New_york | Algiers | Madrid | London | Essen | Milan | PARIS |
      | PARIS    |          | x       | x      | x      | x     | x     |       |
      | Milan    |          |         |        |        | x     |       |       |
      | Essen    |          |         |        | x      |       |       |       |
      | London   | x        |         |        |        |       |       |       |
      | Madrid   | x        | x       |        |        |       |       |       |
      | Algiers  |          |         |        |        |       |       |       |
      | New_york |          |         |        |        |       |       |       |

    And all cities should have the infection levels of 0