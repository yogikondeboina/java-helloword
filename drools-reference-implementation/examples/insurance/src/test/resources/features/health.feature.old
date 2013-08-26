Feature: Determine Physical Health and Behavioral Health

@PhysicalHealth
Scenario: Determine Physical Health
 
Given Member with PH:
| memberID | asthmaRating | diabetesRating | cardiovascularRating | 
|    0     |     10.0     |     10.0       |         10.0         | 
|    1     |     5.0      |     5.0        |         5.0          |
|    2     |     0.0      |     0.0        |         0.0          |
|    3     |     0.0      |     0.0        |         10.0         |
|    4     |     0.0      |     10.0       |         0.0          |
|    5     |     10.0     |     0.0        |         0.0          |
|    6     |     8.0      |     8.0        |         8.0          |



When determining PH risk level
  
Then PH risk level should be:
| memberID | physicalHealth |
|   0 	   |     30.0       |
|   1      |     15.0       |
|   2      |     0.0        |
|   3      |     10.0       |
|   4      |     10.0       |
|   5      |     10.0       |
|   6      |     24.0       |

  
  
@BehavioralHealth
Scenario: Determine Behavioral Health
 
Given Member with BH:
| memberID | depressionRating | anxietyRating | eatingDisorderRating | 
|    0     |       10.0       |     10.0      |         10.0         | 
|    1     |       5.0        |     5.0       |         5.0          |
|    2     |       0.0        |     0.0       |         0.0          |
|    3     |       0.0        |     0.0       |         10.0         |
|    4     |       0.0        |     10.0      |         0.0          |
|    5     |       10.0       |     0.0       |         0.0          |
|    6     |       8.0        |     8.0       |         8.0          |
  
When determining BH risk level
  
Then BH risk level should be:
| memberID | behavioralHealth  |
|   0 	   |     30.0          |
|   1      |     15.0          |
|   2      |     0.0           |
|   3      |     10.0          |
|   4      |     10.0          |
|   5      |     10.0          |
|   6      |     24.0          | 