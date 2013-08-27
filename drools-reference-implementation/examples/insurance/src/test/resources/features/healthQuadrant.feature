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

Given a member Jess

And Jess has condition "depression" of degree "severe"

And Jess has condition "eatingDisorder" of degree "severe"

When determining the health quadrant for Jess

Then Jess should be placed in Quadrant 2

And Jess is assigned a behavioral health case manager


@Quadrant3
Scenario: Quadrant 3

Given a member Jane

And Jane has condition "asthma" of degree "severe"

And Jane has condition "diabetes" of degree "mild"

And Jane has condition "cardiovascular" of degree "mild"

And Jane has condition "depression" of degree "mild"

When determining the health quadrant for Jane

Then Jane should be placed in Quadrant 3

And Jane is assigned a specialty disease care manager


@Quadrant4
Scenario: Quadrant 4

Given a member Jack

And Jack has condition "asthma" of degree "severe"

And Jack has condition "diabetes" of degree "mild"

And Jack has condition "cardiovascular" of degree "mild"

And Jack has condition "depression" of degree "mild"

And Jack has condition "anxiety" of degree "severe"

When determining the health quadrant for Jack

Then Jack should be placed in Quadrant 4

And Jack is assigned a specialty disease care manager

And Jack is assigned a behavioral health case manager