# Requirement 1 - Refactor 1

## Context

**Requirement 1** was simply to add 2 numbers from a string, formatted as a list separated by a comma.

In **requirement 2** we will be asked to introduce two new operations: subtraction and multiplication. We won't have input strings like `"2,3"` anymore, but rather `"2+3"` or `"2*3"`. Therefore, we will need to introduce the notion of operation in our application.

Before jumping to that, we need to refactor our code. This is a typical situation, where before introducing a new functionality to our application, we first need to refactor our code in order to let the system accept it.

At the end of our refactor, the application will be functionally equivalent to what it was before. However, we would have introduce a higher degree of abstraction "just in time".

The introduction of the new functionality will then be much easier and natural.

## Approach

TDD is the appropriate method ot perform a refactor.

We will start from where we ended at **requirement 1** and will first develop our parser using test approach.

Once our parser is running, we will re-write our tests on SimpleCalculator class, breaking them all. Then we will introduce our parser in our class.

The same approach will be used in **refactor 2** for introducing the notion of _addition operation_.