package labyrint; /**
 * Created by frydtzuig on 4/5/17.
 */

// TODO rydde opp i koden, og så levere. kanskje se meir på settminimalutskrift

import java.util.*;
public abstract class Rute {
    protected int xKord;
    protected int yKord;
    //Referanse til labyrinten her...
    protected Labyrint lab;
    //Naboruter
    protected Rute sor;
    protected Rute nord;
    protected Rute ost;
    protected Rute vest;
    // Set som innheld besøkte ruter
    protected static final Set<Rute> set = new HashSet<Rute>();

    public Rute(int rad, int kolonne, Labyrint lab) {
        this.xKord = rad;
        this.yKord = kolonne;
        this.lab = lab;




    }


    //Oppretter link til naboruter her, ved å hente rader og kolloner og setter ein peker til
    // ruten som enten er over, under eller til siden.
    // pekeren opprettes for sjøvle ruten som skal vere ved siden blir opprettet, er det ein problem?
    // det er eit problem, ganske stort eit også...
    // Lage ein metode som  lager linkar til naboene etter at labyrinten har satt inn alle tegn?
    // public settKordinat? for labyrint.Rute rute : labyrint : labArr {rute.settkordinat}....hmm
    // Problemet var at denne var i konstruktøren før, noko som gjorde at kun vest og nord blei linka
    // sidan sor og vest ikkje hadde blitt satt inn i labben
    public void settKordinat() {
        int maxX = lab.hentRad()-1;
        int maxY = lab.hentKols()-1;

        if(yKord > 0) {this.nord = lab.hentArr()[xKord][yKord-1];}
        else { this.nord = null;}

        if(yKord < maxY) {this.sor = lab.hentArr()[xKord][yKord+1]; }
        else {this.sor = null;}

        if(xKord > 0) {this.vest = lab.hentArr()[xKord-1][yKord];}
        else {this.vest = null;}

        if(xKord < maxX) {this.ost = lab.hentArr()[xKord+1][yKord];}
        else {this.ost = null;}

    }

    //Return mellomrom eller #
    public abstract char tilTegn();

    // trengte ein metode som sjekka om ruta hadde blitt besøkt
    // legger den til om ikkje
    public boolean besøkt(Rute rute) {
        //labyrint.Rute[] array;

        if (set.contains(rute)) {
            return true;
        }
        set.add(rute);
        return false;

    }

    // kalle på naboruter, unntatt den som sendte kallet.
    // bør gaa ta inn nokon parameter? , ellers så går den berre i ein slags ring?
    // Ingen parameter vs. parameter

    // ikkje boolean men labyrint.Rute? sender aapningsrutene tilbake?
    // om set er tomt elr ikj?

    // Sleit litt med denne, lurte på om eg skulle sende med noko i kallet
    // Men den kaller jo pao seg sjøl
    // og naborutene kaller på seg sjøl
    // og maborutene kaller på seg sjøl
    // så det er ikkje nødvendig

    public void gaa(String kord) {

        // Strengen formateres her
        kord = kord +"("+xKord+", "+yKord+") --> ";


        // "Målet" er åpning, så det er basistilfeller, eller slutten på ein måte
        boolean erAapning = this instanceof Aapning;
        //Basistilfeller dersom, det er ved åpningen eller, den er omringet av svarte og besøkte ruter..
            // Tenkte på om det skulle vere noko anna, men denne holder
        if (erAapning == true) {
            // utvegane blir lagt inn her som ein string
            lab.stabel.settInn(kord);

        }

        //Dersom den går inn i ein blindvei kjem den ikkje ut. hjelpemetode for vegen ein kom frå?
        // instanceof metoden var veldig nyttig i denne delen
        // Første sjekken sjekker om nokon av naborutene er labyrint.HvitRute, og sidan aapning er ein subklasse
        // av den igjen, så slepp eg å skrive det
        // Den sjekker alle naboruter og går den vegen om den ikkje har gått der og det er ei kvitrute
        // og når den kjem der, skjer det same
        else if (this.sor instanceof HvitRute|| this.nord instanceof HvitRute || this.ost instanceof HvitRute || this.vest instanceof HvitRute) {
            if (this.besøkt(nord) == false && nord instanceof HvitRute) {
                //System.out.println(this.nord.tilTegn() + "nord");
                nord.gaa(kord);

            }
            if (this.besøkt(sor) == false && sor instanceof HvitRute) {
                //System.out.println(this.sor.tilTegn() + "sor");
                sor.gaa(kord);

            }
            if (this.besøkt(vest) == false && vest instanceof HvitRute) {
                //System.out.println(this.vest.tilTegn() + "vest");
                vest.gaa(kord);
            }
            if (this.besøkt(ost) == false && ost instanceof HvitRute) {
                //System.out.println(this.ost.tilTegn() + "ost");
                ost.gaa(kord);
            }
        }
        // Midlertidig løysing at den returnerte ein bool, true om den fant ein åpning
        //return false;



    }



    // Dersom gaa, har aapning som slutt legg den til?
    // finnuteifra i labyrint tar kol rad og kaller på finnutvei
    // rute rute = arg[rad][kol]
    // rute.finnutvei
    public void finnUtvei() {

        // Den late versjonen, sjekker berre om det er ein utvei
       /* if (set.contains(instanceof labyrint.Aapning)) {
            System.out.println("Ein utvei finnes ihvertfall");
        }*/
       if (this instanceof SortRute) {
           System.out.println("Svart rute");
       }
       else {
           this.gaa("");

           // Printer ut stringane til utvegane om settminimalutskrift ikkje har blirr aktivert
           for (String string : lab.stabel) {
               if (lab.blokkere == false) {
               System.out.println(string); }
           }
       }



    }

}
