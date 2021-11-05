import java.io.IOException;
import java.util.ArrayList;

public class Id {
    //<id>		::= <let> | <let><id> | <let><int>	
    String identifier;
    ArrayList<Id> existingIds;


    Id(){
        this.identifier = null;
    }
    public static Id parse(Tokenizer tokenizer) throws IOException{
        tokenizer.getToken();
        if(tokenizer.token ==32){
            
        }
        
        return new Id();
    }

    public void execute(){

    }

    public void print(){
        
    }
}
