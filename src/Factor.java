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
        if(tokenizer.getToken() == 24){
            tokenizer.skipToken();
            this.option = 2;
            this.fac = new Factor();
            this.fac.parse(tokenizer);     
        }
    }

    public int execute(){
        if(this.option == 1){
            return this.op.execute();
        }else{
            return this.op.execute() * this.fac.execute();
        }
    }

    public void print(){
        this.op.print();
        if(this.option == 2){
            System.out.print("*");
            this.fac.print();
        }
    }

}
