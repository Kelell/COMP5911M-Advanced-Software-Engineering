package ase.rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private final String name;
  private final List<Rental> rentals;

  public Customer(String name) {
    this.name = name;
    rentals = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  //Apply 2 points if the rental period is >=3, otherwise 1
  private int getFrequentRenterPoints(Rental rental) {
    if (rental.getCar().getPriceCode() == Car.NEW_MODEL && rental.getDaysRented() >= 3) {
      return 2;
    }
    return 1;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  private int getTotalCharge() {
  int total = 0;
  for (Rental rental : rentals) {
    total += rental.getCharge();
    }
  return total;
  }

private int getTotalFrequentRenterPoints() {
int total = 0;
for (Rental rental : rentals) {
  total += rental.getFrequentRenterPoints();
  }
return total;
}

  public String statement() {

    StringBuilder result = new StringBuilder();
    result.append("Rental record for ");
    result.append(getName());
    result.append(":\n");

    // Determine amounts for each rental
    for (Rental rental : rentals) {

      // Show figures for this rental
      result.append("- ");
      result.append(rental.getCar().getModel());
      result.append(": ");
      result.append(rental.getDaysRented());
      result.append(" days, £");
      result.append(rental.getCharge());
      result.append("\n");
    }

    // Add footer lines
    result.append("Amount owed is £");
    result.append(getTotalCharge());
    result.append("\nYou earned ");
    result.append(getTotalFrequentRenterPoints());
    result.append(" frequent renter points\n");

    return result.toString();
  }

  public String htmlStatement() {

    StringBuilder result = new StringBuilder();

    //Start by producing an appropriate header
    result.append("<html> \n");
    result.append("<head> \n");
    result.append("<title>Rental record for ");
    result.append(getName());
    result.append("\n");
    result.append("</title> \n");
    result.append("</head> \n");

    // Determine amounts for each rental
    result.append("<body> \n");
    for (Rental rental : rentals) {

      // Show figures for this rental
      result.append("<p>");
      result.append("- ");
      result.append(rental.getCar().getModel());
      result.append(": ");
      result.append(rental.getDaysRented());
      result.append(" days, £");
      result.append(rental.getCharge());
      result.append("</p>\n");
    }

    // Add footer lines
    result.append("<p>");
    result.append("Amount owed is £");
    result.append(getTotalCharge());
    result.append("</p> \n");
    result.append("<p>");
    result.append("You earned ");
    result.append(getTotalFrequentRenterPoints());
    result.append(" frequent renter points");
    result.append("</p> \n");
    result.append("</body> \n");
    result.append("</> \n");
    return result.toString();

  }

}
