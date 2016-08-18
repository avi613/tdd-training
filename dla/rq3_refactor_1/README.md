# Requirement 3 - Refactor 1

We have implemented a first version of our 1 dimensional random walk with a *reach condition*. This is the embryo of our DLA simulation. The reach condition is the aggregation condition to be.

However, when playing a bit with the input parameters, we realized that we get a *stack overflow* when the particle drifts too far and too long from its its target. **OUCH!**

This is when the trampoline gets in. Our first refactor is actually a bug fix.

This case helps us feel the limitation of TDD approach. TDD helped us build our app with unit tests. Although we have a good code coverage (or we hope to have), we needed to run an actual main method to realize that our app was buggy.

This points out the need for other kind of testing, like property **based testing**, or other test coverage, like **BDD**.