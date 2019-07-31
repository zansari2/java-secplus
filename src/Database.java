import java.nio.file.Path;
import java.io.*;

/**
 * A set of questions
 */
public class Database
{
    /**
     * Create a database using a file path
     * @param path the file path
     */
    public Database(Path path)
    {
        parse(path);
    }
    /**
     * Parses a file
     * @param path the file path
     */
    private void parse(Path path)
    {
        try
        {
            char [] a = new char[100];
            File f = new File(path.toString());
            FileReader reader = new FileReader(f);
            reader.read(a);
            for(char c : a)
            {
                if(c!='\n')
                {
                    System.out.print(c);
                }
                else
                {
                    System.out.println();
                }
            }
            System.out.println();
            reader.close();
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    /**
     * Runs a file diagnostic
     * @param path the path
     */
    public void diag(Path path) 
    { 
        try
        {
            File file = new File(path.toString()); 
            FileInputStream fileStream = new FileInputStream(file); 
            InputStreamReader input = new InputStreamReader(fileStream); 
            BufferedReader reader = new BufferedReader(input); 
            
            String line; 
            
            // Initializing counters 
            int countWord = 0; 
            int sentenceCount = 0; 
            int characterCount = 0; 
            int paragraphCount = 1; 
            int whitespaceCount = 0; 
            
            // Reading line by line from the  
            // file until a null is returned 
            while((line = reader.readLine()) != null) 
            { 
                if(line.equals("")) 
                { 
                    paragraphCount++; 
                } 
                if(!(line.equals(""))) 
                { 
                    
                    characterCount += line.length(); 
                    
                    // \\s+ is the space delimiter in java 
                    String[] wordList = line.split("\\s+"); 
                    
                    countWord += wordList.length; 
                    whitespaceCount += countWord -1; 
                    
                    // [!?.:]+ is the sentence delimiter in java 
                    String[] sentenceList = line.split("[!?.:]+"); 
                    
                    sentenceCount += sentenceList.length; 
                } 
            } 
            
            reader.close();

            System.out.println("Total word count = " + countWord); 
            System.out.println("Total number of sentences = " + sentenceCount); 
            System.out.println("Total number of characters = " + characterCount); 
            System.out.println("Number of paragraphs = " + paragraphCount); 
            System.out.println("Total number of whitespaces = " + whitespaceCount); 
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    } 
    public static void main(String[] args) 
    {
        Path path = Path.of("C:/Users/zansari/Documents/GitHub/java-secplus/Hello.txt");
        Database test = new Database(path);
        test.diag(path);
    }
}