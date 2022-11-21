# JUnit

## Test types

**Unit Test**: Tests a single method of a class

**Module Test**: Test a component or module

**Integration Test**: Test the integration and cooperation of several modules

**System Test**: Test the overall system, in an environment as close to the target system

**Field Test**: Test during live operation

## Blackbox Test

Special cases of the specification are tested for each method. Thought the implementation of methods is NOT considered.

In order to cover the most possible tests, you choose the following for each method:
        - Default argument in middle of data range
        - limits of data area or definition
          - Example: for parameter p in range 0,100: -1, -, 47, 100, 101
          - similarly, in an `array int[] a` we test `a[0], a[length/2] and a[length-1]`

## What is JUnit?

- It's a simple framework with repeatable tests that is suited for automated testing of individual classes or methods.
  
- It only allows two results: **green** if it succeeds and **red** if it fails. Failures can be due to errors like Exceptions or incorrect results in the Assertion clause.
- In test driven programming, you first write all tests and **then** write the code to be tested. If all tests are correct, the code is correct.

## Do's and don'ts

**Do:**

- Write tests with production quality (readable, maintainable)
- Write short test methods
- Use helper methods
- Be **merciless** with your production code, or **others will be merciless to you**.

**Don't:**

- make private members public **just for testing**
- add methods to production classes **just for testing**
- add getters / setters to classes **just for testing**
- tie tests to implementation details for production classes
