public class Main {
    public static void main(String[] args) throws Exception {
        Tokenizer t = new Tokenizer("src\\test.txt");
        Program p = new Program();
        p.parse(t);
    }
}
