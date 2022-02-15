package lister;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Super<T> extends Node<T> implements Liste<T> {
    //sett opp halen og hodet, samt lengden
    protected Node<T> hode;
    protected Node<T> hale;

    protected int lengde;

    public Super() {lengde = 0;}

    public int storrelse() { return lengde;}

    public boolean erTom() {
        return lengde == 0;

    }

    /*Skal ta inn eit element og legge den til i lista, men på forskjellige plassar
    * hmm */
    public void settInn(T element) {
        //Enten er lista tom, eller så skal den inn i slutten
        //Her var det eit problem i forhold til den orignale koden, skreiv hale
        // istadenfor hode, så den fekk ikkje satt inn skikkelig
        if (hode == null) {
            hode = new Node<T>(element);
            hale = hode;
        }
        else {
            Node<T> ny = new Node<T>(element);
            ny.settInnMellom(null, hode);
            hode = ny;

        }
        lengde++;

    }

    //Fjern er lik for alle dei tre listene, dvs den skal ta ut første T.
    public T fjern() {
        Node<T> mori = hode;
        hode = mori.hentNeste();
        mori.taUt();
       /* if (hode.hentNeste() != null) {hode = mori.hentNeste();}*/
//        else {hode = null;}
        lengde--;
        return mori.hentInnhald();

    }

    public Iterator<T> iterator() {
        return new Super.SuperIterator();
    }
    protected class SuperIterator implements Iterator<T> {

        protected Node<T> noNode = null;

        public SuperIterator() {


        }
        @Override
        public boolean hasNext() {
            return noNode != hale;

        }

        @Override
        public T next() {
            if (noNode == null) {
                noNode = hode;
                return noNode.hentInnhald();
            }

            if(noNode.hentNeste() == null) {
                System.out.println(noNode.toString());
                throw new NoSuchElementException("eyhee");

            }
            noNode = noNode.hentNeste();
            return noNode.hentInnhald();
        }

    }


}
