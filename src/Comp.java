import java.io.IOException;

public class Comp {
    //<comp>	::= (<op> <comp op> <op>)	
    Op op1;
    Op op2;
    CompOp cmp;

    Comp(){
        this.op1 = null;
        this.op2 = null;
        this.cmp = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        if (tokenizer.token == 20){
            tokenizer.skipToken();
            this.op1 = new Op();
            this.cmp = new CompOp();
            this.op2 = new Op();
            this.op1.parse(tokenizer);
            this.cmp.parse(tokenizer);
            this.op2.parse(tokenizer);
            if(tokenizer.token == 21){
                tokenizer.skipToken();
            }else{
                System.out.println("ERROR: Unexpected token");
                System.exit(-1);
            }

        }
    }

    public void execute(){

    }

    public void print(){
        
    }

}
