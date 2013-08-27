Feature: Determine health quadrant

@Quadrant1
Scenario: Quadrant 1

Given a member Joe

And Joe has condition "asthma" of degree "mild"

And Joe has condition "depression" of degree "mild"

When determining the health quadrant for Joe

Then Joe should be placed in Quadrant 1

And Joe receives standard care


@Quadrant2
Scenario: Quadrant 2

Given a member Joe

And Joe has condition "depression" of degree "severe"

And Joe has condition "eatingDisorder" of degree "severe"

When determining the health quadrant for Joe

Then Joe should be placed in Quadrant 2

And Joe is assigned a behavioral health case manager


@Quadrant3
Scenario: Quadrant 3

Given a member Joe

And Joe has condition "asthma" of degree "severe"

And Joe has condition "diabetes" of degree "mild"

And Joe has condition "cardiovascular" of degree "mild"

And Joe has condition "depression" of degree "mild"

When determining the health quadrant for Joe

Then Joe should be placed in Quadrant 3

And Joe is assigned a specialty disease care manager


@Quadrant4
Scenario: Quadrant 4

Given a member Joe

And Joe has condition "asthma" of degree "severe"

And Joe has condition "diabetes" of degree "mild"

And Joe has condition "cardiovascular" of degree "mild"

And Joe has condition "depression" of degree "mild"

And Joe has condition "anxiety" of degree "severe"

When determining the health quadrant for Joe

Then Joe should be placed in Quadrant 4

And Joe is assigned a specialty disease care manager

And Joe is assigned a behavioral health case manager