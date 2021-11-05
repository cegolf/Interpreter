import java.io.IOException;

import javax.swing.undo.StateEdit;

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

    public void parse(Tokenizer tokenizer) throws IOException{
        this.type = 1;
        this.stmt  = new Stmt();
        this.stmt.parse(tokenizer);
        if(tokenizer.token == 32 || tokenizer.token == 5 || tokenizer.token == 8 || tokenizer.token ==  10 || tokenizer.token == 11){
            this.type= 2;
            this.seq = new StmtSeq();
            this.seq.parse(tokenizer);
        }
    }

    public void execute(){

    }

    public void print(){
        
    }
}
