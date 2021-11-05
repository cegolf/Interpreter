import java.io.IOException;

public class Assign {
    // <assign>		::=	<id> = <exp>;	
    String identifier;
    Id id;
    Exp exp;
    Assign(){
        this.id = null;
        this.exp = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{

        // if token is identifier
        if(tokenizer.getToken() == 32){
            this.id = Id.parse(tokenizer);
        }else{
            //throw an unexpected token error
            System.out.println("ERROR: Unexpected token - Assign- Expected ID (32) got: " + tokenizer.getToken());
            System.exit(-1);
        }
        tokenizer.skipToken();
        if(tokenizer.getToken() != 14){
            //throw an unexpected token error
            System.out.println("ERROR: Unexpected token - Assign ");
            System.exit(-1);
        }
        tokenizer.skipToken();

        if(tokenizer.getToken() == 20|| tokenizer.getToken() == 4 || tokenizer.getToken() == 32){
            this.exp = new Exp();
            this.exp.parse(tokenizer);
        }else{
            //throw an unexpected token error
            System.out.println("ERROR: Unexpected token -Assign");
            System.exit(-1);
        }

    }

    public void execute(){

    }

    public void print(){
        this.id.print();
        System.out.print("=");
        this.exp.print();
    }
}
