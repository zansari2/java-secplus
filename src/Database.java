import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.io.File;

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
            File f = new File(path.toString());
            FileWriter write = new FileWriter(f);
            write.write("Hello World!");
            write.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) 
    {
        Path path = Path.of("C:/Users/zansari/Documents/GitHub/java-secplus/Hello.txt");
        Database test = new Database(path);
    }
}