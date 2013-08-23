Feature: Determine Health Quadrant

Scenario: determine quadrant

Given: Member with:
| memberID | physicalHealth | behavioralHealth |
|    0     |      0.0       |        0.0       |
|    1     |      30.0      |        30.0      |
|    2     |      0.0       |        30.0      |
|    3     |      30.0      |        0.0       |
|    4     |      15.0      |        15.0      |

When determining quadrant

Then quadrant should be:
| quadrant |
|    1     |
|    4     |
|    2     |
|    3     |
|    4     |