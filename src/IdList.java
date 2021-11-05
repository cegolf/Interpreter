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

        // just an id
        if(tokenizer.getToken() == 32){
            this.type = 1;
            this.id = Id.parse(tokenizer);
        }
        // id, idlist
        if(tokenizer.getToken() == 13){
            this.type = 2;
            tokenizer.skipToken();
            this.idlist = new IdList();
            this.idlist.parse(tokenizer);
        }
    }

    public void execute(){

    }

    public void print(){
        this.id.print();
        if(this.type ==2){
            System.out.println(", ");
            this.idlist.print();
        }
    }
}
