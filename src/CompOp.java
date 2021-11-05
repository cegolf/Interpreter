public class CompOp {
    //<comp op> ::= != | == | < | > | <= | >=  
    /*
        0: default
        1: != 25
        2: == 26
        3: < 27
        4: > 28
        5: <= 29
        6: >= 30

    */
    int type;
    String line;
    CompOp(){
        this.type = 0;
        this.line = "";
    }

    public void parse(Tokenizer tokenizer){
        switch(tokenizer.token){
            case(25):
                this.type = 1;
                this.line= "!=";
                break;
            case(26):
                this.type = 2;
                this.line= "==";
                break;
            case(27):
                this.type = 3;
                this.line= "<";
                break;
            case(28):
                this.type = 4;
                this.line= ">";
                break;
            case(29):
                this.type = 5;
                this.line= "<=";
                break;
            case(30):
                this.type = 6;
                this.line= ">=";
                break;
            default:
                //throw error
        }
    }

    public void execute(){

    }

    public void print(){
        
    }
}
