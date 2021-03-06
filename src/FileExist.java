// This program checks if a file (dictionary) exists and outputs the word and
// its definition(s).

import java.io.*;

public class FileExist {

    public static void doesFileExist(String path) throws Exception {

        // Open file in path
        File file = new File(path);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str;
            while ((str = br.readLine()) != null) {
                
                // Split string at " - " and ", "
                String[] arrOfStr = str.split(" - |, ");

                for (String a : arrOfStr) {
                    System.out.println(a);
                }
                
            }
            br.close();
        } catch (IOException e) {
            System.out.print("\nFile does not exist.\n\n");

            // Prints out errors
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) throws Exception {
       
        // doesFileExist("src/test.txt");
        doesFileExist("test.txt");
    }
}
