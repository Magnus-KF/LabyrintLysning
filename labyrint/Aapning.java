package labyrint;

public class Aapning extends HvitRute {

    // Lage ein greie for kordinater?
public Aapning (int rad, int kolonne, Labyrint lab) {
    super(rad,kolonne,lab);
}
    public char tilTegn() {
        return '≡';
    }

}

