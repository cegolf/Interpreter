import java.io.IOException;

public class DeclSeq {
    // <decl> | <decl> <decl seq>
    int type;
    Decl decl;
    DeclSeq declseq;

    DeclSeq(){
        this.type = 0;
        this.decl = null;
        this.declseq=null;
    }
    public void parse(Tokenizer tokenizer) throws IOException{
        this.type = 1;
        this.decl = new Decl();
        this.decl.parse(tokenizer);
        if(tokenizer.token == 4){
            this.type = 2;
            this.declseq = new DeclSeq();
            this.declseq.parse(tokenizer);
        }
    }

    public void execute(){

    }

    public void print(){
        
    }

}
