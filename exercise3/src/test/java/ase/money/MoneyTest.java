package ase.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {
  private Money oneFortyNine, oneFifty, thingFortyNine, thingFifty, plusTest;
  private String thingString;
  private int thingInt;

  @BeforeEach
  void setUp() {
    oneFortyNine = new Money(1, 49);
    oneFifty = new Money(1, 50);
    thingFortyNine = new Money(1, 49);
    thingFifty = new Money(1, 50);
    thingString= ("string");
    thingInt= (42);

  }

  @Test
  void creation() {
    assertThat(oneFifty.getEuros(), is(1));
    assertThat(oneFifty.getCents(), is(50));
  }

  @Test
  void centsTooLow() {
    assertThrows(IllegalArgumentException.class, () -> new Money(1, -1));
  }

  @Test
  void centsTooHigh() {
    assertThrows(IllegalArgumentException.class, () -> new Money(1, 100));
    assertThat(oneFortyNine.getCents(), is(lessThan(100)));
    assertThat(oneFifty.getCents(), is(lessThan(100)));
  }

  @Test
  void eurosTooLow() {
    assertThrows(IllegalArgumentException.class, () -> new Money(-1, 1));
    assertThat(oneFortyNine.getEuros(), is(greaterThan(-1)));
    assertThat(oneFifty.getEuros(), is(greaterThan(-1)));
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Money(-1, 1));
    assertEquals("invalid euros", exception.getMessage());
  }

  @Test
  void equalsTrue(){
    assertTrue(oneFortyNine.equals(thingFortyNine));
    assertTrue(oneFifty.equals(thingFifty));
  }
/** skipping this question due to intrests of time, will have to ask around about it
as I just can't get it to return anything but true or false dispite being money objects
  @Test
  void equalsMoney(){
    assertThat(oneFortyNine.equals(thingThreeSixty), is(1));
  }
**/
  @Test
  void equalsFalse(){
    assertFalse(oneFortyNine.equals(thingString));
    assertFalse(oneFifty.equals(thingInt));
  }

  @Test
  void basicHash(){
    assertEquals(oneFortyNine.hashCode(), thingFortyNine.hashCode());
    assertEquals(oneFifty.hashCode(), thingFifty.hashCode());
  }

  @Test
  void hashPlus(){
    plusTest= oneFortyNine.plus(oneFifty);
    assertThat(plusTest.getEuros(), is(2));
    assertThat(plusTest.getCents(), is(99));
  }


  @Test
  void stringConversion() {
    Money oneFive = new Money(1, 5);
    assertAll(
      () -> assertThat(oneFifty.toString(), is("\u20ac1.50")),
      () -> assertThat(oneFive.toString(), is("\u20ac1.05"))
    );
  }
}
