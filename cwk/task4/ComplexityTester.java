import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.*;

public class ComplexityTester {
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
        //Use regex to remove the class extension
         String noExtension= file.getName().replaceFirst("[.][^.]+$", "");
         System.out.println("File name: "+ noExtension);
         ReadFile(file.getAbsolutePath().toString());
         InspectClass(path, noExtension);
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
//here
static void InspectClass(String directoryPath, String noExtension) throws ClassNotFoundException, MalformedURLException {
    @SuppressWarnings("unchecked")
        URL classUrl;
        //this line needs to be changed to take a classpath
        String directoryURL= ("file://"+directoryPath+"/");
        classUrl = new URL(directoryURL);
        URL[] classUrls = { classUrl };
        URLClassLoader ucl = new URLClassLoader(classUrls);
        //This would be a for() loop to get every .class file in the directory
        Class c = ucl.loadClass(noExtension);
        try {
           Method m[] = c.getDeclaredMethods();
           String className = c.getName();
           System.out.println(className+ " Methods are: ");
           for (int i = 0; i < m.length; i++){
             System.out.println(m[i].toString());
           }
        }
        catch (Throwable e) {
           System.err.println(e);
        }
    }
}
