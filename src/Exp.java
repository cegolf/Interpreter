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

        // tokenizer is looking at a factor obj
        this.type = 1;
        this.fac = new Factor();
        this.fac.parse(tokenizer);
        //add
        if(tokenizer.getToken() == 22){
            tokenizer.skipToken();
            this.type = 2;
            this.exp = new Exp();
            this.exp.parse(tokenizer);
        }else if(tokenizer.getToken() == 23){
            tokenizer.skipToken();
            this.type = 3;
            this.exp = new Exp();
            this.exp.parse(tokenizer);
        }

    }

    public int execute(){
        if(this.type == 2){
            return this.fac.execute() + this.fac.execute();
        }
        if(this.type == 3){
            return this.fac.execute() - this.fac.execute();
        }
        return this.fac.execute();
    }
    // <exp>	::= <fac>|<fac>+<exp>|<fac>-<exp>	
    public void print(){
       this.fac.print();
       if(this.type == 2){
           System.out.println("+");
           this.exp.print();
       } 

       if(this.type == 3){
        System.out.println("-");
        this.exp.print();
       }
    }

}
