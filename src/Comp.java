import java.io.IOException;

public class Comp {
    //<comp>	::= (<op> <comp op> <op>)	
    Op op1;
    Op op2;
    int type;
    Comp(){
        this.op1 = null;
        this.op2 = null;
        this.type = 0;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        tokenizer.skipToken();
        this.op1 = new Op();
        this.op1.parse(tokenizer);
        if(tokenizer.getToken() != 25 && tokenizer.getToken()!= 26 && tokenizer.getToken()!=27 && tokenizer.getToken()!=28 &&tokenizer.getToken()!=29 &&tokenizer.getToken() !=30){
            System.out.println("---------------------------------");
            System.out.println("ERROR: Unexpected token - Comp ");
            System.out.println("Invalid Compare Operator");
            System.out.println("---------------------------------");
            System.exit(-1);
        }
        this.type = tokenizer.getToken();
        tokenizer.skipToken();
        this.op2 = new Op();
        this.op2.parse(tokenizer);
        if(tokenizer.getToken() != 21){
            System.out.println("ERROR: Unexpected token - Comp ");
            System.exit(-1);
        }
        tokenizer.skipToken();
    }

    public void execute(){
        
        switch(this.type){
            case(25):
                break;
            case(26):
                break;
            case(27):
                break;
            case(28):
                break;
            case(29):
                break;
            case(30):
                break;
            default:
                System.out.println("ERROR: Invalid Compare Operator - exec()");
                System.exit(-1);
        }

    }

    public void print(){
        System.out.print("(");
        this.op1.print();
        switch(this.type){
            case(25):
                System.out.print("!=");
                break;
            case(26):
                System.out.print("==");
                break;
            case(27):
                System.out.print("<");
                break;
            case(28):
                System.out.print(">");
                break;
            case(29):
                System.out.print("<=");
                break;
            case(30):
                System.out.print(">=");
                break;
            default:
                System.out.println("ERROR: Invalid Compare Operator - print()");
                System.exit(-1);
        }
        this.op2.print();
        System.out.print(")");
    }

}
