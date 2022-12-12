# The C Programming language

## Development

Developed to develpo UNIX by Denis Ritchie in the 1970s.
Some more development happened and we got ANSI C -> C80 -> C90 -> C95 -> C99 -> C11 -> C18

## Structure

It's made out of functions, no classes. One of the functions must be called `main`. The program always starts at this point.

**Each function is made out of**:

- a function header
- a list of arguments
- a compund statement (code block)

### hello.c

```c
#include <stdio.h>

int main(int argc, char **argv) {
    printf("Hello world!\n");
    return 0;
}
```

## Integer types

Common storages:

- char: 1 byte
- short: 2 byte
- int: 2 or 4 bytes
- long: 4 or 8 bytes
- long long: 8 bytes (or more).

**These are platform dependent!**

## Integer constants

Decimal: 0, 1, -753, 5280
Octal: 01, -0654, 0777
Hexadecimal: 0xC, 0x12AC

## Unsigned and long integers

Signed data types are stored as 2's complement

Values of type `int`:

- Typically use 4 bytes
- Min: -0x8000000 (-2.147.483.648)
- Max: 0x7FFFFFFF (2.147.483.647)

`unsigned int` **can only be non-negative**:

- Min: 0
- Max: 0xFFFFFFFF (4.294.967.295)

`long long` integers are typically 8 bytes

- signed, -0x8000000000000000 to 0x7FFFFFFFFFFFFFF

## `stdint.h` Defined bit width types

The variable size of defaults is annoying. `stdint.h`defined integer types with defined bit widths:

- intN_t, uintN_t: width exactly N
- int_leastN_t, uint_leastN_t: width at least N
- int_fastN_t, uint_fastN_t: fastest type for given int

**You have to think hard about what type to use!**

## Boolean values

In C, Booleans are **`int` numbers**, meaning: *false* is 0, everything else is true.

Using stdbool.h `bool`may be used for `_Bool` and `true`/`false` are defined.

## Floats

**Three types**:

- float: 4 bytes, normally IEEE-754 single precision
- double: 8 bytes, IEEE-754 double precision
- long double: at least 10 bytes, could correspond to IEEE-754 quadruple precision

These can be written with a decimal point (.) or scientific notation:

- f1 = 0.899
- f2 = 1.99E-5

Can also be written in hexadecimal: use P instead of E. **The exponent is in base 2!**

## Character constants

char x = 'A', for example.

**Characters are an 8-bit integer type**, generally encoded in ACII.

- 'A' = 65 = 0x41; '0' = 0x30

## Strings

Are enclosed in *double* quotation marks, like "Hello, World!".

Also, in C, strings are arrays of characters, terminated by a 0-byte ('\0'). Considering this, you have to be careful to assign enough space:

- char str3[15] = "Ville de Bienne";
- char str4[16] = "Ville de Bienne";

## Variables

**C is statically typed**. Every variable has a single type and must be declared prior usage:

- int a, b, c;

You can only use the name once!

## Symbolic constants

This is a named string *substitution*. Before compiling, all references are replaced by their value by the C preprocessor.

Syntax: `#define name text`

Example:

```c
#define PI 3.141593
#define YES 1
//...
area = PI * radius * radius;

if (YES) {
    //...
}
```

Both `PI` and `YES` will be replaced (by the preprocessor) by their values before compiling.

## Arithmetic operators

Five binary operators: addition, subtraction, multiplication, division and modulo.

There's also a *unary* operator, that turns numbers negative.

Finally, we have an increment (++) and decrement (--). Depending on if it is in front or after the variable, it will first be incremented and then returned, or returned and then incremented, respecrively.

## Sizeof

returns the number of bytes required to store an object. There also is a string size, but this is a little bit harder. If you define a String with size 10, it will return a size 10, even though you didn't put 10 characters into it.

The return type of `sizeof`is of type `size_t`.

## Relational and logical operators

What we know: <, >, <=, >=, ==, !=, ||, &&.

## Assignment operators

## The ternary operator

`expression1 ? expression 2 : expression 3;`

expression1 is evaluated. If it is true, expression2 is returned, otherwise expression3 is returned.

## Undefined behavior

C has the notion of *undefined behavior*, which can be caused by a broad range of operations. This is used to optimize code, but can lead to surprising effects and security issues: anything can happen.

Examples:

- uninitialized variables
- overflow of signled integer
- oversized shifts
- accessing arrays out of range
- ...and more!

## Libraries

These contain useful functions, constants, etc.

For dealing with input and output: `stdio.h`

- read input from stdin
- write output to stdout
- open and close files
- read/write from/to files
- Format strings

For math: `math.h`

## Useful compiler options

### Debugging

-g: include debug information (for gdb)

### Optimization

- 00: no optimization
- 01: Fast optimization
- 02: Good optimization
- 03: Very good optimization
- 0s: optimize for small executable size

### Compatibility

-ansi or -std=c89, -std=c99

### Usage

CFLAGS... (don't get it)

## Compiling

Compilation requires a lot of information!

## Makefile

Syntax:

```txt
target: dependencies
        commands
```

Limitations: only builds a single executable.

Commands:

- all: builds all exectuables (if more than one)

### Phony

*Phony* files are all files that do not correspons to the file to be generated. 

### Use variables

You can use variables in a Makefile.

- Define: `NAME=VALUE`
- Use it: `$NAME`

Common variables:

- CC: specifies compiler
- CFLAGS: options for the compiler
- LDFLAGS: options for the linker
- EXEC: a list of executables

You can change variables when invoking them: `make CFLAGS='-Werror -03'` to override CFLAGS.

Example Makefile

```txt
CC =gcc
CFLAGS=-Wall -Wextra -Wpedantic -g -O0
LDFLAGS= -lm
EXEC=hello

all: $(EXEC)

$(EXEC): hello.o main.o         // (works with one file only!)
        $(CC) $(LDFGLAS) -o $(HELLO) hello.o main.o
```

But this is tiring and repetitive. That's why we use variables:

```txt
$(EXEC): hello.o main.o
        $(CC) -o $@ $^

hello.o: hello.c
        $(CC) $(CFLAGS) -o $@
```

### Autotools

Creating Makefiles is complex! Specially, if you have more and more dependencies. And don't even think about running your program on another architecture! It all has an effect on how you compile your program.

Ways things are distributed:

- Source tree (git): for devs - requires autotools
- Tar-ball: for OS distributions - requires gcc, make, ...
- Binary packages: for normal users - requires dpkg(apt) or rpm

So how do we use autotools?

1. autoscan: setupi initial template for configure.ac
2. aclocal: collects M4 macros
3. autoheader: creates template header to configure
4. automake --add-missing: generate Makefile.in from Makefile.am
5. autoconf: generate configure from configure.ac

You can make all of this easier by calling *something I didn't get to write down*.

### Conditional Compiling

Seems like we won't be using any of this in a long while, hence I'm not sure I will continue taking notes...

## Conclusion

### Data Types

- Each var has a type, values in memory
- int: signed integers using 4 bytes (also unsigned)
- long long: signed integer using 8 bytes (also unsigned)
- float, double
- char and char[] (i.e. strings)

### Library

- stdbool.h: to use bool and true/false
- stdint.h: tyoes with defined bit-widths
- stdio.h for input/output
- stdlib.h: for standard functions (string manipulation, for example)
- math.h: for mathematical functions

Funnily enough, `.h`files don't contain the actual code, but just the function names!

### Symbolic constant

- very efficient: replaced by preprocessor
- avoid writing constands in your code!

## Makefile is necessary

- Manual compilation is too complicated
- Helps to change configuration easily

## A lot of possibilities

- Installation of written in Makefile
- Configuration is tested
- Compilation depends on machine and libraries

---------------------- A LOT TO FILL RIGHT HERE ----------------------------

## Arrays

### Definition

To define one, we give its type and the number of elements.
**If less than the defined amount of elements are entered, they are initialized to whatever it was before, except if it is a global array, which is then filled with 0s.**

### Accessing

The can be accessed with the `[]` operator. You have to know how big the arrays is though!

### Multidimensional

Initialized like so: `int8_t a[3][4] = {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}}`

### As func parameter

You can use arrays as function parameters like: `void func(char param[])`

### As return type

Should only be returned to static variables!
Return with a pointer (`int *p = random_numbers()`)

### What if we want variable length?

The size is normally defined at compile time, but C99 introduced *variable length arrays*. This only works for automatic arrays and the arrays size is **still fixed after definition**. You have to be aware of size and lifetime, since it is **on the stack**.

Example:

```c
uint8_t lem = 0;
if (1 == scanf("%hhu", &len)){
        char array[len];
        printf("len: %d" SOMETHING MISSING  HERE)
}
```

## Bitwise operation

You can operate con individual bits. It's just like in assembly (uh yay...):

- ~ : not
- & : and
- | : or
- ^ : xor

### Bit shift

Shift the bits left or right with `x << n` (shift x by n bits to the left) and `x >> n` (shift x by n bits to the right).