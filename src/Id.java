import java.io.IOException;
import java.util.ArrayList;

public class Id {
    //<id>		::= <let> | <let><id> | <let><int>	
    String identifier;
    static ArrayList<Id> existingIds = new ArrayList<>();


    private Id(String name){
        this.identifier = name;
    }

    public Id(){
        this.identifier = "";
    }


    public static Id parse(Tokenizer tokenizer) throws IOException{
        tokenizer.getToken();
        if(tokenizer.getToken() == 32){
            boolean exists = false;
            int matchidx = 0;
            for(int i=0; i< existingIds.size(); i ++){
                if(existingIds.get(i).identifier == tokenizer.identifier){
                    exists= true;
                    matchidx = i;
                    break;
                }
            } 
            
            
            if(!exists){
                Id id = new Id(tokenizer.identifier);
                existingIds.add(id);
                return id;
            }else{

                return existingIds.get(matchidx);
            }   
        }else{
            System.out.println("ERROR: Unexpeced Token - Id - Expected IDENTIFIER (32) got " + tokenizer.getToken());
            System.exit(-1);
            return new Id();
        }
    }

    public void execute(){

    }

    public void print(){
        System.out.println(this.identifier);
    }
}
