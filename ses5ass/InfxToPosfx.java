import java.util.*;
public class InfxToPosfx {
    public static int before (char Operand){
        if(Operand=='+' || Operand=='-')
        return 1;
        else if(Operand=='*' || Operand=='/')
        return 2;
        return 0;
    }
    public static String Converter(String expression){
        Stack<Character> operators = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for(int i = 0; i<expression.length();i++){
            char Operand=expression.charAt(i);
            if(Operand=='(')
                operators.push(Operand);
            else if((Operand>='a'&& Operand<='z') || (Operand>='A'&& Operand<='Z'))
                postfix.push(Operand+" ");
            else if(Operand==')'){
                while(operators.peek()!='('){
                    char op = operators.pop();
                    String first = postfix.pop();
                    String second = postfix.pop();
                    String new_psFix = second+first+op;
                    postfix.push(new_psFix);
                }
                operators.pop();
            }
            else if(Operand=='+'|| Operand=='*'|| Operand=='/'){
                while(operators.size()>0 && operators.peek()!='('&& before(Operand)<= before(operators.peek())){
                    char op = operators.pop();
                    String first = postfix.pop();
                    String second = postfix.pop();
                    String new_psFix = second+first+op;
                    postfix.push(new_psFix);
                }
            operators.push(Operand);
            }
        }
        while(operators.size()>0){
            char op = operators.pop();
            String first = postfix.pop();
            String second = postfix.pop();
            String new_psFix = second+first+op;
            postfix.push(new_psFix);
        }
        return postfix.pop();
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an Infix Expression: ");
        String InfixExp = input.next();
        System.out.println("The given Infix Expression is: "+ InfixExp.toUpperCase());
        String result = Converter(InfixExp);
        System.out.println("The Postfix Expression is: "+ result.toUpperCase());
    }
}
