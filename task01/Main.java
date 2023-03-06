import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
       ArrayList<Person> people = ImportExport.readTXTFile("C:\\Users\\Veronika\\Desktop\\OOP\\hw1\\src\\Data.txt");
       Person irina = people.get(0);
       Person vasya = people.get(1);
        Person masha = people.get(2);
        Person jane = people.get(3);
        Person ivan = people.get(4);
        Person maksim = people.get(5);
       Person alla = people.get(6);
       Person vera = people.get(7);
       Person oleg = people.get(8);
       Person anna = people.get(9);
       // показать информацию о человеке тест
       Show.printPersonInfo(maksim);

       //добавляем светлану в список людей (Смирнова Светлана Максимовна) тест
        HashMap name = new HashMap<String, String>();
        name.put("Фамилия", "Смирнова");
        name.put("Имя", "Светлана");
        name.put("Отчество", "Максимовна");
        Person svetlana = new Person(name,
               "female", LocalDate.of(2012, 2, 23),
               true, 10);
       people.add(svetlana);

       Show.printPersonInfo(svetlana);

       //создаем дерево
       GeoTree gt = new GeoTree();
       // добавляем связи согласно схеме README
       gt.addParentAndChild(irina, jane);
       gt.addParentAndChild(masha, ivan);
       gt.addParentAndChild(vasya, jane);
       gt.addParentAndChild(vasya, ivan);
       gt.addParentAndChild(maksim, vera);
       gt.addParentAndChild(alla, vera);
       gt.addParentAndChild(oleg, irina);
       gt.addParentAndChild(oleg, maksim);
       gt.addParentAndChild(anna, irina);
       gt.addParentAndChild(anna, maksim);
       gt.addParentAndChild(maksim, svetlana);
       gt.addParentAndChild(alla, svetlana);
       gt.addPartner(masha, vasya);
       gt.addPartner(oleg, anna);
       gt.addPartner(alla, maksim);

       // пытаемся добавить самого себя в партнеры тест
       gt.addPartner(maksim, maksim);


System.out.println(new Research(gt).spend(irina,
                Relationship.parent));

// импортируем обновленные данные о людях в новый файл тест
ImportExport.saveToTXTFile("newData.txt", people);

       new Show(gt).showSiblings(maksim);
       new Show(gt).showPartners(maksim);
       new Show(gt).showPartners(masha);
       new Show(gt).showSiblings(vasya);
       new Show(gt).showPartners(vasya);
       new Show(gt).showChildren(vasya);
       new Show(gt).showSiblings(ivan);
       new Show(gt).showParents(maksim);
       new Show(gt).showParents(irina);
       new Show(gt).showIfHasRelated(irina, jane, Relationship.parent);
       new Show(gt).showIfHasRelated(irina, maksim, Relationship.partner);
       new Show(gt).showIfHasRelated(anna, masha, Relationship.partner);
       new Show(gt).showAllRelations(maksim);

// тестовая печать листа с набором персон
/*       for (Person p:
            people) {
          ImportExport.printPersonInfo(p);

       }**/
    }
}
