# Refactoring Exercise

## Scenario

The provided code comes from an imaginary system to manage car rentals.
It is adapted from an example in Chapter 1 of Martin Fowler's *Refactoring*
(first edition).

The goal is for a rental agent to be able to generate a statement of the
fees owed to the rental company by a customer.  A customer is represented by
a `Customer` class that holds their name and records all of their rentals.
Each rental is represented by a `Rental` class that stores details of the
car that was rented and the time period of the rental.  Cars are represented
by a `Car` class that stores details of the model of the car and its
**price code**.  There is a standard price code and separate price codes
for new models and luxury models.  Different daily rental fees apply
to each price code.

The rental company operates a loyalty scheme in which customers can
accumulate 'frequent renter points'.  They normally get 1 frequent renter
point for each rental, but get an extra bonus point if they are renting
a new model for at least 3 days.

## Task

1. Run the unit tests on Linux or a Mac with

       ./gradlew test

   On Windows, just omit the `./` from the start of the command.

   **NOTE: This may be very slow the first time that it runs, as it may
   need to download Gradle and unit testing libraries.**

   All the tests should pass.

2. Identify code smells and refactor to remove them - see the lectures and
   the exercise instructions on the website for further details.

   Make sure that all the tests still pass after each refactoring operation.
