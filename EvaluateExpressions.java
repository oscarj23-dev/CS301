import java.util.*;
public class EvaluateExpressions {
    
    public String convertToPostFix(String exp) {
        String str = "";
        Stack <Character> s = new Stack<>();
        for(int i = 0; i < exp.length(); i++) {
            // if none of these fail, i is not an operator, is an operand.
            if(exp.charAt(i) == ' ' ) {
                continue;
            }else if(exp.charAt(i) != '*' && exp.charAt(i) != '/' && exp.charAt(i) != '+' && exp.charAt(i) != '-') {
                str += exp.charAt(i);
            // if stack is empty, push exp.charAt(i) (current operator) onto stack
            } else if(s.empty()) {
                s.push(exp.charAt(i));
            // if above else if condition fails, that means there is something to compare current operator to.
            } else {
                // if this condition is greater than 0 it has higher precedence, 
                //  if it is == to 0 so just push current onto stack.
                if(hasHigherPrec(exp.charAt(i)) - hasHigherPrec(s.peek()) >= 0) {
                    str += exp.charAt(i);
                } else {
                    str += s.pop();
                    s.push(exp.charAt(i));
                }
            }
        }
        if(!s.empty()) {
            str +=  s.pop();
        }
        return str;
    }

    // evaluate postfix notation, although it only works for one digit, one operator expressions
    public double evaluatePostFix(String pstfx) {
        Stack<Double> expression = new Stack<>();
        String operand1, operand2;

        // forloop to loop over the string
        for (int i = 0; i < pstfx.length(); i++) {
            char c = pstfx.charAt(i);

            // determines if the token is a operator or an operand, if operator,
            // pop two operands off stack, and current operator and pass them into evaluate method
            if (c == '*' || c == '/' || c == '^' || c == '+' || c == '-') {
                double s1 = expression.pop();
                double s2 = expression.pop();
                double temp = evaluate(s1, s2, c);
                expression.push(temp);
            } else {
                expression.push(Double.parseDouble(String.valueOf(c)));
            }
        }

        double result = expression.pop();
        return result;
    }

    // switch statement to evaluate the two oeprands
    public double evaluate(double op1, double op2, char operator) {
        switch(operator) {
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            case '+':
                return op1 + op2;
            case '-': 
                return op1 - op2;
        }
        return 0.0;
    }

    // switch statement to evaluate which operator has higher precedence
    public int hasHigherPrec(char op) {
        switch(op) {
            case '*':
                return 4;
            case '/':
                return 3;
            case '+':
                return 2;
            case '-': 
                return 1;
        }
        return 0;
    }
}
