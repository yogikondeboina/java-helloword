Feature: Determine Health Quadrant

@Quadrant
Scenario: determine quadrant

Given Member with:
| memberID | physicalHealth | behavioralHealth |
|    0     |      0.0       |        0.0       |
|    1     |      30.0      |        30.0      |
|    2     |      0.0       |        30.0      |
|    3     |      30.0      |        0.0       |
|    4     |      15.0      |        15.0      |

When determining quadrant

Then quadrant should be:
| memberID | quadrant |
|     0    |	1     |
|     1    |	4     |
|     2    |	2     |
|     3    |	3     |
|     4    |	4     |