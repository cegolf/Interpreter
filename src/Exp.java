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
        this.type = 1;
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
