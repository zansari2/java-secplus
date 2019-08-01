import java.nio.file.Path;
public class Question
{
    String[] prompt;
    String[] answer;

    public Question()
    {
        Path path = Path.of("C:/Users/zansari/Documents/GitHub/java-secplus/Data.txt");
        Database data = new Database(path);
        prompt = data.getDefinitions();
        answer = data.getTerms();
    }

    public static void main(String[] args) 
    {
        
    }
}