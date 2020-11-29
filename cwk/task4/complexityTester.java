import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;

public class complexityTester {
   public static void main(String args[]) throws IOException {
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
           FilenameFilter textFilefilter = new FilenameFilter(){
           public boolean accept(File dir, String name) {
            String lowercaseName = name.toLowerCase();
            if (lowercaseName.endsWith(".class")) {
               return true;
            } else {
               return false;
            }
         }
      };
      //List of all the text files
      File filesList[] = directoryPath.listFiles(textFilefilter);
      for(File file : filesList) {
         System.out.println("File name: "+file.getName());
         ReadFile(file.getAbsolutePath().toString());
      }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   //here
   static void ReadFile(String path) {
   BufferedReader reader;
    int numberOfLines=1;
    int percentOfComments;
   try {
     reader = new BufferedReader(new FileReader(path));
     String line = reader.readLine();
     while (line != null) {
        //for my line of code measure, I have decided to skip blank lines
        if(line.trim().length() > 0){
             //System.out.println(line);
              numberOfLines++;
        }
        // read next line
       line = reader.readLine();
     }
     reader.close();
      System.out.println("Number of lines in code: "+numberOfLines);
   } catch (IOException e) {
     e.printStackTrace();
   }
 }
}
