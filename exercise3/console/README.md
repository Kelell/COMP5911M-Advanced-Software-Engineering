# Running Tests With ConsoleLauncher

This directory is not part of the Gradle build.  It demonstrates how you
can use JUnit's `ConsoleLauncher` to run tests.  (Note, however, that it is
better to run tests via Gradle or some other build tool like Maven or Ant.)

A shell script is provided that compiles everything and then runs the
tests.  You can run the script with

    ./runtests

`ConsoleLauncher` command line options can be passed to the script; for
example, you can reduce the amount of output with

    ./runtests --details=summary

or suppress everything except reporting of failed tests with

    ./runtests --details=none
