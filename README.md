# javaStackBasedCalculator
A Stack Based class called stackCalc with the constructor parameter as a single-string equation, Negative numbers are represented by 'N'.

Place the equation in the constructor and the answer will be broken down to its stack based version, then given a solution!

This code is for educational use only. 


DISCOVERED BUG: TWO TERMS SURROUNDED BY PARENTHESES WITH THE SECOND TERM BEING THE SAME AS THE OPERATOR IN BETWEEN TWO TERMS PRODUCES AN ERROR WHERE '(' IS PUSHED INTO THE STACK

EX: "(1+3)*(4+3)" IS OKAY
EX: "(1+3)*(4*3)" IS NOT OKAY

This is permissible however, due to the fact that associative/ communicative properties in real life math results in the non need to worry about this error.
