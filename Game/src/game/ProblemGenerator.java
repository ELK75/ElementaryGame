package game;

public class ProblemGenerator {

    public static final int ADDITION = 0;

    public static String[] getProblem(int type) {
        switch (type) {
            case (ADDITION):
                return new String[]{"1+1=?", "2"};
            default:
                throw new RuntimeException("Problem type not found");
        }
    }
}
