package lister;

public class OrdnetLenkeliste<T extends Comparable<T>> extends Super<T> implements Liste<T> {


    public OrdnetLenkeliste() {
        super();
    }




    @Override
    public void settInn (T element) {

        //Dersom hodet er null, sett inn der....
        //hmm, vil uansett ikkje gi nokon feil ved Lege dømene.
        if (hode == null) {
            hode = new Node<T>(element);
            hale = hode;
        }

        //Dersom hodet ikkje er lik null.
        else {

            // Samanlikne med hodet
            if (element.compareTo(hode.hentInnhald()) <= 0) {

                //Okai, dette fika opp i ordnetlenkeliste.... satt det forrige hodet til å vere
                // dn nye hodet sin neste.
                Node<T> hmm = hode;
                hode = new Node<T>(element);
                hode.settNeste(hmm);


            }

            //Her var mykje av problemet med ordnet lenkeliste, mangla settneste metode på nodar
            // Som er i midten. Dermed fungerete ikkje iteratoren
            // Så eg satt inn ein else if, som fanger opp dei elementa som er større, eller lik halen
            // og satt dei til å bli ny hale

            // Mens else metoden tar resten som hamnar i midten og set den nye noden til å hamne lenka.


            else if (element.compareTo(hale.hentInnhald()) >= 0) {
                Node<T> ny = new Node<T>(element);
                Node<T> old = hale;
                hale = ny;
                old.settNeste(ny);
            }
            else {
                // Må legge til ein settneste.
                // ein noNode.settneste neste i køen
                // ellers, sett den inn i midten.

                Node<T> forrige = hode;
                Node<T> denne = hode.hentNeste();
                while (denne != null && element.compareTo(denne.hentInnhald()) > 0) {
                    forrige = denne;
                    denne = denne.hentNeste();
                }

                Node<T> node = new Node<T>(element);
                forrige.settNeste(node);
                node.settNeste(denne);

            }
        }
        lengde ++;

    }




}
