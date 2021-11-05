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
        if(tokenizer.getToken() == 20){
            this.type= 1;
            this.cmpr = new Comp();
            this.cmpr.parse(tokenizer);
        }else if(tokenizer.getToken() == 15){
            this.type = 2;
            tokenizer.skipToken();
            this.cond1 = new Cond();
            this.cond1.parse(tokenizer);
            
        }else if(tokenizer.getToken() == 16){
            tokenizer.skipToken();
            this.cond1 = new Cond();
            this.cond1.parse(tokenizer);
            tokenizer.skipToken();
            if(tokenizer.getToken() == 18){
                tokenizer.skipToken();
                this.cond2 = new Cond();
                this.cond2.parse(tokenizer);
                tokenizer.skipToken();
                if(tokenizer.getToken() == 17){
                    tokenizer.skipToken();
                }else{
                    System.out.println("---------------------------------");
                    System.out.println("ERROR: Unexpected token - Cond ");
                    System.out.println("Expected: ] (17)");
                    System.out.println("Read: " + tokenizer.getToken());
                    System.out.println("---------------------------------");
                }
            }else if(tokenizer.getToken() == 19){
                tokenizer.skipToken();
                this.cond2 = new Cond();
                this.cond2.parse(tokenizer);
                tokenizer.skipToken();
                if(tokenizer.getToken() == 17){
                    tokenizer.skipToken();
                }else{
                    System.out.println("---------------------------------");
                    System.out.println("ERROR: Unexpected token - Cond ");
                    System.out.println("Expected: ] (17)");
                    System.out.println("Read: " + tokenizer.getToken());
                    System.out.println("---------------------------------");
                }
            }else{
                System.out.println("---------------------------------");
                System.out.println("ERROR: Unexpected token - Cond ");
                System.out.println("Expected: || (19)");
                System.out.println("Read: " + tokenizer.getToken());
                System.out.println("---------------------------------");
            }
        }else{
            System.out.println("---------------------------------");
            System.out.println("ERROR: Unexpected token - Cond ");
            System.out.println("Expected: && (18)");
            System.out.println("Read: " + tokenizer.getToken());
            System.out.println("---------------------------------");
        }
    }

    public void execute(){

    }
    // <cond>	::=	 <comp>|!<cond>	| [<cond> && <cond>] | [<cond> or <cond>]
    public void print(){
        if(this.type == 1){
            this.cmpr.print();
        }

        if(this.type ==2){
            System.out.print("!");
            this.cond1.print();
        }

        if(this.type ==3){
            System.out.print("[");
            this.cond1.print();
            System.out.print("&&");
            this.cond2.print();
            System.out.print("]");
        }

        if(this.type == 4){
            System.out.print("[");
            this.cond1.print();
            System.out.print("||");
            this.cond2.print();
            System.out.print("]");
        }
    }
}
