import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;
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
        // Store a set of possible choices
        String choices[] = new String[4];
        // Find a random question
        int i = getRand(data.getMax());
        // Print the question
        System.out.println("####\n#\t"+prompt[i]+"\n#");
        // Store the answer
        choices[0] = answer[i];
        // Find random possible answers
        for(int j = 1 ; j < choices.length ; j++)
        {
            int l = getRand(data.getMax());
            while(l == i)
            {
                l = getRand(data.getMax());
            }
            choices[j] = answer[l];
        }
        // Print them
        int r = getRand(choices.length);
        System.out.println("#\t"+choices[r]+"\n#");
        r--;
        if(r < 0)
        {
            r = choices.length-1;
        }
        System.out.println("#\t"+choices[r--]+"\n#");
        if(r < 0)
        {
            r = choices.length-1;
        }
        System.out.println("#\t"+choices[r--]+"\n#");
        if(r < 0)
        {
            r = choices.length-1;
        }
        System.out.println("#\t"+choices[r--]+"\n####");
    }
    /**
     * Testing purposes
     * @param args arguements
     */
    public static void main(String[] args) 
    {
        Question q = new Question();
        boolean h = false;
        Scanner s = new Scanner(System.in);

        while(h==false)
        {
            System.out.print("Would you like to view a question? (Y/N)");
            if(s.nextLine().equalsIgnoreCase("N"))
            {
                System.out.println("Exiting...");
                h=true;
            }
            else
            {
                q.print();
            }
        }

        s.close();
    }
}