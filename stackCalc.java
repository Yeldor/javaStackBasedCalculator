//AUTHORED BY YELDOR

package stackCalculator;

import java.util.ArrayList;
import java.util.Arrays;

class stackCalc {
	String expression;
	char[] expressionArray;
	static java.util.Stack s = new java.util.Stack();
	static ArrayList EA = new ArrayList();

	stackCalc(String expression) {
		this.expression = expression.trim().replace(" ", "");
		this.expressionArray = expression.toCharArray();
		reader(expressionArray);
	}

	private static void reader(char[] eA) {
	String term="";
	for (char c : eA) {
		if (Character.isDigit(c)) {
			term = term+c;
			}
		else if (c == 'N') {
			term = "-"+term;
		}
		else if(c == '+' ||c == '-' ||c == '*' ||c == '/' || c == '(' || c == ')') {
			if(term.length()>0)
			EA.add(term);
			
			switch(c) {
			case '+': while(s.contains('-') || s.contains('+')) {
			EA.add(s.peek());
			s.pop();
			}
			s.add(c);
					break;
			case '-': while(s.contains('-') || s.contains('+')) {
				EA.add(s.peek());
				s.pop();
				}
				s.add(c);
					break;
			case '*': while(s.contains('*') || s.contains('/')) {
				EA.add(s.peek());
				s.pop();
				}
				s.add(c);
					break;
			case '/': while(s.contains('*') || s.contains('/')) {
				EA.add(s.peek());
				s.pop();
				}
				s.add(c);
					break;
			case '(':
					s.add(c);
					break;
			case ')': while(s.contains('(')) {
				if (s.peek().toString().equals("(") == false)
				EA.add(s.peek());
				s.pop();
				}
					break;
					}
			term="";
			}
		}
	if (term.length() > 0 )
	EA.add(term);
	while(s.isEmpty() == false) {
	EA.add(s.peek());
	s.pop();
	}
	System.out.println(EA);
	solver(EA);
	}
	
	private static void solver(ArrayList A) {
	String t1="",t2="",op="";
	double res;
	for (int i = 0 ; i<A.size(); i++) {
		String c=A.get(i).toString();
		
		if (c.equals("+")) {
		t1=A.get(i-2).toString();
		t2=A.get(i-1).toString();
		op=A.get(i).toString();
		res = Double.parseDouble(t1) + Double.parseDouble(t2);
		A.add(i+1, res);
		A.remove(i);
		A.remove(i-1);
		A.remove(i-2);
		break;}
		
		else if (c.equals("-")) {
		t1=A.get(i-2).toString();
		t2=A.get(i-1).toString();
		op=A.get(i).toString();
		res = Double.parseDouble(t1) - Double.parseDouble(t2);
		A.add(i+1, res);
		A.remove(i);
		A.remove(i-1);
		A.remove(i-2);
		break;}
		
		else if (c.equals("*")) {
		t1=A.get(i-2).toString();
		t2=A.get(i-1).toString();
		op=A.get(i).toString();
		res = Double.parseDouble(t1) * Double.parseDouble(t2);
		A.add(i+1, res);
		A.remove(i);
		A.remove(i-1);
		A.remove(i-2);
		break;}
		
		else if (c.equals("/")) {
		t1=A.get(i-2).toString();
		t2=A.get(i-1).toString();
		op=A.get(i).toString();
		res = Double.parseDouble(t1) / Double.parseDouble(t2);
		A.add(i+1, res);
		A.remove(i);
		A.remove(i-1);
		A.remove(i-2);
		break;}
		
		}
	System.out.println(A);
	if (A.size() > 1)
	solver(A);
	}
	
}

