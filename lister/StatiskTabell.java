package lister;
//Er smerten/problema med programmering, noko eg klarer å halde ut? Halder på å miste meir av synet, ganske kjipt
// shit, synet er ganske shitty.

import java.util.Iterator;

public class StatiskTabell<T> implements Tabell<T> {
    T[] tabell;
    int lengde;
    int index;

    public StatiskTabell(int lengde) {
        this.tabell = (T[]) new Object[lengde];
        this.lengde = lengde;
        this.index = 0;
    }

    public int storrelse() {
        int stor = 0;
        for (int i= 0; i<tabell.length; i++) {
            if (tabell[i] != null) {
                stor ++;
            }
        }
        return stor;
    }

    public boolean erTom() {
        boolean tom = true;
        for (int i=0; i<tabell.length; i++) {
            if (tabell[i] != null) {
                tom = false;
                break;
        }
        }
        return tom;
    }

    public void settInn(T element) throws FullTabellUnntak {
      //Iterator itr = new tabell.Iterator();
        try  {
            tabell[index] = element;
            index++;
        }
        catch (Exception e){
            throw new FullTabellUnntak(lengde);
        }
    }

    public T hentFraPlass(int plass) {
        try {
            //T el = Arrays.asList(tabell).indexOf(plass);
            return tabell[plass];
        }
        catch (Exception e) {
            throw new UgyldigPlassUnntak(plass, lengde);
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int peker;
        public ArrayIterator() {

            peker = 0;
        }

        // jesus kristian, hasNext() ved slutten funker ikkje, får outofboundException
        // setter inn ein try-catch, kanskje eg kjem tilbake til det
        @Override
        public boolean hasNext() {
            // return !(lengde >= peker && lengde > 0);

            try {
               /* if (tabell[peker] == null) {
                    return false;
                }*/
                if ((peker < index) && (lengde > 0)) {
                    return true;
                } else {
                    return false;
                }
            }
           catch (Exception e) {
                return false;
           }
        }

        @Override
        public T next() {
            return tabell[peker++];
        }
    }




}