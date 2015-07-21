import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by adeogirikar on 16/07/2015.
 */
public class CreateFriends {

    public String ReadFriendsTextFile(String filename) {
        FileReader file = null;
        BufferedReader bReader = null;
        String line;
        String allText = "";
        try {
            file = new FileReader(filename);
            bReader = new BufferedReader(file);
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }

        try {
            while((line = bReader.readLine()) != null)
            {
                allText += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(file != null)
            {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //System.out.println(allText);
        return allText;
    }
}
