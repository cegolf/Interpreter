public class Stmt {
    // <stmt>	::=	<assign>|<if>|<loop>|<in>|<out>
    int type;
    Assign assign;
    If ifstmt;
    Loop loop;
    In in;
    Out out;

    Stmt(){
        this.type = 0;
        this.assign = null;
        this.ifstmt = null;
        this.loop = null;
        this.in = null;
        this.out = null;
    }

    public void parse(){

    }

    public void execute(){

    }

    public void print(){
        
    }
}
