package writerAndReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by David Stovlbaek on 30/09/16.
 */
public class ReadBlog {

    public static String readBlog() throws FileNotFoundException{
        String file = "/Users/Combii/Dropbox/Datamatiker/2. Semester/Technology/GoogleProject Local/Technology1_startup_project/web/blogText.txt";
        Scanner input = new Scanner(new File(file));

        String rString = "";

        while(input.hasNext()){
            rString += input.nextLine() + "\n";
        }
        return rString;
    }
}
