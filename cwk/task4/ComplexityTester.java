import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.lang.reflect.*;

public class ComplexityTester {
   public static void main(String args[]) throws IOException {
     String path= args[0];
     File filesList[]=GetDirectoryPath(path);
     CalculateComplexity(path, filesList);
   }

   //Follow the directory path and get all the file locations
   static File[] GetDirectoryPath(String path) throws FileNotFoundException{
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
      //List of all the the java files in the directory
      File filesList[] = directoryPath.listFiles(textFilefilter);
      return filesList;
    }

   //Method for reading the contents of .java files.
   static int ReadFile(String path) {
     String fileContent="";
     String temp="";
     int keyWords=0;
   try {
     File f = new File(path);
     byte[] bf = new byte[(int)f.length()];
     //in order to remove all the comments, we cannot read the file line by line
     new FileInputStream(f).read(bf);
     fileContent = new String(bf, "UTF-8");
     //remove all comments from the string
     String noComments= fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
     String delims = "[ ]+";
     String[] tokens = noComments.split(delims);
     for(int i = 0; i < tokens.length; i++){
       if(tokens[i].trim().length() > 0){
         temp=tokens[i].replaceAll("\\s","");
         //check for keywords
         if(temp.matches(".*if.*|.*while.*|.*for.*|.*case.*|.*switch.*|.*try.*|.*catch.*|.*\\|\\|.*|.*&&.*|.*\\|\\|.*|.*&&.*")){
           keyWords++;
         }
       }
     }
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
        String directoryURL= ("file://"+directoryPath+"/");
        classUrl = new URL(directoryURL);
        URL[] classUrls = { classUrl };
        URLClassLoader ucl = new URLClassLoader(classUrls);
        Class c = ucl.loadClass(noExtension);
        try {
           Method m[] = c.getDeclaredMethods();
           String className = c.getName();
           numberOfMethods=0;
           for (int i = 0; i < m.length; i++){
             numberOfMethods++;
           }
        }
        catch (Throwable e) {
           System.err.println(e);
        }
        return numberOfMethods;
    }

    static void CalculateComplexity(String path, File filesList[]) {
      int numberOfFiles=0;
      int totalComplexity=0;
      int averageComplexity;
      int highestCompexity=-1;
      String highestFile="";
      try {
        for(File file : filesList) {
          //Use regex to remove the class extension, required for Relefection API
           String noExtension= file.getName().replaceFirst("[.][^.]+$", "");
           System.out.println("File name: "+ noExtension);
           int numberOfKeyWords=ReadFile(file.getAbsolutePath().toString());
           int numberOfMethods=InspectClass(path, noExtension);
           //testing lines
           //System.out.println("Has "+ numberOfMethods+ " methods");
           //System.out.println("Has "+ numberOfKeyWords+ " keywords");
           int cyclomaticComplexity= numberOfKeyWords+numberOfMethods;
           System.out.println("Has a complexity of: "+cyclomaticComplexity);
           //calculate the average complexity
           numberOfFiles++;
           totalComplexity=totalComplexity + cyclomaticComplexity;
           //calculate the maximum complexity
           if (cyclomaticComplexity > highestCompexity){
             highestCompexity=cyclomaticComplexity;
             highestFile= noExtension;
           }
      }
      averageComplexity=(totalComplexity / numberOfFiles);
      System.out.println("\n");
      System.out.println("The average complexty of the directory is: "+averageComplexity);
      System.out.println("The maximum complexty of the directory is: "+highestFile+" with: "+highestCompexity);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
