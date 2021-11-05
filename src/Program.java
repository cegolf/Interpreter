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
        tokenizer.skipToken();
        if(tokenizer.token == 1){
            tokenizer.skipToken();
            this.declseq = new DeclSeq();
            this.declseq.parse(tokenizer);
            tokenizer.skipToken();
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
            System.out.println("ERROR: Unexpeced Token - Program - Expected INT (4) got " + tokenizer.token);
            System.exit(-1);
        }

    }

    public void execute(){

    }
    //<prog>	::= program <decl seq> begin <stmt seq> end

    public void print(){
        System.out.print("program");
        this.declseq.print();
        System.out.println("begin");
        this.seq.print();
        System.out.println("end");
    }
}
