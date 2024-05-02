package logo;

import java.util.ArrayList;

/**
 * Classe che mi permette di applicare un'istruzione ad una deteterminata area di lavoro
 *
 */
public class Instruction {

    private final DefaultArea drawing;
    private final ActionEnum action;
    private final ArrayList<String> params;

    /**
     * Costruttore di istruzioni che si occupa direttamente di prendere un'istruzione e lanciarla
     *
     * @param drawing Area di disegno attuale
     * @param action Istruzione che vogliamo eseguire
     * @param params Parametri per l'istruzione, indicano: Spostamento, Colore e/o Rotazione
     */
    public Instruction(DefaultArea drawing, ActionEnum action, ArrayList<String> params) {
        this.drawing = drawing;
        this.params = params;
        this.action = action;

        switch (action){

            case FORWARD:
                forward(Integer.parseInt(params.get(0)),
                    SegmentType.STRAIGHT,
                    0);
                break;

            case BACKWARD:
                backward(Integer.parseInt(params.get(0)),
                    SegmentType.STRAIGHT,
                    0);
                break;

            case LEFT:
                left(Integer.parseInt(params.get(0)));
                break;

            case RIGHT:
                right(Integer.parseInt(params.get(0)));
                break;

            case CLEARSCREEN:
                clearScreen();
                break;

            case PENUP:
                setPenUp();
                break;

            case PENDOWN:
                setPenDown();
                break;

            case HOME:
                home();
                break;

            case SETPENCOLOR:
                setPenColor(Integer.parseInt(params.get(0)),
                    Integer.parseInt(params.get(1)),
                    Integer.parseInt(params.get(2)));
                break;

            case SETFILLCOLOR:
                setFillColor(Integer.parseInt(params.get(0)),
                    Integer.parseInt(params.get(1)),
                    Integer.parseInt(params.get(2)));
                break;

            case SETSCREENCOLOR:
                setScreenColor(Integer.parseInt(params.get(0)),
                    Integer.parseInt(params.get(1)),
                    Integer.parseInt(params.get(2)));
                break;

            case SETPENSIZE:
                setPenSize(Integer.parseInt(params.get(0)));
                break;

            case REPEAT:
                for( int i = 0; i < Integer.parseInt(params.get(0)) ; i++){
                    new Instruction(this.drawing, ActionEnum.valueOf(params.get(1)), new ArrayList<>(params.subList(1,params.size())));
                    //params.subList(1,params.size()
                }
            break;

        }
    }

    private void forward(int dist, SegmentType type, int radius){
        DefaultPoint delta = getDeltaPoint(this.drawing.getAssociatedCursor().getActualDir(), this.drawing.getAssociatedCursor().getPosition(), dist);

         if (this.drawing.isAValidPosition(delta) && this.drawing.getAssociatedCursor().isPenDown())
             this.drawing.draw(this.drawing.getAssociatedCursor().getPosition(),delta,type,radius);

         if (!this.drawing.getAssociatedCursor().isPenDown()) {
             this.drawing.setTurtlePosition(delta);
             this.drawing.getAssociatedCursor().setPlot(false);
         }
         this.drawing.setLastAction(ActionEnum.FORWARD);
    }

    private void backward(int dist, SegmentType type, int radius){
        DefaultPoint delta = getDeltaPoint(Direction.oppositeDirection(this.drawing.getAssociatedCursor().getActualDir()),this.drawing.getAssociatedCursor().getPosition(),dist);

        if (this.drawing.isAValidPosition(delta) && this.drawing.getAssociatedCursor().isPenDown())
            this.drawing.draw(this.drawing.getAssociatedCursor().getPosition(),delta, type, radius);

        if (!this.drawing.getAssociatedCursor().isPenDown()) {
            this.drawing.setTurtlePosition(delta);
            this.drawing.getAssociatedCursor().setPlot(false);
        }
        this.drawing.setLastAction(ActionEnum.BACKWARD);
    }

    private void left(int angle){
        this.drawing.getAssociatedCursor().getDirection().setDirection((this.drawing.getAssociatedCursor().getActualDir().getDirectionInDegree()+angle) % 360);
        this.drawing.setLastAction(ActionEnum.LEFT);
    }

    private void right(int angle){
        if ((this.drawing.getAssociatedCursor().getActualDir().getDirectionInDegree() - angle) < 0) {
            while(this.drawing.getAssociatedCursor().getActualDir().getDirectionInDegree() - angle < 0){
                drawing.getAssociatedCursor().getActualDir().setDirection(this.drawing.getAssociatedCursor().getActualDir().getDirectionInDegree()+1);
            }
        }else{
           left(drawing.getAssociatedCursor().getActualDir().getDirectionInDegree()-angle);
        }
        this.drawing.setLastAction(ActionEnum.RIGHT);
    }

    private void clearScreen(){
        this.drawing.clearScreen();
        this.drawing.setLastAction(ActionEnum.CLEARSCREEN);
    }

    private void setPenUp(){
        this.drawing.getAssociatedCursor().setPenUp();
        this.drawing.setLastAction(ActionEnum.PENUP);
    }

    private void setPenDown(){
        this.drawing.getAssociatedCursor().setPenDown();
        this.drawing.setLastAction(ActionEnum.PENDOWN);
    }

    private void home(){
        this.drawing.setTurtlePosition(DefaultCursor.getHOME());
        this.drawing.setLastAction(ActionEnum.HOME);
    }

    private void setPenColor(int r, int g, int b){
        this.drawing.getAssociatedCursor().setColorLine(r,g,b);
        this.drawing.setLastAction(ActionEnum.SETPENCOLOR);
    }

    private void setFillColor(int r, int g, int b){
        this.drawing.getAssociatedCursor().setColorArea(r,g,b);
        this.drawing.setLastAction(ActionEnum.SETFILLCOLOR);
    }

    private void setScreenColor(int r, int g, int b){
        this.drawing.setBackGroundColor(r,g,b);
        this.drawing.setLastAction(ActionEnum.SETSCREENCOLOR);
    }

    private void setPenSize(int size){
        this.drawing.getAssociatedCursor().setPenSize(size);
        this.drawing.setLastAction(ActionEnum.SETPENSIZE);
    }

    /**
     * Metodo che permette di sapere dove la Penna/Tartaruga sarà posizionata dopo un'istruzione
     * basato sulla distanza dello Spostamento, Posizione attuale e Direzione
     *
     * @param actualDir Attuale direzione della Penna/Tartaruga
     * @param actualPos Attuale posizione della Penna/Tartaruga
     * @param dist Distanza tra la posizione attuale e la posizione desiderata
     * @return Il punto in cui la tartaruga sarà posizionata
     */
    private DefaultPoint getDeltaPoint(Direction actualDir, DefaultPoint actualPos, int dist) {
        double tempX = actualPos.getX() + (dist * (int)Math.cos(actualDir.getDirectionInDegree()));
        double tempY = actualPos.getY() + (dist * (int)Math.sin(actualDir.getDirectionInDegree()));
        return new DefaultPoint(tempX,tempY);
    }
}
