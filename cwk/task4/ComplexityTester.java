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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ComplexityTester {
   public static void main(String args[]) throws IOException {
    getDirectoryPath(args[0]);
   }

   static void getDirectoryPath(String path) {
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
            if (lowercaseName.endsWith(".java")) {
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
         int numberOfKeyWords=ReadFile(file.getAbsolutePath().toString());
         int numberOfMethods=InspectClass(path, noExtension);
         System.out.println("Has "+ numberOfMethods+ " methods");
         System.out.println("Has "+ numberOfKeyWords+ " keywords");
         int cyclomaticComplexity= numberOfKeyWords+numberOfMethods;
         System.out.println("Has a complexity of: "+cyclomaticComplexity);

      }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   //here
   static int ReadFile(String path) {
     String fileContent="";
     String temp="";
     int keyWords=0;
   try {
     File f = new File(path);
     byte[] bf = new byte[(int)f.length()];
     new FileInputStream(f).read(bf);
     fileContent = new String(bf, "UTF-8");
     //remove all comments from the string
     String noComments= fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
     String delims = "[ ]+";
     String[] tokens = noComments.split(delims);
     for(int i = 0; i < tokens.length; i++){
       if(tokens[i].trim().length() > 0){
         temp=tokens[i].replaceAll("\\s","");
         if(temp.matches(".*if.*|.*while.*|.*for.*|.*case.*|.*switch.*|.*try.*|.*catch.*|.*\\|\\|.*|.*&&.*|.*\\|\\|.*|.*&&.*")){
           keyWords++;
         }
       }
     }
     //System.out.println("Number of keywords: "+keyWords);
 } catch (FileNotFoundException e) {
     e.printStackTrace();
 } catch (IOException e) {
     e.printStackTrace();
 }
 return keyWords;
}

//This method returns the number of methods for each class in the directory
static int InspectClass(String directoryPath, String noExtension) throws ClassNotFoundException, MalformedURLException {
    @SuppressWarnings("unchecked")
        URL classUrl;
        int numberOfMethods=0;
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
           numberOfMethods=0;
           //System.out.println(className+ " Methods are: "); //testing line
           for (int i = 0; i < m.length; i++){
             //System.out.println(m[i].toString()); //testing line
             numberOfMethods++;
           }
        }
        catch (Throwable e) {
           System.err.println(e);
        }
        return numberOfMethods;
    }
}
