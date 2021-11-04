public class Cond {

    // <cond>	::=	 <comp>|!<cond>	| [<cond> && <cond>] | [<cond> or <cond>]

    int type;
    String line;

    Cond cond;
    Comp cmpr;

    Cond() {
        this.type = 0;
        this.line = "";
        this.cmpr = null;
        this.cond = null;
    }
    public void parse(){

    }

    public void execute(){

    }

    public void print(){
        
    }
}
