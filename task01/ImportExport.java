import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

 public class ImportExport {
     public static ArrayList<Person> readTXTFile(String path) throws FileNotFoundException {
         ArrayList<Person> records = new ArrayList<>();

         String sex;
         LocalDate birthDate;
         boolean isAlive;
         int id = 0;
         Scanner scanner = new Scanner(new File(path));
             scanner.nextLine();
             while (scanner.hasNextLine()) {
                 id ++;
                 HashMap<String, String> fullName = new HashMap<>();
                 Scanner scanner1 = new Scanner(scanner.nextLine());
                 scanner1.useDelimiter(",");
                 // get person's name
                 fullName.put("Фамилия", scanner1.next());
                 fullName.put("Имя", scanner1.next());
                 fullName.put("Отчество", scanner1.next());
                 //get person's sex
                 sex = scanner1.next();
                 //get persons birthdate
                 String[] dateB = scanner1.next().split("-");
                 birthDate = LocalDate.of(Integer.parseInt(dateB[0]), Integer.parseInt(dateB[1]), Integer.parseInt(dateB[2]));
                 //get isAlive status
                 isAlive = (scanner1.next().trim().equals("true"));
                 records.add(new Person(fullName, sex, birthDate, isAlive));
                 scanner1.close();
             }
             scanner.close();
             return records;
         }

        public static void saveToTXTFile(String fileName, ArrayList<Person> arr) throws IOException {
            Writer out = new BufferedWriter(new OutputStreamWriter(
                    Files.newOutputStream(Paths.get(fileName)), StandardCharsets.UTF_8));
         try {
             out.write("lastName,firstName,fatherName,sex,birthDate,isAlive\n");
             for (Person p :
                     arr) {
                 String temp;
                 temp = p.getFullName().get("Фамилия") + "," +
                         p.getFullName().get("Имя") + "," +
                         p.getFullName().get("Отчество") + "," +
                         p.getSex() + "," +
                         p.getDateBirth() + "," +
                         p.getAlive() + "\n";
                 out.write(temp);

             }
             out.close();
             System.out.println("Данные сохранены в файл " + fileName);
         }
         catch (IOException e) {
         System.out.println("Ошибка при сохранении данных в файл " + fileName + ": " + e.getMessage());
        }

        }

     }







