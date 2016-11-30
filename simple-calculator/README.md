# Simple Calculator

This Kata is a free adaptation of the simple calculator kata.

We suggest two ways to proceed. One is by taking one step at the time by following the requirements in the sub projects. The second is by implementing directly the final requirements as they are listed below. Both ways are interesting:

 - In the step by step version, we teach how to refactor the code before implementing a new functionality.
 - In the more direct version, we teach outside-in method of programming, where you will get a better feel of how object collaborate together.

Both techniques are useful in real projects.

## Requirements

The Simple Calculator 

 1. should be able to perform `Addition`, `Subtraction` and `Multiplication` on integers
 2. should return a singleton `Operand` as it is
 3. should process String inputs, as in "1+2", "4-1", "2*3" or "8"
 4. should return 0 when input is empty
 5. should return 0 when input is blank
 6. should reject `Operations` on non-integer `Operands`
 7. should reject `Operations` with more than two `Operands`
 8. should reject unsupported operations
