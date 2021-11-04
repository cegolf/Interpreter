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
            this.identifier = tokenizer.identifier;
            tokenizer.getToken();   
        }else{
            // throw an error
        }

        if(tokenizer.token != 14){
            // throw an error
        }

    }

    public void execute(){

    }

    public void print(){
        
    }
}
