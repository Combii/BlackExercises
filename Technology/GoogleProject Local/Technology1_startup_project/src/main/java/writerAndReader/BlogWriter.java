package writerAndReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by David Stovlbaek on 30/09/16.
 */
public class BlogWriter {
    public static void writeToBlog(String text) throws IOException{
        String filePath = "/Users/Combii/Dropbox/Datamatiker/2. Semester/Technology/GoogleProject Local/Technology1_startup_project/web/blogText.txt";

        File file = new File(filePath);
        FileWriter fr = new FileWriter(file);
        BufferedWriter br  = new BufferedWriter(fr);

        br.write(text);
        br.close();
    }
}
