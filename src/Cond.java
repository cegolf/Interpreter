import java.io.IOException;

public class Cond {

    // <cond>	::=	 <comp>|!<cond>	| [<cond> && <cond>] | [<cond> or <cond>]

    int type;

    Cond cond1;
    Cond cond2;
    Comp cmpr;

    Cond() {
        this.type = 0;
        this.cmpr = null;
        this.cond1 = null;
        this.cond2 = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{

        // comp
        if(tokenizer.token == 20){
            this.type= 1;
            this.cmpr = new Comp();
            this.cmpr.parse(tokenizer);
        }else if(tokenizer.token == 15){
            this.type = 2;
            tokenizer.skipToken();
            this.cond1 = new Cond();
            this.cond1.parse(tokenizer);
            
        }else if(tokenizer.token == 16){
            tokenizer.skipToken();
            this.cond1 = new Cond();
            this.cond1.parse(tokenizer);
            tokenizer.skipToken();
            if(tokenizer.token == 18){
                tokenizer.skipToken();
                this.cond2 = new Cond();
                this.cond2.parse(tokenizer);
                tokenizer.skipToken();
                if(tokenizer.token == 17){
                    tokenizer.skipToken();
                }else{
                    System.out.println("ERROR: Unexpeced Token");
                    System.exit(-1);
                }
            }else if(tokenizer.token == 19){
                tokenizer.skipToken();
                this.cond2 = new Cond();
                this.cond2.parse(tokenizer);
                tokenizer.skipToken();
                if(tokenizer.token == 17){
                    tokenizer.skipToken();
                }else{
                    System.out.println("ERROR: Unexpeced Token");
                    System.exit(-1);
                }
            }else{
                System.out.println("ERROR: Unexpeced Token");
                System.exit(-1);
            }
        }else{
            System.out.println("ERROR: Unexpeced Token");
            System.exit(-1);
        }
    }

    public void execute(){

    }

    public void print(){
        
    }
}
