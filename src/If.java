public class If {
    //<if>	::=	if <cond> then <stmt seq> end;|if <cond> then <stmt seq> else <stmt seq> end;
    String line;
    Cond cond;
    StmtSeq seq1;
    StmtSeq seq2;


    If(){
        this.line = "";
        this.cond = null;
        this.seq1 = null;
        this.seq2 = null;
    }


    public void parse(){

    }

    public void execute(){

    }

    public void print(){
        
    }
}
