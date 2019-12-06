import java.io.File;


public class ListFiles {

  
    
       static File mainFolder  = null;
    
     public static void main(String[] args)
     {
     
     if(args.length == 0)
    {
        System.out.println("Proper Usage is: java ListFiles <PATH>");
        System.exit(0);
    }
     
    mainFolder = new File(args[0].replaceAll("\"", "\\\\\""));
         ListFiles lf = new ListFiles();
         lf.getFiles(lf.mainFolder);
     }
     
     
     
     public void getFiles(File f){
         File files[];
         if(f.isFile())
           {  System.out.println("\n\n Looking at file: "+f.getAbsolutePath());
                if (f.getAbsolutePath().contains("FOLDER.DUPLICATE.$DRIVEBENDER"))
                  {
                  
                     System.out.println("\n\n File found in: "+f.getAbsolutePath());
                f.renameTo(new File(f.getAbsolutePath().replace("FOLDER.DUPLICATE.$DRIVEBENDER\\","")));
                System.out.println("moved file to: "+f.getAbsolutePath().replace("FOLDER.DUPLICATE.$DRIVEBENDER\\",""));
                
                  }
                else {}
             
            } 
             
         else{
             files = f.listFiles();
             for (int i = 0; i < files.length; i++) {
                 getFiles(files[i]);
             }
         }
     }
}





