package lister;

public class Koe<T> extends Super<T> implements Liste<T> {




    public Koe() {
        super();


    }

    //Sett inn bakserst, istadenfor foran, skal vere einaste forskjellen
    @Override
    public void settInn(T element) {
        if (hode == null) {
            // tom liste
            hode = new Node<T>(element);
            hale = hode;
        } else {
            Node<T> ny = new Node<T>(element);

            ny.settInnMellom(hale, null);
            hale = ny;

        }
        lengde++;
    }



}





/*Skriv en klasse Koe<T> som implementerer grensesnittet Liste<T> . settInn(T
        element) skal sette inn element på slutten av listen, og fjern() skal ta ut et
        element fra starten av listen.*/