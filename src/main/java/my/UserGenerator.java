package my;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserGenerator {

    private List<String[]> fileReader(String file) {
        ArrayList<String[]> arrayList = new ArrayList<>();
       try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line ;
            while( (line = reader.readLine()) != null){
                String[] userData = line.split(",");
                arrayList.add(userData);
            }
            return arrayList;
        } catch (IOException e){
           System.out.println("ошибка" + e.getMessage());
       }
       return null;
    }

   private void generation(List<String[]> arrayList, String userFileDirectory){

        for (int i = 1; i < arrayList.size(); i++) {
            String[] arrayIndexNumber = arrayList.get(i);
            String login = arrayIndexNumber[0];
            String pass = arrayIndexNumber[1];
            String firstname = arrayIndexNumber[2];
            String lastname = arrayIndexNumber[3];
            String data = pass + "\n" +
                    firstname + ";" + lastname + "\n" +
                    "\n" +
                    "\n" +
                    ";";

            try {
                File directory = new File(userFileDirectory);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File file = new File(userFileDirectory + File.separator + login);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(data);
                bw.close();

                System.out.println("Успешно создан юзер" + login);
            } catch (IOException e) {
                System.out.println("Что то пошло не так " + e.getMessage());
            }
       }
    }

    public void start(String readingFile, String directory){
        generation(fileReader(readingFile), directory);
    }
}


