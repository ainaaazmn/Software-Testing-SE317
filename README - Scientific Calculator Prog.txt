README - Scientific Calculator Program

Overview:
This is a simple scientific calculator application built using Java and Swing for the GUI. The calculator supports basic arithmetic operations, memory functions, and some advanced operations like square and square root.

Features:
a. Basic arithmetic operations: Addition, Subtraction, Multiplication, Division.
b. Advanced operations: Square, Square Root.
c. Memory functions: M+, M-, M-Recall, M-Clear.
d. Error handling for invalid inputs and operations.
e. Intuitive user interface.

Requirements:
- Java Development Kit (JDK) 8 or higher.
- A Java IDE or text editor of your choice.
- A system with GUI support.

Instructions:
1. Compile: javac CalculatorApp.java
2. Run: java CalculatorApp

Usage:
1. Basic Arithmetic Operations:
- Click on the number buttons to input numbers.
- Use the +, -, *, and / buttons to perform arithmetic operations.
- Click = to display the result.

2. Advanced Operations:
- Use the ^2 button to calculate the square of the current input.
- Use the sqrt button to calculate the square root of the current input.

3. Memory Functions:
- M+: Adds the result of the last valid operation to the memory.
- M-: Subtracts the result of the last valid operation from the memory.
- M-Recall: Recalls the value stored in memory.
- M-Clear: Clears the memory.

4. Clear & Delete
- Clear: Resets the calculator display and memory.
- Delete: Deletes the last character from the current input.

Memory Functions:
M+: Adds the result of the last valid operation to the memory.
Example: After performing 3 + 4 = (result is 7), pressing M+ stores 7 in memory.

M-: Subtracts the current input from the memory.
Example: If the memory contains 10 and the current input is 3, pressing M- updates memory to 7.

M-Recall: Displays the value stored in memory.
Example: If the memory contains 7, pressing M-Recall displays 7.

M-Clear: Clears the memory.
Example: Pressing M-Clear resets the memory to 0.
