import java.io.IOException;

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
        if(tokenizer.getToken() == 32 || tokenizer.getToken() == 5 || tokenizer.getToken() == 8 || tokenizer.getToken() ==  10 || tokenizer.getToken() == 11){
            this.type= 2;
            this.seq = new StmtSeq();
            this.seq.parse(tokenizer);
        }
    }

    public void execute(){

    }
    // <stmt seq>	::= <stmt> | <stmt> <stmt seq>

    public void print(){
        this.stmt.print();
        if(this.type ==2 ){
            this.seq.print();
        }
    }
}
