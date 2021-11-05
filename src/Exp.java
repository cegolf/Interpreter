import java.io.IOException;

public class Exp {
    // <exp>	::= <fac>|<fac>+<exp>|<fac>-<exp>	
    int type;
    Factor fac;
    Exp exp;

    Exp(){
        this.type = 0;
        this.fac = null;
        this.exp = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{

        this.fac = new Factor();
        this.fac.parse(tokenizer);
        //add
        if(tokenizer.token == 22){
            tokenizer.skipToken();
            this.type = 2;
            this.exp = new Exp();
            this.exp.parse(tokenizer);
        }else if(tokenizer.token == 23){
            tokenizer.skipToken();
            this.type = 3;
            this.exp = new Exp();
            this.exp.parse(tokenizer);
        }

    }

    public void execute(){

    }

    public void print(){
        
    }

}
