import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by adeogirikar on 16/07/2015.
 */


public class CreateFriends {

    public ArrayList<String> ReadFriendsTextFile(String filename) {

        ArrayList<String> names = new ArrayList<String>();
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

            int i =0;
            while((line = bReader.readLine()) != null)
            {
                names= SplitLineIntoNames(line,names);
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
        return names;
    }

    private ArrayList<String> SplitLineIntoNames(String line, ArrayList<String> names) {


        String [] name = line.split(";");
        if(name.length <3 && !name[0].isEmpty() && !name[1].isEmpty()) {
            names.add(name[0]);
            names.add(name[1]);
        }

        return names;
    }
}
