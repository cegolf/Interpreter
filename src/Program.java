import java.io.IOException;

public class Program {
    //<prog>	::= program <decl seq> begin <stmt seq> end

    DeclSeq declseq;
    StmtSeq seq;

    Program(){

        this.declseq = null;
        this.seq  = null;

    }

    public void parse(Tokenizer tokenizer) throws IOException{
        tokenizer.getToken();
        if(tokenizer.token == 4){
            this.declseq = new DeclSeq();
            this.declseq.parse(tokenizer);
            tokenizer.skipToken();
            if(tokenizer.token == 2){
                this.seq = new StmtSeq();
                this.seq.parse(tokenizer);
                tokenizer.skipToken();
                if(tokenizer.token == 3){
                    tokenizer.skipToken();
                }else{
                    System.out.println("ERROR: Unexpeced Token - Program - Expected END (3) got " + tokenizer.token);
                    System.exit(-1);
                }
            
            }else{
                System.out.println("ERROR: Unexpeced Token - Program - Expected BEGIN (2) got : " + tokenizer.token);
                System.exit(-1);
            }
        }else{
            System.out.println("ERROR: Unexpeced Token - Program - Expected INT (4) got " + tokenizer.token);
            System.exit(-1);
        }

    }

    public void execute(){

    }

    public void print(){
        
    }
}
