package model.kennel.dao;

import exceptions.GenericSystemException;
import model.kennel.Kennel;

import java.io.*;

public class FileKennelDao extends KennelDao{
    private String filepath = "src/main/resources/csv/kennels.csv";

    public Kennel getKennelById(int kennelId){
        Kennel kennel;
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine())!=null){
                kennel = csvToKennel(line);
                if(kennel.getKennelId() == kennelId){
                    return kennel;
                }

            }
            kennel = null;
        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }

        return kennel;
    }

    public int addKennel(Kennel kennel) throws GenericSystemException {
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]); // Presupponiamo che l'ID sia il primo campo
                if (id > maxId) {
                    maxId = id;
                }
            }
        } catch (FileNotFoundException e) {
            throw new GenericSystemException(e.getMessage());
        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }

        maxId = maxId + 1;
        kennel.setKennelId(maxId);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))){
            writer.write(kennelToCsv(kennel));
            writer.newLine();

        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return maxId;
    }


    //auxiliary function used to convert a model into a csv string
    private String kennelToCsv(Kennel kennel){
        return String.valueOf(kennel.getKennelId()) + "," + kennel.getKennelName();
    }

    //auxiliary function used to convert a csv string into a model
    private Kennel csvToKennel(String csvLine){
        String[] tokens = csvLine.split(",");
        return new Kennel(
                Integer.parseInt(tokens[0]),
                tokens[1]
        );
    }
}
