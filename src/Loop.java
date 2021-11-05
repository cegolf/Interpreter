import java.io.IOException;

public class Loop {
    //<loop>		::=	while <cond> loop <stmt seq> end;

    Cond cond;
    StmtSeq seq;
     

    Loop(){
        this.cond = null;
        this.seq = null;
    }

    public void parse(Tokenizer tokenizer) throws IOException{
        tokenizer.getToken();
        this.cond = new Cond();
        this.cond.parse(tokenizer);
        tokenizer.skipToken();
        if(tokenizer.token == 9){
            this.seq = new StmtSeq();
            this.seq.parse(tokenizer);
            tokenizer.skipToken();
            if(tokenizer.token == 3){
                tokenizer.skipToken();
                if(tokenizer.token == 12){
                    tokenizer.skipToken();
                }else{
                    System.out.println("ERROR: Unexpeced Token - Loop - Expected ; (12) got: " + tokenizer.token);
                    System.exit(-1);
                }
            }else{
                System.out.println("ERROR: Unexpeced Token - Loop - Expected END (3) got: " + tokenizer.token);
                System.exit(-1);
            }
        }
    }

    public void execute(){

    }

    public void print(){
        
    }
}
