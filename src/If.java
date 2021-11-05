import java.io.IOException;

public class If {
    //<if>	::=	if <cond> then <stmt seq> end;|if <cond> then <stmt seq> else <stmt seq> end;
    String line;
    Cond cond;
    StmtSeq seq1;
    StmtSeq seq2;
    int type;


    If(){
        this.type = 0;
        this.line = "";
        this.cond = null;
        this.seq1 = null;
        this.seq2 = null;
    }


    public void parse(Tokenizer tokenizer) throws IOException{
        tokenizer.skipToken();
        this.cond = new Cond();
        this.cond.parse(tokenizer);
        tokenizer.skipToken();
        this.seq1 = new StmtSeq();
        this.seq1.parse(tokenizer);
        if(tokenizer.getToken() == 3){
            tokenizer.skipToken();
            tokenizer.skipToken();
        }
        tokenizer.skipToken();
        this.seq2 = new StmtSeq();
        this.seq2.parse(tokenizer);
        tokenizer.skipToken();
        tokenizer.skipToken();
    }

    public void execute(){
    }
    //<if>	::=	if <cond> then <stmt seq> end;|if <cond> then <stmt seq> else <stmt seq> end;
    public void print(){
        System.out.print("if");
        this.cond.print();
        System.out.print("then");
        this.seq1.print();
        if(this.type ==1){
            System.out.print("end;");
        }
        if(this.type == 2){
            System.out.print("else");
            this.seq2.print();
            System.out.print("end;");
        }
    }
}
