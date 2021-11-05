import java.io.IOException;

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

    public void parse(Tokenizer tokenizer) throws IOException{

        //case for assign
        if(tokenizer.token == 32){
            this.type = 1;
            this.assign = new Assign();
            this.assign.parse(tokenizer);
        }

        // case for if (starts with if keyword)
        if(tokenizer.token == 5){
            this.type = 2;
            this.ifstmt = new If();
            this.ifstmt.parse(tokenizer);

        }

        // case for loop  (starts with the while keyword)
        if(tokenizer.token == 8){
            this.type = 3;
            this.loop = new Loop();
            this.loop.parse(tokenizer);
        }

        // case for in
        if(tokenizer.token == 10){
            this.type = 4;
            this.in = new In();
            this.in.parse(tokenizer);
        }

        //case for out
        if(tokenizer.token == 11){
            this.type = 5;
            this.out = new Out();
            this.out.parse(tokenizer);

        }

    }

    public void execute(){
        //assign
        if(this.type == 1){
            this.assign.execute();
        }

        // if 
        if(this.type == 2){
            this.ifstmt.execute();
        }

        //loop
        if(this.type == 3){
            this.loop.execute();
        }

        //input
        if(this.type == 4){
            this.in.execute();
        }

        //output
        if(this.type == 5){
            this.out.execute();
        }
    }

    public void print(){
        //assign
        if(this.type == 1){
            this.assign.print();
        }

        // if 
        if(this.type == 2){
            this.ifstmt.print();
        }

        //loop
        if(this.type == 3){
            this.loop.print();
        }

        //input
        if(this.type == 4){
            this.in.print();
        }

        //output
        if(this.type == 5){
            this.out.print();
        }
        
    }
}
