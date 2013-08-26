Feature: Determine health quadrant

@HealthQuadrant
Scenario: Determine quadrant for low BH

Given a member Joe

And Joe has condition "asthma" of degree "mild"

And Joe has condition "depression" of degree "severe"

When determining the health quadrant for Joe

Then Joe should be placed in Quadrant 4

And a call should be scheduled for 2 days later