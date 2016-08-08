# Requirement 1 - Refactor 2

After we introduced the notion of parser in **refactor 1**, we are now ready to perform the second refactor: we are going to introduce the notion of _operation_ in our application.

The `Operation` class should contain a set of operands and an operator. This should shift the functionality of the `InputParser` class. Before, it merely produced an array of ints based on an input string. Now, it shall return an `operation` object.

Since, by the time of this refactor, we now that we will need to introduce several operators, we can introduce an `Operator` interface, implemented by the `Addition` class. The `Operator` shall expose an `operate` service.

Note, once again, that this refactor **must** be completely invisible for the outside world. We restrict ourselves to enable our application to integrate the new functionality introduced by **requirement 2**.

To convince ourselves that the _api_ published by the `SimpleCalculator` class (as if it was a _service_) we shall write a main method that will be exactly the same in **requirement 1**, **requirement 1 refactor 1** and **requirement 1 refactor 2**. The behaviour of this main function shall be exactly the same in all cases.