import java.nio.file.Path;
import java.util.Random;
/**
 * A question
 */
public class Question
{
    /**
     * Holds prompts
     */
    String[] prompt;
    /**
     * Holds answers
     */
    String[] answer;
    /**
     * Database
     */
    Database data;

    /**
     * Constructs a default question using a preconcieved path
     */
    public Question()
    {
        Path path = Path.of("C:/Users/zansari/Documents/GitHub/java-secplus/Data.txt");
        data = new Database(path);
        prompt = data.getTerms();
        answer = data.getDefinitions();
    }
    /**
     * Returns an index based on rand number of max size
     * @param max the max allowed number
     */
    private int getRand(int max)
    {
        Random r = new Random();
        return r.nextInt(max);
    }
    /**
     * Writes a question to the console
     */
    private void print()
    {
        int i = getRand(data.getMax());
        System.out.println("####\n#\t"+prompt[i]+"\n#");
        System.out.println("#\t"+answer[i]+"\n####");
    }
    /**
     * Testing purposes
     * @param args arguements
     */
    public static void main(String[] args) 
    {
        Question q = new Question();
        q.print();
    }
}