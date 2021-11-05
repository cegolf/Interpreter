import java.io.IOException;

public class Op {
    //<op>	::= <int> | <id> | (<exp>)
    int type;
    Id id;
    Exp exp;
    int val;


    Op(){
        this.type = 0;
        this.id = null;
        this.exp = null;
        this.val =00;
    }

    public void parse(Tokenizer tokenizer) throws IOException{
        if(tokenizer.token == 31){
            this.val = tokenizer.intVal();
            tokenizer.skipToken();
        }else if(tokenizer.token == 20){
            tokenizer.getToken();
            this.exp = new Exp();
            this.exp.parse(tokenizer);
            tokenizer.skipToken();
            if(tokenizer.token == 21){
                tokenizer.skipToken();
            }else{
                System.out.println("ERROR: Unexpected token - Op - Expected ) (21) got " + tokenizer.token);
                System.exit(-1);
            } 
        }else if(tokenizer.token == 32){
            this.id = Id.parse(tokenizer);
        }else{
            System.out.println("ERROR: Unexpected token - Op - Not part of Op grammar: " + tokenizer.token);
            System.exit(-1);
        }
    }

    public void execute(){

    }

    public void print(){
        
    }
}
