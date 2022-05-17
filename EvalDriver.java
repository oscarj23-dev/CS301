import java.io.*;
import java.util.*;
public class EvalDriver {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("expressions.txt");
        // PrintStream newFile = new PrintStream("postFix.txt");
        EvaluateExpressions eval = new EvaluateExpressions();
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()) {
            // System.out.println(eval.convertToPostFix(reader.nextLine().substring(i)));
            //String str = reader.nextLine().replaceAll("\\s+", "");
            String ans = eval.convertToPostFix(reader.nextLine());
            // System.out.println( " ~~ " + ans);
            double expVal = eval.evaluatePostFix(ans);
            System.out.println(expVal);

            // eval.evaluatePostFix(ans);
        }
    }
}
