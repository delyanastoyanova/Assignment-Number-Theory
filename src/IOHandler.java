import java.io.IOException;
import java.util.ArrayList;

public class IOHandler {
    public static void main(String[]args) throws IOException{
        //path of the file is C:\\Users and the name of the file is text.txt
        String path="C:/Users/Delyana/Desktop/example.txt";
       try{
           ReadFile read=new ReadFile(path);
           ArrayList<String> lines=read.Open();
           for(int i=0;i<lines.size();i++){
               //print the lines form the file
               System.out.println(lines.get(i));
           }
       }
       catch(IOException exception){
           System.out.println(exception.getMessage());
        }
    }
}
