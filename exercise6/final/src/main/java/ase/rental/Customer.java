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

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String statement() {
    StringBuilder result = new StringBuilder();
    result.append("Rental record for ");
    result.append(getName());
    result.append(":\n");

    // Generate information for each rental
    for (Rental rental : rentals) {
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
    result.append("<html>\n<body>\n");
    result.append("<h1>Rental record for ");
    result.append(getName());
    result.append(":</h1>\n");

    if (rentals.size() > 0) {
      result.append("<table>\n");
      result.append("<tr><th>Car</th><th>Days</th></th>Cost</th></tr>\n");
      for (Rental rental : rentals) {
        result.append("<tr><td>");
        result.append(rental.getCar().getModel());
        result.append("</td><td>");
        result.append(rental.getDaysRented());
        result.append("</td><td>");
        result.append(rental.getCharge());
        result.append("</td></tr>\n");
      }
      result.append("</table>\n");
    }

    result.append("<p>Amount owed is &pound;");
    result.append(getTotalCharge());
    result.append("</p>\n<p>You earned ");
    result.append(getTotalFrequentRenterPoints());
    result.append(" frequent renter points</p>");
    result.append("\n</body>\n</html>\n");

    return result.toString();
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
}
