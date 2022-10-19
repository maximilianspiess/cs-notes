# Conditional Jumps

## Flags and Jumps

Most flags have an associated jump instruction.
Example: `jump if not zero` for ZF (zero flag)

    `mov rax, 5
    loop1:
    dec rax
    jnz loop1`

In the above, as long as rax is not 0, jump to loop1

## Jumps

Jumps are unconditional: it will **always** jump!

## Signed Values
x86 architecture uses two's complement.
This means, that -1 is represented by 0xFFFFFFFF, -2 by 0xFFFFFFFE and so on

## Copying signed numbers
When you use `mov`, the sign of the value is no kept. Depending on size, the destination value loses its sign.

Example:

    ```asm
    mov ax, 42      
    neg bx, ax      ; ok, bx is -42
    mov ebx, eax    ; wrong, ebx is 65494
    movsx ebx, ax   ; ok, ebx is -42
    ```
    
The solution is the above used `movsx`.

## Multiplication and Division
`mul`multiplies two operands. The result is **larger than both individual** operands.
If operand is 64 bit registers, the result could require 128 bits.
--> Solution: use two registers for storing the result!

`imul` and `idiv`: same, but for **signed numbers**.

## Implicit Operands
`mul`has an implicit operand (`div` too):
    - depending on size, one factor is always in `al, ax, eax or rax`.
    - the second factor lies in a programmer specified register.
