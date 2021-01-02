# Software Metrics Exercise

There are two separate Gradle subprojects here: `initial` contains the car
rental example from lectures and earlier exercises, before any refactoring
has been done; `final` contains the same example after refactoring.

To check design for the initial, unrefactored code, do

    ./gradlew :initial:check

(Omit the `./` from start of this command if running it from the standard
Windows command prompt.)

PMD will report on the number of rule violations on console output and
provide details of these violations as a report, in the HTML file
`initial/build/reports/pmd/main.html`.

To check design for the refactored code, do

    ./gradlew :final:check

The report can be found in `final/build/reports/pmd/main.html`.
