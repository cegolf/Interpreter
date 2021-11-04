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
    public void parse(){

    }

    public void execute(){

    }

    public void print(){
        
    }

}
