package lister;

public class Node<T> implements Comparable<T>{
    protected Node<T> neste;
    protected Node<T> forrige;
    protected T innhald;

    public  Node() {

    }
    public Node(T innhald) {
        this.innhald = innhald;
    }

   // public Node<T> hentKopi(T innhald) {return Node temp = new Node(innhald);}

     @Override
    public int compareTo(T element) {
        Node andre = (Node) element;
        return this.toString().compareTo(andre.toString());

        }

    public T hentInnhald() {
        return innhald;
    }
    public Node<T> hentForrige() {
        return forrige;
    }

    public String toString() {
        return innhald.toString();
    }

    public Node<T> hentNeste() {
        return neste;
    }

    public void settNeste(Node<T> neste) {
        this.neste = neste;
    }

    public void settForrige(Node<T> forrige) {
        this.forrige = forrige;
    }

    public void settInnMellom(Node<T> venstre, Node<T> hoyre) {
        if (venstre != null) {
            venstre.settNeste(this);
            this.settForrige(venstre); // alt: forrige = venstre;
        }

        if (hoyre != null) {
            hoyre.settForrige(this);
            this.settNeste(hoyre);
        }
    }

    public void taUt() {
        // kun eit element
        if (neste == null && forrige == null) {
        }
        //enden
        else if (neste == null) {
            forrige.settNeste(null);
            forrige = null;
        }
        // starten
        else if (forrige == null) {
            neste.settForrige(null);
            neste = null;
        }
        else {
            forrige.settNeste(neste);
            neste.settForrige(forrige);
            neste = null;
            forrige = null;
        }
    }
}
