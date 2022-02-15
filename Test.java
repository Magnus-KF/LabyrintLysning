import labyrint.Labyrint;

import java.lang.*;
import java.io.*;

public class Test {


    public static void main (String[] args) {

        File file = new File("3.in");

        try {


            Labyrint lab1 = Labyrint.lesFraFil(file);
            System.out.println(lab1.toString());


            lab1.finnUtveiFra(1, 1);

        }
    catch(FileNotFoundException e) {
            System.out.println("ingen fil");

        }



    }

}
