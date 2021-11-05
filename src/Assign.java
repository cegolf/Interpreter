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
        this.id = Id.parse(tokenizer);
        
        tokenizer.skipToken();
        if(tokenizer.getToken() != 14){
            //throw an unexpected token error
            System.out.println("ERROR: Unexpected token - Assign ");
            System.exit(-1);
        }
        tokenizer.skipToken();

        this.exp = new Exp();
        this.exp.parse(tokenizer);
        
    }

    public void execute(){
        int val = exp.execute();
        this.id.val = val;
    }

    public void print(int tabs){
        int it = 0;
        while(it < tabs){
            System.out.print("\t");
            it++;
        }
        this.id.print();
        System.out.print("=");
        this.exp.print();
    }
}
