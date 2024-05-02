package logo;

import java.awt.*;

/**
 * Definisce il campo in cui vengono posizionati i segmenti e il cursore capace di disegnare
 *
 */
public interface Area{

    /**
     * metodo che ci permette di impostare la home
     *
     */
    void setHome();
    /**
     * Metodo che ci permette di impostare la base della nostra area di disegno
     *
     * @param x dimensione della base della nostra area di disegno
     */
    void setBase(int x);

    /**
     * Metodo che ci permette di impostare l'altezza della nostra area di disegno
     *
     * @param y dimensione dell'altezza della nostra area di disegno
     */
    void setHeight(int y);

    /**
     * Metodo che ci ritorna la dimensione della base della nostra area di disegno
     *
     * @return dimensione della base della nostra area di disegno
     */
    double getX();

    /**
     * Metodo che ci ritorna la dimensione dell'altezza della nostra area di disegno
     *
     * @return dimensione dell'altezza della nostra area di disegno
     */
    double getY();

    /**
     * Metodo che ci permette di impostare il colore di sfondo della nostra area di disegno
     *
     * @param r quantità di componente 'Red' che vogliamo inserire nel nostro colore
     * @param g quantità di componente 'Green' che vogliamo inserire nel nostro colore
     * @param b quantità di componente 'Blue' che vogliamo inserire nel nostro colore
     */
    void setBackGroundColor(int r, int g, int b);

    /**
     * Metodo che ritorna il colore di sfondo della nostra area di disegno
     *
     * @return colore di sfondo della nostra area di disegno
     */
    Color getBackGroundColor();

    /**
     * Metodo che ci permette di sapere se un punto dato è valido per l'attuale
     * area di lavoro.
     *
     * @param pos Punto che vogliamo validare
     * @return TRUE se il punto si trova all'interno dell'area di lavoro, FALSE altrimenti
     */
    boolean isAValidPosition(DefaultPoint pos);

    /**
     * Metodo che ci permette di pulire l'area di disegno dagli eventuali
     * Segmenti e/o Poligoni creati
     */
    void clearScreen();

    /**
     * Metodo che ci permette di avere il cursore associato alla nostra area di disegno
     * @return il cursore/tartaruga associata
     */
    DefaultCursor getAssociatedCursor();

    /**
     * Metodo che ci permette di sapere l'ultima azione effettuata nella nostra area di disegno
     * @return l'ultima azione/istruzione che è stata effettuata
     */
    ActionEnum getLastAction();

    /**
     * Metodo che ci permette di cambiare lo status dell'ultima azione effettuata nella noastra area di disegno
     *
     * @param lastAction Azione sostituente
     */
    void setLastAction(ActionEnum lastAction);


}
