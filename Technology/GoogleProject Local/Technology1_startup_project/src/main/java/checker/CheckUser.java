package checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by David Stovlbaek on 20/09/16.
 */
public class CheckUser {


public static int checkUser(String username, String password) throws FileNotFoundException{

    String filePath = "/Users/Combii/Dropbox/Datamatiker/2. Semester/Technology/GoogleProject Local/Technology1_startup_project/web/users.txt";

    File file = new File(filePath);

    Scanner input = new Scanner(file);

    while(input.hasNext()){
        if(input.next().equals("user:")){
        if(input.next().equals(username)){
            if(input.next().equals(password)){
                return Integer.parseInt(input.next());
            }
        }
        }
    }
    return -1;
}

}
