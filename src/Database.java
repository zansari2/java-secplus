import java.nio.file.Path;
import java.io.*;

/**
 * A set of questions
 */
public class Database
{
    String[] terms;
    String[] definitions;
    int max;
    /**
     * Create a database using a file path
     * @param path the file path
     */
    public Database(Path path)
    {
        terms = new String[333];
        definitions = new String[333];
        max = 0;
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
            File file = new File(path.toString()); 
            FileInputStream fileStream = new FileInputStream(file); 
            InputStreamReader input = new InputStreamReader(fileStream); 
            BufferedReader reader = new BufferedReader(input); 
            String line = "";
            boolean swich = false;
            int i = 0;
            while((line = reader.readLine()) != null) 
            { 
                if(swich==false)
                {
                    terms[i]=line;
                    swich = true;
                    max++;
                }
                else
                {
                    definitions[i]=line;
                    swich = false;
                    i++;
                }
            }
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
    /**
     * Print current values in database
     * @param args
     */
    public void print()
    {
        for(int s = 0; s < terms.length; s++)
        {
            if(terms[s]!=null)
            {
                System.out.println(terms[s]);
                System.out.println(definitions[s]);
                System.out.println();
            }
        }
    }
    /**
     * @return the max
     */
    public int getMax() 
    {
        return max;
    }
    /**
     * @return the definitions
     */
    public String[] getDefinitions() {
        return definitions;
    }
    /**
     * @return the terms
     */
    public String[] getTerms() {
        return terms;
    }
    public static void main(String[] args) 
    {
        Path path = Path.of("C:/Users/zansari/Documents/GitHub/java-secplus/Data.txt");
        Database test = new Database(path);
        test.print();
    }
}