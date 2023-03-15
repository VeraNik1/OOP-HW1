import java.util.*;
import java.util.stream.Collectors;

/**
 * класс для вывода данных в консоль
 */
public class Show {
    final GeoTree gTree;

    public Show(GeoTree geoTree) {
        this.gTree = geoTree;
    }

    public void showSiblings(Person person) {
        System.out.printf("%s братья/сёстры --> ", fullNameToString(person));
        arrayToString(new Research(this.gTree).getSiblings(person));
    }
    public void showParents(Person person) {
        System.out.printf("%s родители --> ", fullNameToString(person));
        arrayToString(new Research(this.gTree).getParents(person));
    }
    public void showChildren(Person person) {
        System.out.printf("%s дети --> ", fullNameToString(person));
        arrayToString(new Research(this.gTree).getChildren(person));
    }
    public void showPartners(Person person) {
        System.out.printf("%s в браке с --> ", fullNameToString(person));
        arrayToString(new Research(this.gTree).getPartners(person));
    }
    public void showGrandparents(Person person) {
        System.out.printf("%s бабушки, дедушки --> ", fullNameToString(person));
        arrayToString(new Research(this.gTree).getGrandParents(person));
    }
    public void showIfHasRelated(Person p1, Person p2, Relationship re){
        if(Research.hasRelated(p1, p2, re)){
            System.out.printf("%s %s для %s\n", fullNameToString(p1),
                    nameOfRelation(re), fullNameToString(p2));
    }
        else {
            System.out.printf("%s НЕ %s для %s\n", fullNameToString(p1),
                    nameOfRelation(re), fullNameToString(p2));
        }
    }
    public static String fullNameToString(Person person){
        HashMap<String,String> strings = person.getFullName();
        return strings.get("Фамилия") + " " + strings.get("Имя") +
                " " + strings.get("Отчество");
    }
    public static void arrayToString(ArrayList<Person> arrayListPersons){
        if (arrayListPersons.size() > 0){
        ArrayList<String> result = new ArrayList<>(arrayListPersons.size());
        for (Person itemPerson: arrayListPersons) {
            System.out.printf(fullNameToString(itemPerson) + "; ");
        }}
        else  {System.out.printf("не найдено ; ");}
        System.out.println();
    }

    public static String nameOfRelation(Relationship relationship){
        if (relationship == Relationship.parent) return "родитель";
        else if ((relationship == Relationship.child)) return "ребенок";
        else return "партнер";
     }
    public static void printPersonInfo(Person person){
        System.out.print("id: " + person.getId() + " , ");
        System.out.print("Фамилия: " + person.getFullName().get("Фамилия") + " , ");
        System.out.print("Имя: " + person.getFullName().get("Имя") + " , ");
        System.out.print("Отчество: " + person.getFullName().get("Отчество") + " , ");
        System.out.print("Пол: " + person.getSex() + " , ");
        System.out.print("Дата рождения: " + person.getDateBirth() + " , ");
        System.out.print("Возраст: " + person.getAge() + " , ");
        System.out.print("Жив = true/мертв = false: " + person.getAlive() + "\n");
    }
    public void showAllRelations(Person p) {

        System.out.printf("%s is a >>> \n", fullNameToString(p));
        HashMap<Person, Relationship> res = Research.getAllRelations(p);
        List<Person> list = (res.keySet()).stream().collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(list, new PersonAgeComparator());
        for (Person person:
             list) {
            System.out.printf("%s for %s\n", res.get(person), fullNameToString(person));

        }

    }
    public void showGeoTree(GeoTree gt){
        ArrayList<Node> list = new ArrayList<>();
        list.addAll(gt.getTree());
        for (Node node:
             list) {
            System.out.printf(node.toString());

        }
    }
    public void showGeoTreeSorted(GeoTree gt){
        ArrayList<Node> list = new ArrayList<>();
        list.addAll(gt.getTree());
        Collections.sort(list, new NodeSecondPersonIdComparator()); //сортируем лист по id второй персоны
        Collections.sort(list, new NodeFirstPersonIdComparator()); // сортируем лист по id первой персоны
        //чтобы получить следующую структуру id1 rel id3, id1 rel id5, id2 rel id3, id2 rel id6
        for (Node node:
                list) {
            System.out.printf(node.toString());

        }
    }
    public void listToString(ArrayList<Person> list){
        for (Person per:
                list) {
            System.out.println(Show.fullNameToString(per));
        }

    }

}
