/* This code for OS operation */

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;


public class First 
{
  public static void main(String args[])throws IOException
  { 
	  int op = 1;
	  Scanner sc = new Scanner(System.in);
	
	  //Creating a File object for directory
		
	   System.out.print("Enter path for this operation : ");
	   String s1 = sc.nextLine();
	   File directoryPath = new File(s1);
	
	while(op == 1)
	{
	  
    
    menu();
    System.out.print("Enter your choice:");
    int ch = sc.nextInt();
    System.out.println("\n----------------------------\n");
    
	switch (ch)
	{
	case 1 : operation1(directoryPath);
	         System.out.println("[1] lists the names of all the files and directories in the path");
			 break;
			 
	case 2 : operation2(directoryPath);
			 System.out.println("[2] Prints the name, path and,size of all the files in the path");
			 break;
			 
	case 3 : operation3(directoryPath);
	         System.out.println("[3] Prints the names of the text files in the path");
	 		 break;
	
	case 4 : operation4(directoryPath);
	         System.out.println("[4] Prints the name, path and, size of all the text files in the path");
			 break;
	
	case 5 : operation5(directoryPath);
          	System.out.println("[5] prints the name, path and, size of all the files (not folders) in the path");
	        break;
	        
   default : System.out.println("Enter wrong option !! Try again..");
             break;
	}
	System.out.println("-----------------------------------------");
	System.out.print("Press [1] Continue || Other keys for exit : ");
	op = sc.nextInt();
	System.out.println("------------------------------------------");
	}
  }
  
public static void menu()
  {
  System.out.println("------------------------------------");
  System.out.println("\t Menu for Operations:");
  System.out.println("------------------------------------");
  System.out.println("[1] lists the names of all the files and directories in the path");
  System.out.println("[2] Prints the name, path and,size of all the files in the path");
  System.out.println("[3] Prints the names of the text files in the path");
  System.out.println("[4] Prints the name, path and, size of all the text files in the path");
  System.out.println("[5] prints the name, path and, size of all the files (not folders) in the path");
  System.out.println("----------------------------------------------------");
  }
 
/*Operation-1 : The following Java program lists the names of all the files 
  and directories in the path */

  
  public static void operation1(File directoryPath) throws IOException 
{ 
	  
      
      //List of all files and directories
      String contents[] = directoryPath.list();
      System.out.println("List of files and directories in the specified directory:");
      for(int i=0; i<contents.length; i++) {
         System.out.println(contents[i]);
      }
     
}


/*Operation-2:The following Java program prints the name, path and, 
 size of all the files in the path */

public static void operation2(File directoryPath) throws IOException 
{
      
    //List of all files and directories
      File filesList[] = directoryPath.listFiles();
      System.out.println("List of files and directories in the specified directory:");
      for(File file : filesList) {
         System.out.println("File name: "+file.getName());
         System.out.println("File path: "+file.getAbsolutePath());
         System.out.println("Size :"+file.getTotalSpace());
         System.out.println(" ");
      }
}

/*Operation-3:The following Java program prints the names 
 of the text files in the path */

public static void operation3(File directoryPath) throws IOException 
{
    FilenameFilter textFilefilter = new FilenameFilter(){
       public boolean accept(File dir, String name) {
          String lowercaseName = name.toLowerCase();
          if (lowercaseName.endsWith(".txt")) {
             return true;
          } else {
             return false;
          }
       }
    };
    //List of all the text files
    
    String filesList[] = directoryPath.list(textFilefilter);
    System.out.println("List of the text files in the specified directory:");
    for(String fileName : filesList) {
       System.out.println(fileName);
    }
 }

/*Operation-4:The following Java program prints the name, path and, 
 size of all the text files in the path */

public static void operation4(File directoryPath) throws IOException 
{
   FilenameFilter textFilefilter = new FilenameFilter(){
      public boolean accept(File dir, String name) {
         String lowercaseName = name.toLowerCase();
         if (lowercaseName.endsWith(".txt")) {
            return true;
         } else {
            return false;
         }
      }
   };
   //List of all the text files
   File filesList[] = directoryPath.listFiles(textFilefilter);
   System.out.println("List of the text files in the specified directory:");
   for(File file : filesList) {
      System.out.println("File name: "+file.getName());
      System.out.println("File path: "+file.getAbsolutePath());
      System.out.println("Size :"+file.getTotalSpace());
      System.out.println(" ");
   }
}

/*Operation-5:The following Java program prints the name, path and, 
size of all the files (not folders) in the path*/

public static void operation5(File directoryPath) throws IOException 
{
      FileFilter textFilefilter = new FileFilter(){
         public boolean accept(File file) {
            boolean isFile = file.isFile();
            if (isFile) {
               return true;
            } else {
               return false;
            }
         }
      };
      //List of all the text files
      File filesList[] = directoryPath.listFiles(textFilefilter);
      System.out.println("List of the text files in the specified directory:");
      for(File file : filesList) {
         System.out.println("File name: "+file.getName());
         System.out.println("File path: "+file.getAbsolutePath());
         System.out.println("Size :"+file.getTotalSpace());
         System.out.println(" ");
      }
   }

//-------------- End Of all Operation ------------------
}
