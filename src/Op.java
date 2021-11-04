public class Op {
    //<op>	::= <int> | <id> | (<exp>)
    int type;
    Id id;
    Exp exp;
    Int num;

    Op(){
        this.type = 0;
        this.id = null;
        this.exp = null;
        this.num = null;
    }

    public void parse(){

    }

    public void execute(){

    }

    public void print(){
        
    }
}
