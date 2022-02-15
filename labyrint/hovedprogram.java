package labyrint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lister.Liste;

class Oblig5 {
    public static void main(String[] args) {
        String filnavn = null;

        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("FEIL! Riktig bruk: "
                               +"java labyrint.Oblig5 <labyrintfil>");
            return;
        }
        File fil = new File(filnavn);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }
            //TODO hmmm? ahh. fjern alle utskrifter frå mitt program...
        l.settMinimalUtskrift();
        System.out.println(l.toString());


        // les start-koordinater fra standard input
        Scanner inn = new Scanner(System.in);
        while (inn.hasNextLine()) {
            String[] ord = inn.nextLine().split(" ");
            int startKol = Integer.parseInt(ord[0]);
            int startRad = Integer.parseInt(ord[1]);
            // TODO finnutveifra er void? sett den til string?
            Liste<String> utveier = l.finnUtveiFra(startKol, startRad);
            if (!utveier.erTom()) {
                for (String s : utveier) {
                    System.out.println(s);
                }
            } else {
                System.out.println("Ingen utveier.");
            }
            System.out.println();
        }
    }
}
