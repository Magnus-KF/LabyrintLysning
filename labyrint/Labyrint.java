package labyrint; 
import lister.*;
import java.io.*;
import java.util.Scanner;

public class Labyrint {
    //2D array
    Rute[][] arr;
    protected int rader;
    protected int kolonner;
    protected boolean blokkere;


// Lagrar rader, kolonner og arrayen
    private Labyrint (int rad, int kolonne) {
        this.rader = rad;
        this.kolonner = kolonne;
        //Dette burde lage 2d arren...
        this.arr = new Rute[rad][kolonne];

    }
    // Stabel til tostring metoden
    public Liste<String> stabel = new Stabel();


    // Henter noko greier, for å laga pekera etc.
    public int hentRad () {return rader;}
    public int hentKols() {return kolonner;}


    public Rute[][] hentArr () {
        return arr;

    }

    @Override
    public String toString() {

        // For kvar enkelt rute legg til stringen, newline ved slutten av ein rad.
        String aString = "";
        for(int kols = 0; kols < kolonner; kols++) {
            for(int rad = 0; rad < rader; rad++) {
                aString = aString + arr[rad][kols].tilTegn();
            }
            aString = aString + "\n";
        }
        return aString;
    }



    public static Labyrint lesFraFil (File fil) throws FileNotFoundException{
        //ganske dust innlesing av tall...
        Scanner scanner = new Scanner(fil).useDelimiter("\n");

        // Eigen scanner for talla, som bruker mellomrom som delimiter
        // Gjorde det slik fordi standard delimiteren er mellomrom, mens labyrinten er greiast å lese med \n
        Scanner idk = new Scanner(fil);
        int[] tall = new int[2];
        int i = 0;
        while (idk.hasNextInt()) {
            tall[i++] = idk.nextInt();
        }
        idk.close();
       
        Labyrint lab = new Labyrint(tall[1], tall[0]);

        //Linje = kolonnenummer
        int linje = 0;
        String str = scanner.next();

        // Mest tricky bit, går igjennom kvar enkelt char og lager ein rute.
        while (scanner.hasNext()) {
            // hopper til første del av laben
            str = scanner.next();
            // linje og scanner.hasNext sørger for y-aksen, mens for(t) og tall[1] har ansvar for x.
            for (int t = 0; t< tall[1]; t++) {
                char c = str.charAt(t);

                if (c=='#') {

                SortRute rute = new SortRute(t, linje, lab);

                // Referanse til ruta i labyrinten
                lab.hentArr()[t][linje] = rute;
                }
                else {
                    // Blei slått av litt inspirasjon her, løysinga mi på dørproblemet
                    // er at eg sjekker om charen er på kollonne eller rad, [min] eller [max]
                    // bruker bool, dvs, l == 0 ELLER etc.
                    // enten min eller max, dvs det innleste tallen - 1
                    if (linje == 0 || linje == tall[0]-1 || t == 0 || t==tall[1]-1) {
                        Aapning rute = new Aapning(t, linje, lab);
                        lab.hentArr()[t][linje] = rute;

                    }
                    else {
                        HvitRute rute = new HvitRute(t, linje, lab);
                        lab.hentArr()[t][linje] = rute;

                    }
                }
            }
            linje++;
        }
        scanner.close();


        // Kvar rute, får riktige naboar, har denne til slutt, når alle rutene er satt på plass
        for (Rute[] arrh : lab.hentArr()) {
            for (Rute enkel : arrh) {
            enkel.settKordinat(); }

        }
        return lab;       
    }

    // Kanskje ikkje den mest elgante maoten ao gjere dette pao
    // set ein variabel til aa ve true, som bli sjekka i ein if lokkje, som inneheld print funksjona
    public void settMinimalUtskrift() {
        this.blokkere = true;

    }

    // Lage ein ny stabel fro kvar gong, så det e kun dei aktuelle som blir skreve ut og ikkje alle
    public Liste<String> finnUtveiFra(int kol, int rad) {
        this.stabel = new lister.Stabel<>();
        // kol og rad er motsatt i forhold til labyrinten, noko som e forvirrande
        Rute rute = this.arr[rad][kol];
        //kalle pao finnutvei i rute
        rute.finnUtvei();
        return(stabel);
    }
}

