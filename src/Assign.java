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
        if(tokenizer.token == 32){
            this.id = new Id();
            this.id.parse(tokenizer);  
        }else{
            //throw an unexpected token error
            System.out.println("ERROR: Unexpected token");
            System.exit(-1);
        }
        tokenizer.getToken();
        if(tokenizer.token != 14){
            //throw an unexpected token error
            System.out.println("ERROR: Unexpected token");
            System.exit(-1);
        }
        tokenizer.skipToken();

        if(tokenizer.token == 20|| tokenizer.token == 4 || tokenizer.token == 32){
            this.exp = new Exp();
            this.exp.parse(tokenizer);
        }else{
            //throw an unexpected token error
            System.out.println("ERROR: Unexpected token");
            System.exit(-1);
        }

    }

    public void execute(){

    }

    public void print(){
        
    }
}
