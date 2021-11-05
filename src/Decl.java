public class Decl {
    // int  <id list>;
    int type;
    int num;
    IdList idlist;

    Decl(){
        this.type = 0;
        this.idlist = null;
    }
    public void parse(Tokenizer tokenizer){
        if(tokenizer.token == 4){
            this.idlist = new IdList();
            this.idlist.parse(tokenizer);
        }else{
            System.out.println("ERROR: Unexpeced Token");
            System.exit(-1);
        }
    }

    public void execute(){

    }

    public void print(){
        
    }
}
