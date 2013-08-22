Feature: determine health quadrant based on Physical Health & Behavioral Health Score

Scenario: determine quadrant

Given: Member with:
| physicalHealth | behavioralHealth |
|      0.0       |        0.0       |
|      30.0      |        30.0      |
|      0.0       |        30.0      |
|      30.0      |        0.0       |
|      15.0      |        15.0      |

When determining quadrant

Then quadrant should be:
| quadrant |
|    1     |
|    4     |
|    2     |
|    3     |
|    4     |