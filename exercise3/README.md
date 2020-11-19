# Unit Testing With JUnit 5

This exercise provides you with a class `Money`, and an incomplete set of
unit tests for that class, in a separate class named `MoneyTest`.  You will
find the code for these under `src/main` and `src/test`, respectively.

If you are using Linux, a Mac or Windows Subsystem for Linux, you can
run the tests using JUnit's `ConsoleLauncher`; cd into `console` and examine
the README in that directory for further details.

The recommended way of running the tests, which should work on any platform,
is to use the provided **Gradle wrapper**.  On Linux or a Mac, do

    ./gradlew tests

On Windows, use the same command but omit the `./` at the start.

**Note**: the first time you run this, it will be very slow, as it will need
to download the Gradle build system and the required unit testing libraries.
Subsequent runs will be a lot faster.
