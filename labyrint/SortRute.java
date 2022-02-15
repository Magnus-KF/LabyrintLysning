package labyrint;
public class SortRute extends Rute {

    public SortRute(int rad, int kolonne, Labyrint lab) {
        super(rad,kolonne,lab);
    }

    // Lagre denne som ein global variabel?
    public char tilTegn() {
        return '#';
    }
}
