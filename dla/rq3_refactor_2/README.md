# Requirement 3 - Refactor 2

OK, we have fix our app now. Our next requirement, 2D random walk with a reach condition is ahead of us.

We shall now ask ourselves if the code is ready to accept this new functionality.

What shall change?

A 2 dimensional random walk implies keeping track of 2 coordinates. This shall be made easier by introducing a `Particle` class to hold those coordinates.

We will also need to deal with 2 dimensional moves: NORTH, SOUTH, EAST, WEST. Our `RandomGenerator` class, as it is, is not suited to fulfill this feature. Therefore, we will need to modify it as well.