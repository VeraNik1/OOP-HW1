import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Scanner;

public class Person {
    private HashMap<String, String> fullName;
    private LocalDate birthDate;
    private Boolean isAlive;
    private Integer age;
    private String sex;
    private static Integer id = 0;


    public Person(HashMap<String, String> fullName, String sex, LocalDate birthDate, Boolean isAlive) {

        this.fullName = fullName;
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
        this.isAlive = isAlive;
        this.sex = sex;
        id++;

    }

    public Person(HashMap<String, String> fullName, String sex, LocalDate birthDate) {
        this(fullName, sex, birthDate, (birthDate.isAfter(LocalDate.of(1915,1,1))));
    }
    public Person(HashMap<String, String> fullName, String sex){

        this(fullName, sex, LocalDate.of(1900, 1, 1));
    }
    public Person(HashMap<String, String> fullName){

        this(fullName, "undefined");
    }


    public Integer calculateAge(LocalDate birthDate){
        LocalDate birthday = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());
        //текущее время
        LocalDate now = LocalDate.now();
        //сколько лет на текущее время
        return Period.between(birthday, now).getYears();}

    public HashMap<String, String> getFullName() {
        return fullName;
    }
    public LocalDate getDateBirth() {
        return birthDate;
    }
    public Integer getAge() {
        return age;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public String getSex() {
        return sex;
    }

    public Integer getId() {
        return id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }
    public void setFullName(HashMap<String, String> fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public static @NotNull HashMap<String, String> inputFullName(){
        String [] keys = {"Фамилия", "Имя", "Отчество"};
        HashMap<String, String> fullName = new HashMap<>();
        Scanner in = new Scanner(System.in);
        for (String key:
                keys)
        {System.out.printf("Введите значение поля %s >>> ", key);
            String value = in.nextLine();
            value = capitalizeName(value);
            if(value.length() == 0){
                value = "Undefined";}
            fullName.put(key, value);
        }
        in.close();
        return fullName;}
    public static String capitalizeName(String text){
        return text.substring(0,1).toUpperCase() +
                text.substring(1).toLowerCase();

    }
}
