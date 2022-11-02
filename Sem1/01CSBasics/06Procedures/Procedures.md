# Procedures

Reason for it: programs get **big** and it's hard to keep an overview of everything. It's also necessary to have little sections that you can test. These are **procedures** and they have inputs and outputs.

What are they really?

A part of the code, intended to be called from somewhere else and that returns to the calling code after running.

So what's different to jumps?

Jumps don't have a direct return mechanism and jumps remain inside a procedure.

## Calling

1. `call` pushes the return adress (which we're going to return to) on the stack.
2. then transfers to the execution adress
3. when finished, the procedure returns with the instruction `ret` and pops the return adress from the stack.

Can you use `call` from inside a procedure? YES!:
Inside a procedure, all instructions are allowed.