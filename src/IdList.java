import java.io.IOException;

public class IdList {
    // <id list> ::=	<id> | <id>, <id list>	
    int type;
    
    IdList idlist;
    Id id;
    
    IdList(){
        this.type = 0;
        this.idlist = null;
        this.id = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        this.type = 1;
        this.id = Id.parse(tokenizer);
        if(tokenizer.token == 13){
            tokenizer.skipToken();
            this.idlist = new IdList();
            this.idlist.parse(tokenizer);
        }
    }

    public void execute(){

    }

    public void print(){
        
    }
}
