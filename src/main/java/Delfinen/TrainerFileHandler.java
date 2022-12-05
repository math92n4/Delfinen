package Delfinen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainerFileHandler {

    public void saveTrainerData(ArrayList<Trainer> trainers) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Data/TrainerData.csv"));

        for (Trainer trainer : trainers) {
            output.print("");

            output.print(trainer.getId() + ";");
            output.print(trainer.getName() + ";");
            output.print(trainer.getLastName() + ";");

            output.println("");
        }
        output.close();
    }

    public void loadTrainerData(ArrayList<Trainer> trainers) throws FileNotFoundException {
        Scanner scanList = new Scanner(new File("Data/TrainerData.csv"));

        trainers.clear();

        while (scanList.hasNextLine()) {
            String scan = scanList.nextLine();

            Trainer trainer = splitLines(scan);

            trainers.add(trainer);
        }
    }

    private Trainer splitLines(String scan) {
        String[] split = scan.split(";");

        Trainer trainer = new Trainer();

        trainer.setId(Integer.parseInt(split[0]));
        trainer.setName(split[1]);
        trainer.setLastName(split[2]);

        return trainer;
    }




}
