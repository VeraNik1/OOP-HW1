import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
       ArrayList<Person> people = ImportExport.readTXTFile("C:\\Users\\Veronika\\Desktop\\OOP\\hw1\\task01\\Data.txt");
       Person irina = people.get(0);
       Show.printPersonInfo(irina);
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
       Show.printPersonInfo(jane);
       //добавляем светлану в список людей (Смирнова Светлана Максимовна) тест
        HashMap name = new HashMap<String, String>();
        name.put("Фамилия", "Смирнова");
        name.put("Имя", "Светлана");
        name.put("Отчество", "Максимовна");
        Person svetlana = new Person(name,
               "female", LocalDate.of(2012, 2, 23),
               true);
               svetlana.setId(anna.getId() + 1);
       people.add(svetlana);

       Show.printPersonInfo(svetlana);
       Show.printPersonInfo(jane);

       //создаем дерево
       GeoTree gt = new GeoTree();
       // добавляем связи согласно схеме README
       gt.addRelation(irina, jane, Relationship.parent);
       gt.addRelation(masha, ivan, Relationship.parent);
       gt.addRelation(jane, vasya,Relationship.child);
       gt.addRelation(vasya, ivan, Relationship.parent);
       gt.addRelation(maksim, vera, Relationship.parent);
       gt.addRelation(alla, vera, Relationship.parent);
       gt.addRelation(oleg, irina, Relationship.parent);
       gt.addRelation(oleg, maksim, Relationship.parent);
       gt.addRelation(anna, irina, Relationship.parent);
       gt.addRelation(anna, maksim, Relationship.parent);
       gt.addRelation(maksim, svetlana, Relationship.parent);
       gt.addRelation(alla, svetlana, Relationship.parent);
       gt.addRelation(masha, vasya, Relationship.partner);
       gt.addRelation(oleg, anna, Relationship.partner);
       gt.addRelation(alla, maksim, Relationship.partner);
       gt.save("SmirnovyGeo.ser", gt);

       // пытаемся добавить самого себя в партнеры тест
       gt.addRelation(maksim, maksim,Relationship.partner);


    Show.arrayToString(new Research(gt).spend(irina,
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
       new Show(gt).showGrandparents(vera);
       new Show(gt).showGrandparents(alla);

       // показать дерево в произвольном порядке
       System.out.println();
       System.out.println("дерево в произвольном порядке >>>> ");
       new Show(gt).showGeoTree(gt);
       System.out.println();

        // показать дерево (отсортированное по id 1-й и 2-й персон)
        System.out.println();
        System.out.println("дерево отсортировано по id >>>> ");
        new Show(gt).showGeoTreeSorted(gt);
        System.out.println();

        //загрузка из файла (не реализована)
        GeoTree  treeAnotherOne = new GeoTree();
        treeAnotherOne.load("QueenFamily.txt");

        //удаление умерших из поиска
        ArrayList<Person> list_maks = new ArrayList<>();
        list_maks = new Research(gt).getParents(maksim); //родители maksim
        new Show(gt).listToString(list_maks); // печать списка родителей
        System.out.println();
        new Research(gt).getAlive(list_maks); //исключение умерших людей из списка
        new Show(gt).listToString(list_maks); // печать списка родителей, за исключением умерших


// тестовая печать листа с набором персон
/*       for (Person p:
            people) {
          ImportExport.printPersonInfo(p);

       }**/
    }
}
