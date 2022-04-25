import java.io.File;


public class ListFiles {

  
    
       static File mainFolder  = null;
      
          static  int filesmoved = 0;
     
   static  int totalfiles = 0;
    
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
         
           System.out.println("\n Total Files Moved:"+filesmoved+ "\n out of total files: "+totalfiles);
         
     }
     
     
     
     public void getFiles(File f){
         File files[];
         if(f.isFile())
           {  System.out.println("\n\n Looking at file: "+f.getAbsolutePath());
                  totalfiles++;
                if (f.getAbsolutePath().contains("FOLDER.DUPLICATE.$DRIVEBENDER"))
                  {
                  filesmoved++;
//Just TESTING
                     System.out.println("\n\n File found in: "+f.getAbsolutePath());
                f.renameTo(new File(f.getAbsolutePath().replace("FOLDER.DUPLICATE.$DRIVEBENDER\\","")));
                System.out.println("moved file to: "+f.getAbsolutePath().replace("FOLDER.DUPLICATE.$DRIVEBENDER\\","")+ "  \n\n this is the "+filesmoved+ "file moved");
                
                  }
                else { } 
             
            } 
             
         else{
			 
			 if(f.getAbsolutePath().contains("$RECYCLE.BIN") || f.getAbsolutePath().contains("System Volume Information"))
			 {
				 
				 System.out.println("Recycle bin or System Vol Files , skipping");
				 
			 }
			 else{
				 
				 System.out.println("Here: "+f.getAbsolutePath());
				 
             files = f.listFiles();
             for (int i = 0; i < files.length; i++) {
             
                System.out.println("["+i +" / " +files.length+"]");
                 getFiles(files[i]);
			 
             }
         }
     }
}

}




