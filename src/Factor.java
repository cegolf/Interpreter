import java.io.IOException;

public class Factor {

    // <fac> ::= <op> | <op> * <fac>	
    int option = 0;
    Op op;
    Factor fac;

    Factor(){
        this.option = 0;
        this.op  = null;
        this.fac = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        this.option = 1;
        this.op = new Op();
        this.op.parse(tokenizer);
        if(tokenizer.token == 24){
            tokenizer.skipToken();
            this.option = 2;
            this.fac = new Factor();
            this.fac.parse(tokenizer);     
        }
    }

    public void execute(){

    }

    public void print(){
        
    }

}
