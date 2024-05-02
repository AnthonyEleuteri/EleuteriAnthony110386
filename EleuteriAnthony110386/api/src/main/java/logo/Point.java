package logo;

/**
 * Interfaccia che indica l'oggetto base da cui ogni disegno ha origine, il punto
 */
public interface Point {

   /**
    * Metodo che permette di localizzare la riga di un singolo punto in un'area di disegno
    *
    * @return l'intero associato alla riga del punto nell'area di disegno
    */
   double getX();
   /**
    * Metodo che permette di localizzare la colonna di un singolo punto in un'area di disegno
    *
    * @return l'intero associato alla colonna del punto nell'area di disegno
    */
   double getY();
}
