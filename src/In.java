import java.io.IOException;

public class In {
    //<in>	::=	read <id list>;		
    String line;
    IdList idlist;
    
    In(){
        this.line = "";
        this.idlist = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        tokenizer.skipToken();
        this.idlist = new IdList();
        this.idlist.parse(tokenizer);
        

    }

    public void execute(){

    }

    public void print(){
        
    }
}
