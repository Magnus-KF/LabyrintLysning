package labyrint;

/**
 * Created by frydtzuig on 4/5/17.
 */
public class SortRute extends Rute {


    // Kordinatene? hmm hmm hmm
    public SortRute(int rad, int kolonne, Labyrint lab) {
        super(rad,kolonne,lab);
    }

    // Lagre denne som ein global variabel?
    public char tilTegn() {
        return '#';
    }
}
