Feature: Determine Physical Health and Behavioral Health

@PhysicalHealth
Scenario: Determine Physical Health
 
Given Member with:
| asthmaRating | diabetesRating | cardiovascularRating | 
|     10.0     |     10.0       |         10.0         | 
|     5.0      |     5.0        |         5.0          |
|     0.0      |     0.0        |         0.0          |
|     0.0      |     0.0        |         10.0         |
|     0.0      |     10.0       |         0.0          |
|     10.0     |     0.0        |         0.0          |
|     8.0      |     8.0        |         8.0          |



When determining PH risk level
  
Then PH risk level should be:
| physicalHealth |
|      30.0      |
|      15.0      |
|      0.0       |
|      10.0      |
|      10.0      |
|      10.0      |
|      24.0      |

  
  
@BehavioralHealth
Scenario: Determine Behavioral Health
 
Given Member with:
| depressionRating | anxietyRating | eatingDisorderRating | 
|       10.0       |     10.0      |         10.0         | 
|       5.0        |     5.0       |         5.0          |
|       0.0        |     0.0       |         0.0          |
|       0.0        |     0.0       |         10.0         |
|       0.0        |     10.0      |         0.0          |
|       10.0       |     0.0       |         0.0          |
|       8.0        |     8.0       |         8.0          |
  
When determining BH risk level
  
Then BH risk level should be:
| behavioralHealth |
|        30        |
|       15.0       |
|       0.0        |
|       10.0       |
|       10.0       |
|       10.0       |
|       24.0       |
  