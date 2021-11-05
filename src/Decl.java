import java.io.IOException;

public class Decl {
    // int  <id list>;
    int type;
    int num;
    IdList idlist;

    Decl(){
        this.type = 0;
        this.idlist = null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        if(tokenizer.getToken() == 4){
            tokenizer.skipToken();
            this.idlist = new IdList();
            this.idlist.parse(tokenizer);
        }else{
            System.out.println("ERROR: Unexpeced Token - Decl - Expected INT got: " + tokenizer.getToken());
            System.exit(-1);
        }
    }

    public void execute(){

    }

    public void print(){
        System.out.print("int");
        this.idlist.print();
        
    }
}
