# Structure of an Assembly Program

## Initial comment block
    Author, date, version, description

## `.data` Section
- Contains all initialized data ("constants")
- Values specified before assembling

## `.bss` Section
- Contains placeholders for uninitialized data
- This space will be reserved in memory

## `.text` Section
- Contains actual code
- Is readonly

Example: eat at Joe's
![programScreenshot](/Sem1/res/img/eatatjoes.jpg)

# FILL IN LABELS

## Initialized Data

You define it in the `.data` section.

Examples:
```asm
- MyByte:   db 0x07                 ; single byte
- MyWord:   dw 0xFFFF               ; 16 bits
- MyDouble: dd 0xB8000000           ; 32 bits
- MyQuad:   dq 0xB800000011000000   ; 64 bits
```

## Strings
Strings are just an **array of bytes in memory**
    - each byte may be interpreter as a character (check encoding)
    - the size of the String is **not** stored
    - **No** end of String delimiter

Examples:
```asm
SECTION .bss            ; Uninitialized data
    Buff: resb 16           ; 16 byte buffer

SECTION .data           ; Initialised data
    HexStr: db "00 01 02 FD FE FF",10
    Digits: db "0123456789ABCDEF"
```

**Problem**: size of my string?!

## Calculate String Length
The length of a String is generally required. So, a possible solution: **hard-code it** (hell yeah)
`EatMsg:    db "Eat at Joe's!"`
`EatLen:    equ 13`

`equ` (equate) means: we have 13 letters of memory to keep.

Note: if the string changes, the length must be adapted too! That's **error** prone.

Automate it:
```
EatMsg  db "Eat at Joe's!"
EatLen: equ $-EatMsg
```

The dollar ($) means "here". So, it calculates the size from "here" to EatMsg start.

## String Concatenation
These can be concatenated using a comma ','.
Examples:
*Add EOL (end of line) to the end of a string*
`EatMsg:    db "Eat at Joe's!",10`

Multiline String:
`TwoLine: db "Eat at Joe's ...",10,"... tonight!",10`

# Conclusion
**Assembling:**
    - Assemble `.asm` into `.o`
    - Link all `.o` files into a single executable

**Structure of a program:**
    - Initialization of data in memory
    - Placeholders to reserve memory
    - Instructions