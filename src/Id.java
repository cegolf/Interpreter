import java.io.IOException;
import java.util.ArrayList;

public class Id {
    //<id>		::= <let> | <let><id> | <let><int>	
    String identifier;
    int val;
    boolean init;
    static ArrayList<Id> existingIds;


    private Id(String name){
        this.identifier = name;
    }

    public Id(){
        this.identifier = "";
        this.val = 0;
        this.init = false;
    }


    public static Id parse(Tokenizer tokenizer) throws IOException{
        if(tokenizer.getToken() == 32){
            if(existingIds == null){
                Id.existingIds = new ArrayList<Id>();
                Id nId = new Id(tokenizer.identifier);
                Id.existingIds.add(nId);
            }else{
                for (Id id : existingIds) {
                    if(id.identifier == tokenizer.identifier){
                        tokenizer.skipToken();
                        return id;
                    }else{
                        Id newId = new Id(tokenizer.identifier);
                        Id.existingIds.add(newId);
                        tokenizer.skipToken();
                        return newId;
                    }
                }
            }
        }else{
            System.out.println("ERROR: Unexpeced Token - Id - Expected IDENTIFIER (32) got " + tokenizer.getToken());
            System.exit(-1);
            return new Id();
        }
        return null;
    }

    public void execute(){

    }

    public int getIdVal(){
        if(this.init != false){
            return this.val;
        }else{
            System.out.print("Error: Uninitialzed variable");
            System.exit(-1);
            return -1;
        }
    }

    public void setIdVal(int newVal){
        this.val = newVal;
        this.init = true;
    }

    public void print(){
        System.out.println(this.identifier);
    }
}
