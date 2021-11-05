import java.io.IOException;

public class Comp {
    //<comp>	::= (<op> <comp op> <op>)	
    Op op1;
    Op op2;

    Comp(){
        this.op1 = null;
        this.op2 = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        if (tokenizer.token == 20){
            tokenizer.skipToken();
            this.op1 = new Op();
            this.op2 = new Op();
            this.op1.parse(tokenizer);
            this.op2.parse(tokenizer);
            if(tokenizer.token == 21){
                tokenizer.skipToken();
            }else{
                System.out.println("ERROR: Unexpected token - Comp");
                System.exit(-1);
            }

        }
    }

    public void execute(){

    }

    public void print(){
        System.out.print("(");
        this.op1.print();
        System.out.print("<COMP OP>");
        this.op2.print();
        System.out.print(")");
    }

}
