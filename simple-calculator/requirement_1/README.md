# Requirement 1

We start by adding a list of numbers as string, separated by commas, like in `1,2`. This shall be our first requirement.

The Simple Calculator

 1. should add integers from an input string, separated by a coma, as in "1,2"
 3. should return 0 when input is empty
 4. should return 0 when input is blank
 5. when a list contains a single element, it should return this element
 6. when a list contains more than 2 elements, it should not process addition
 7. when elements from input are not integers, it should not process addition

Although, this kata is technically simple, we introduce several notions on our path to craftsmanship:
 1. Drive your devs by tests (TDD)
 2. Keep the code as simple as your requirement allows (YAGNI)
 3. Refactor your code **BEFORE** introducing a new functionality

NB: Our second requirement shall be to be able to perform any operation performed on integer that computes to an integer, namely addition, subtraction and multiplication.
