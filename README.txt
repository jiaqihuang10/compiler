#Pretty Printer 

- Given input code in a messy coding style, test if there is any syntax error according to the grammar in simple.g, and construct the abstract syntax tree (AST) for the input code.
- Use a visitor to go through the AST, and output the code conforming to the specific coding style as follows:
   1. Indentation is provided by four (4) spaces, not tabs
   2. The content of each block is indented by four (4) spaces.
   3. There is a single line between the variable declarations and the body of the function.
   4. There is a single line between function definitions.
   5. There are no spaces between operators and operands.
   6. There is a single space between if while and the opening.
   7. Braces always occur on a new line.
   8. There is a single space between the type and name of variables and parameters


This is part of the Compiler Construction Course Project.