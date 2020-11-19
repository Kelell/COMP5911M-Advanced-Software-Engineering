package ase.money;

import java.util.Objects;

/**
 * Simple representation of an amount of money.
 *
 * @author Nick Efford
 */
public class Money {
  private int euros, cents;

  /**
   * Creates an amount of money.
   *
   * @param euros Number of euros
   * @param cents Number of cents
   */
  public Money(int euros, int cents) {
    setEuros(euros);
    setCents(cents);
  }

  /**
   * Queries the euros component of this Money.
   *
   * @return Number of euros
   */
  public int getEuros() {
    return euros;
  }

  /**
   * Queries the cents component of this Money.
   *
   * @return Number of cents
   */
  public int getCents() {
    return cents;
  }

  /**
   * Provides a string representation of this Money.
   *
   * <p>This representation incorporates the Euro currency symbol.</p>
   *
   * @return Amount of money as a string
   */
  @Override
  public String toString() {
    return String.format("\u20ac%d.%02d", getEuros(), getCents());
  }

  /**
   * Queries whether this Money is equivalent to another object.
   *
   * <p>(For this to the case, the other object must be a Money with
   * the same values for euros and cents.)</p>
   *
   * @param thing Other object being compared with this Money
   */
  @Override
  public boolean equals(Object thing) {
    if (thing == this) {
      return true;
    }
    else if (thing instanceof Money) {
      Money m = (Money) thing;
      return getEuros() == m.getEuros() && getCents() == m.getCents();
    }
    else {
      return false;
    }
  }

  /**
   * Provides a hash code for this Money.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getEuros(), getCents());
  }

  /**
   * Adds this money and the given amount of Money together.
   *
   * @param amount Amount to be added to this Money
   * @return Sum of the two amounts
   */
  public Money plus(Money amount) {
    int sumEuros = getEuros() + amount.getEuros();
    int sumCents = getCents() + amount.getCents();
    return new Money(sumEuros + sumCents / 100, sumCents % 100);
  }

  private void setEuros(int euros) {
    if (euros < 0) {
      throw new IllegalArgumentException("invalid euros");
    }
    this.euros = euros;
  }

  private void setCents(int cents) {
    if (cents < 0 || cents > 99) {
      throw new IllegalArgumentException("invalid cents");
    }
    this.cents = cents;
  }
}
