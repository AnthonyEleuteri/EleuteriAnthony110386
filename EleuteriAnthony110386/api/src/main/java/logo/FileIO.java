package logo;

import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Classe che si occupa di leggere e scrivere su file quelli che sono i nostri disegni
 *
 */
public class FileIO {
    private List<String> whatIRead;
    private final Map<ActionEnum, ArrayList<String>> instruction = new HashMap<>();
    private DefaultArea current;
    Scanner instructionScanner;

    /**
     * Costruttore per input/output da File
     *
     * @param path il path da cui vogliamo leggere il file
     */
    public FileIO(String path) {
        whatIRead = new ArrayList<>();
        current = new DefaultArea();
        readFromFile(path);
        executeInstructions();
    }

    /**
     * Costruttore per input/ouput da Terminale
     */
    public FileIO(){
        //List<Integer> params = new ArrayList<>();
        //List<String> nextInstruction = new ArrayList<>();
        String nextInstruction;
        ArrayList<String> rgb;

        //int index = 0;

        changeDrawingAreaSettings();
        instructionScanner = new Scanner(System.in);

        do {

            System.out.println("""
                    Scriva il tipo di azione che vuole eseguire:
                    [FORWARD][BACKWARD][LEFT][RIGHT][CLEARSCREEN][HOME][PENUP][PENDOWN][SETPENCOLOR][SETFILLCOLOR][SETSCREENCOLOR][SETPENSIZE][REPEAT]
                    EXIT per uscire""");



            nextInstruction = new String(instructionScanner.nextLine());
            //nextInstruction.append(instructionScanner.nextLine());
            //nextInstruction.add(index, userScanner);

            switch (nextInstruction.toUpperCase()){

                case "FORWARD":
                    System.out.println("Inserisca la quantità di spostamento che vuole effettuare: ");
                    this.instruction.put(ActionEnum.FORWARD, new ArrayList<>(Arrays.asList(instructionScanner.nextLine())));
                    break;

                case "BACKWARD":
                    System.out.println("Inserisca la quantità di spostamento che vuole effettuare: ");
                    this.instruction.put(ActionEnum.BACKWARD, new ArrayList<>(Arrays.asList(instructionScanner.nextLine())));
                    break;

                case "LEFT":
                    System.out.println("Inserisca di quanto vuole ruotare il cursore: ");
                    this.instruction.put(ActionEnum.LEFT, new ArrayList<>(Arrays.asList(instructionScanner.nextLine())));
                    break;

                case "RIGHT":
                    System.out.println("Inserisca di quanto vuole ruotare il cursore: ");
                    this.instruction.put(ActionEnum.RIGHT, new ArrayList<>(Arrays.asList(instructionScanner.nextLine())));
                    break;

                case "CLEARSCREEN":
                    this.instruction.put(ActionEnum.CLEARSCREEN,null);
                    break;

                case "PENUP":
                    this.instruction.put(ActionEnum.PENUP,null);
                    break;

                case "PENDOWN":
                    this.instruction.put(ActionEnum.PENDOWN,null);
                    break;

                case "HOME":
                    this.instruction.put(ActionEnum.HOME,null);
                    break;

                case "SETPENCOLOR":
                    rgb = new ArrayList<>();

                    System.out.println("Inserisca la quantità di colore ROSSO in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    System.out.println("Inserisca la quantità di colore GREEN in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    System.out.println("Inserisca la quantità di colore BLUE in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    this.instruction.put(ActionEnum.SETPENSIZE, rgb);
                    break;

                case "SETFILLCOLOR":
                    rgb = new ArrayList<>();

                    System.out.println("Inserisca la quantità di colore ROSSO in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    System.out.println("Inserisca la quantità di colore GREEN in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    System.out.println("Inserisca la quantità di colore BLUE in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    this.instruction.put(ActionEnum.SETFILLCOLOR, rgb);

                    break;

                case "SETSCREENCOLOR":
                    rgb = new ArrayList<>();

                    System.out.println("Inserisca la quantità di colore ROSSO in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    System.out.println("Inserisca la quantità di colore GREEN in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    System.out.println("Inserisca la quantità di colore BLUE in byte: ");
                    rgb.add(instructionScanner.nextLine());

                    this.instruction.put(ActionEnum.SETSCREENCOLOR, rgb);

                    break;

                case "SETPENSIZE":
                    System.out.println("Inserisca la dimensione desiderata: ");
                    this.instruction.put(ActionEnum.RIGHT, new ArrayList<>(Arrays.asList(instructionScanner.nextLine())));
                    break;

                case "REPEAT":
                    System.out.println("Indichi il numero di volete che desidera ripetere l'azione:");
                    int nTimes = instructionScanner.nextInt();

                    System.out.println("Indichi il tipo di azione che vuole ripetere: ");
                    String actionEnum = instructionScanner.nextLine().toUpperCase();

                    System.out.println("Inserisca i parametri per l'azione precedente: ");
                    ArrayList<String> par = new ArrayList<>(Arrays.asList(instructionScanner.nextLine()));

                    for (int i = 1; i < nTimes; i++){
                        this.instruction.put(ActionEnum.valueOf(actionEnum), par);
                    }
                    break;

                default:
                    break;
            }

        }while(!nextInstruction.equalsIgnoreCase("EXIT"));

        executeInstructions(this.instruction);
        consoleWriter();
        fileWriter();
        instructionScanner.close();
    }

    private void changeDrawingAreaSettings() {
        List<Integer> params = new ArrayList<>();
        instructionScanner = new Scanner(System.in);

        System.out.println("Desideri cambia Dimensione e/o Colore dell'area di disegno: [Si/No]");

        if (instructionScanner.nextLine().equalsIgnoreCase("SI")){

            System.out.println("Inserire la dimensione della BASE dell'area di disegno desiderata: ");
            params.add(0, instructionScanner.nextInt());

            System.out.println("Inserire la dimensione dell'ALTEZZA dell'area di disegno desiderata: ");
            params.add(1, instructionScanner.nextInt());

            System.out.println("Inserire la quantità di colore rosso dell'area di disegno desiderata: ");
            params.add(2, instructionScanner.nextInt());

            System.out.println("Inserire la quantità di colore verde dell'area di disegno desiderata: ");
            params.add(3, instructionScanner.nextInt());

            System.out.println("Inserire la quantità di colore blue dell'area di disegno desiderata: ");
            params.add(4, instructionScanner.nextInt());

            current = new DefaultArea(
                    params.get(0),
                    params.get(1),
                    params.get(2),
                    params.get(3),
                    params.get(4)
            );
        }else{
            current = new DefaultArea();
        }
    }

    /**
     * Metodo che prende un path e scrive in una lista di stringhe tutte le istruzioni presente
     *
     * @param path il path da cui dobbiamo prendere il nostro file
     */
    public void readFromFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                this.whatIRead.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che scrive su file l'Output del nostro disegno
     */
    public void fileWriter() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("SIZE " + current.getX() + " " + current.getY() + " " + current.getBackGroundColor().toString() + "\n");
            for (polygon polygon : current.getClosedAreas()) {
                writer.write(polygon.toString());
            }
            for (Segment segment : current.getDraw()) {
                writer.write(segment.toString());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ci permette di stampare a video l'Output del nostro disegno
     */
    public void consoleWriter() {

            System.out.println("SIZE " + current.getX() + " " + current.getY() + " " + current.getBackGroundColor().toString() + "\n");
            for (polygon polygon : current.getClosedAreas()) {
                System.out.println(polygon.toString());
            }
            for (Segment segment : current.getDraw()) {
                System.out.println(segment.toString());
            }
        }

    /**
     * Metodo che prende una lista di Stringhe contententi tutte le istruzioni lette da file
     * e ci permette di dividere tipo di istruzione dai suoi parametri
     *
     * @param commands lista di stringhe contenenti tutte e sole le istruzioni lette da file
     */
    public void trimToSingleInstruction(List<String> commands) {
        for (String s : commands) {
            String[] words = s.split("\\W+");
            ArrayList<String> list1 = new ArrayList<>();
            switch (words[0].toUpperCase()) {
                case "FORWARD":
                    list1.add(words[1]);
                    this.instruction.put(ActionEnum.FORWARD, list1);
                    break;
                case "BACKWARD":
                    list1.add(words[1]);
                    this.instruction.put(ActionEnum.BACKWARD, list1);
                    break;
                case "LEFT":
                    list1.add(words[1]);
                    this.instruction.put(ActionEnum.LEFT, list1);
                    break;
                case "RIGHT":
                    list1.add(words[1]);
                    this.instruction.put(ActionEnum.RIGHT, list1);
                    break;
                case "CLEARSCREEN":
                    this.instruction.put(ActionEnum.CLEARSCREEN, null);
                    break;
                case "PENUP":
                    this.instruction.put(ActionEnum.PENUP, null);
                    break;
                case "PENDOWN":
                    this.instruction.put(ActionEnum.PENDOWN, null);
                    break;
                case "HOME":
                    this.instruction.put(ActionEnum.HOME, null);
                    break;
                case "SETPENCOLOR":
                    list1.add(words[1]);
                    list1.add(words[2]);
                    list1.add(words[3]);
                    this.instruction.put(ActionEnum.SETPENCOLOR, list1);
                    break;
                case "SETFILLCOLOR":
                    list1.add(words[1]);
                    list1.add(words[2]);
                    list1.add(words[3]);
                    this.instruction.put(ActionEnum.SETFILLCOLOR, list1);
                    break;
                case "SETSCREENCOLOR":
                    list1.add(words[1]);
                    list1.add(words[2]);
                    list1.add(words[3]);
                    this.instruction.put(ActionEnum.SETSCREENCOLOR, list1);
                    break;
                case "SETPENSIZE":
                    list1.add(words[1]);
                    this.instruction.put(ActionEnum.SETPENSIZE, list1);
                    break;
                case "REPEAT":
                    list1.addAll(Arrays.asList(words).subList(1, words.length));
                    this.instruction.put(ActionEnum.REPEAT, list1);
                    break;
            }
        }
    }


    /**
     * Metodo che ci permette di eseguire singolarmente in un'area di disegno tutte le istruzioni date
     */
    private void executeInstructions() {
        trimToSingleInstruction(whatIRead);
        instruction.forEach((K,V) -> new Instruction(current,K,V));
    }

    /**
     * Metodo che ci permette di eseguire singolarmente in un'area di disegno tutte le istruzioni date
     */
    private void executeInstructions(Map<ActionEnum, ArrayList<String>> instruction) {
        trimToSingleInstruction(whatIRead);
        instruction.forEach((K,V) -> new Instruction(current,K,V));
    }

}
