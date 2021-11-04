public class StmtSeq {
    // <stmt seq>	::= <stmt> | <stmt> <stmt seq>
    int type;
    Stmt stmt;
    StmtSeq seq;

    StmtSeq(){
        this.type = 0;
        this.stmt = null;
        this.seq = null;
    }

    public void parse(){

    }

    public void execute(){

    }

    public void print(){
        
    }
}
