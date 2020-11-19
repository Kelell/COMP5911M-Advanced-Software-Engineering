# Diagrams Exercise

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

## Tasks

(See the module website for full details.)

1. Draw a UML class diagram by hand, showing the relationships between
   `Customer`, `Rental` and `Car`.  Add a scan or photo of your diagram to
   the GitLab wiki.

2. Recreate your class diagram in the GitLab wiki using PlantUML syntax.

3. Create a sequence diagram in the GitLab wiki using PlantUML syntax,
   showing what happens when the `statement()` method is invoked on
   a `Customer` object.

4. Use diagrams.net to create another version of the class diagram.  Put
   the `.drawio` file for this diagram in your repository.  Export the
   diagram as a PNG image, then add this image to the wiki.

5. (Optional) Use diagrams.net to create another version of the sequence
   diagram.  Put the `.drawio` file in your repository.  Export to PNG and
   add the image to the wiki.
