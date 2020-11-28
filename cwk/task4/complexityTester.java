import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class complexityTester {
   public static void main(String args[]) throws IOException {
     System.out.println("Code got here");
    printDirectoryPath(args[0]);
   }

   static void printDirectoryPath(String path) {
       try {
            Path testPath = Paths.get(path);
          //Path testPath = Paths.get("/home/cserv1_a/soc_msc/ll16kdt/modules/AdvEng/task4");
            if (Files.notExists(testPath)) {
              System.out.println("Directory not found");
                return;
           }
           //Creating a File object for directory
           //File directoryPath = new File("/home/cserv1_a/soc_msc/ll16kdt/modules/AdvEng/task4");
           File directoryPath = new File(path);
           //List of all files and directories
           String contents[] = directoryPath.list();
           System.out.println("List of files and directories in the specified directory:");
           for(int i=0; i<contents.length; i++) {
              System.out.println(contents[i]);
           }

       } catch (Exception e) {
           e.printStackTrace();
       }

   }

}
