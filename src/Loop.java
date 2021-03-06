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
        if(tokenizer.getToken() == 9){
            this.seq = new StmtSeq();
            this.seq.parse(tokenizer);
            tokenizer.skipToken();
            if(tokenizer.getToken() == 3){
                tokenizer.skipToken();
                if(tokenizer.getToken() == 12){
                    tokenizer.skipToken();
                }else{
                    System.out.println("ERROR: Unexpeced Token - Loop - Expected ; (12) got: " + tokenizer.getToken());
                    System.exit(-1);
                }
            }else{
                System.out.println("ERROR: Unexpeced Token - Loop - Expected END (3) got: " + tokenizer.getToken());
                System.exit(-1);
            }
        }
    }

    public void execute(){

    }
    //<loop>		::=	while <cond> loop <stmt seq> end;

    public void print(){
        System.out.print("while");
        this.cond.print();
        System.out.print("loop");
        this.seq.print();
        System.out.print("end;");
    }
}
