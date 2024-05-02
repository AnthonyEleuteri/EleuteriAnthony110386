package logo;

import java.awt.*;

/**
 * Interfaccia che indica il cursore con il quale ci possiamo muovere/disegnare nell'area di disegno
 *
 */
public interface Cursor {

    /**
     * Metodo che ci permette di impostare la posizione del nostro cursore
     *
     * @param pos posizione dove vogliamo spostare il nostro cursore
     */
    void setPosition(DefaultPoint pos);

    /**
     * Metodo che ci permette di avere la posizione del nostro cursore
     *
     * @return La posizione sul piano della nostra tartaruga/cursore
     */
    DefaultPoint getPosition();

    /**
     * Metodo che ci permette di avere la direzione del nostro cursore
     *
     * @param direction la direzione compresa tra 0 e 360
     */

    void setDirection(Direction direction);

    /**
     * Metodo che ci permette di ritornare la direzione del nostro cursore
     *
     * @return la direzione del nostro cursore
     */

    Direction getDirection();

    /**
     * Metodo che ci permette di impostare il colore di un segmento e/o linea
     *
     * @param r quantità di componente 'Red' che vogliamo inserire nel nostro colore
     * @param g quantità di componente 'Green' che vogliamo inserire nel nostro colore
     * @param b quantità di componente 'Blue' che vogliamo inserire nel nostro colore
     */

    void setColorLine(int r, int g, int b);

    /**
     * Metodo che ci permette di ritornare il colore di un segmento e/o linea
     *
     * @return Il colore di una segmento e/o linea
     */

    Color getColorLine();

    /**
     * Metodo che permette di impostare il colore di un'area chiusa
     *
     * @param r quantità di componente 'Red' che vogliamo inserire nel nostro colore
     * @param g quantità di componente 'Green' che vogliamo inserire nel nostro colore
     * @param b quantità di componente 'Blue' che vogliamo inserire nel nostro colore
     */

    void setColorArea(int r, int g, int b);

    /**
     * Metodo che ritorna il colore dell'area chiusa creata
     *
     * @return il colore dell'area
     */

    Color getColorArea();

    /**
     * Metodo che indica sse durante uno spostamento il cursore genera o meno un tracciato.
     *
     * @return il valore di plot che indica se è stato effettuato un tracciato da uno spostamento
     */
    boolean getPlot();

    /**
     * Metodo che ci permette di impostare la variabile plot su true o false a piacimento
     * @param plot valore booleano che vogliamo appliocare alla variabile
     */
    void setPlot(boolean plot);

    /**
     * Metodo che ci permette di ritornare la Direzione attuale del cursore
     * @return Direzione attuale del Cursore
     */
    Direction getActualDir();

    /**
     * Metodo che ci permette di impostare/cambiare la direzione di un determinato cursore
     * @param dir la direzione desiderata da applicare al cursore
     */
    void setDir(Direction dir);

    /**
     * Metodo che ci permette di ritornare la dimensione del tratto attuale del cursore
     * @return la dimensione del tratto attuale del cursore
     */
    int getPenSize();

    /**
     * Metodo che ci permette di impostare/cambiare la dimensione del tratto del cursore
     * @param size dimensione desiderata da applicare al tratto del cursoore
     */
    void setPenSize(int size);

    /**
     * Metodo che ci permette di ritornare la capacità di un cursore di disegnare oppure no
     * @return TRUE se il cursore può scrivere, FALSE altrimenti
     */
    boolean isPenDown();

    /**
     * Metodo che ci permette di impostare il cursore in posizione per potersi
     * spostare ma non per disegnare
     */
    void setPenUp();

    /**
     * Metodo che ci permette di impostare il cursore in posizione per poter disegnare
     */
    void setPenDown();


}
