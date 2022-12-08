# Testing

## Basics

**It's always worth to test**. It can save a lot of time and costs, because it identifies problems early, when they're still easy to resolve. Testing should be systematic and documentable. Ultimately it's about finding mistakes and not proving perfect function.

## Keywords

- Testing object (Testobjekt): what we're testing
- Test specifications: what the thing has to be able to do and what not
- Test case: exact explanation of what should happen (SMART)
- Test plan: specific test cases and their order
- Test protocol: documentation of results

## Testing methods

### Black box

Test something not knowing how it works internally. Good to make sure there's no bias. Though it could be, that some important functions aren't tested.

### White box

Test something knowing how it works internally. Good to make sure all possibilities are tested. Though it could be, that some functions are overlooked and not tested, because they either don't seem necessary or are labeled as basic.

### Grey box

Test something knowing what structure it has, but not knowing what the building blocks of that structure do. It's a mix between white and black box.

## What get's tested in IOE?

- Usability
- Compatibility
- Reliability
- Scalability
- Data integrity and veracity
- Safety
- Performance

## Test types

- Function test: does it work as intended
- Usability test: is it nice to use
- Safety test: are safety standards met
- Performance test: does it work as fast as intended
- Compatibility test: does it work with current infrastructure
- Service test: does it work with a desired service
- Usage test: does the object work together with the intended system

## The 4 sides of IOT testing

- sensor/actor: measure and execute
- application: processing
- network: transmission
- backend: storage
