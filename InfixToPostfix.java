
class Stack1{
    
    char stackArr[]= new char[100];
    int top = -1;
    
    public void push(char c){
        
        try{
            stackArr[++top]=c;
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("Stack is full");
            System.exit(0);
        }
        
        
    }
    
    //specified for char
    public char pop(){
        return stackArr[top--];
    }
    
    //specified for char
    public char peek(){
        return stackArr[top];
    }
    
    //to check either stack is empty or not
    public boolean isEmpty(){
        return (top==-1)?true:false;
    }
}

public class InfixToPostfix{
    
    static Stack1 operators = new Stack1();
    
    public static String toPostfix(String infix) {
    // Convert an infix expression to postfix
    char symbol;
    String postfix = "";

    for (int i = 0; i < infix.length(); i++) {
        symbol = infix.charAt(i);

        // If it's an operand, add it to the string
        if (Character.isLetter(symbol)) {
            postfix = postfix + symbol;

        } else if (symbol == '(') {
            // Push '(' onto the stack
            operators.push(symbol);

        } else if (symbol == ')') {
            // Pop everything back to '('
            while (operators.peek() != '(') {
                postfix = postfix + operators.pop();
            }
            operators.pop(); // Remove '('

        } else {
            // Pop operators with higher or equal precedence
            while (!operators.isEmpty() && !(operators.peek() == '(') && prec(symbol) <= prec(operators.peek())) {
                postfix = postfix + operators.pop();
            }
            operators.push(symbol); // Push the current operator after popping
        }
    }

    // Pop any remaining operators
    while (!operators.isEmpty()) {
        postfix = postfix + operators.pop();
    }
    return postfix;
}

    
    static int prec(char x){
        
        if(x == '+' || x == '-')
            return 1;
            if(x == '*' || x == '/')
            return 2;
            return 0;
    }
    
}