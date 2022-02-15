import labyrint.Labyrint;

import java.lang.*;
import java.io.*;

public class Test {


    public static void main (String[] args) {

        //Scanner in = new Scanner(System.in);
        //String s = in.nextLine();




        File file = new File("7.in");
        //System.out.println(file);
        try {
            //BufferedReader reader = new BufferedReader(new FileReader(s));

            Labyrint lab1 = Labyrint.lesFraFil(file);
            System.out.println(lab1.toString());
            //System.out.println(lab1.toString());
  //          labyrint.Rute[][]arrg = lab1.hentArr();
/*
            labyrint.Rute rute = arrg[3][3];
            rute.gaa();*/

            lab1.finnUtveiFra(1, 1);

        }
    catch(FileNotFoundException e) {
            System.out.println("ingen fil");

        }



    }

}
