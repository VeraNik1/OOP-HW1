import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * класс для вывода данных в консоль
 */
class Show {
    final GeoTree gTree;

    public Show(GeoTree geoTree) {
        this.gTree = geoTree;
    }

    public void showSiblings(Person person) {
        System.out.printf("%s братья/сёстры --> ", fullNameToString(person));
        System.out.println(new Research(this.gTree).getSiblings(person));
    }

    public void showParents(Person person) {
        System.out.printf("%s родители --> ", fullNameToString(person));
        System.out.println(new Research(this.gTree).getParents(person));
    }

    public void showChildren(Person person) {
        System.out.printf("%s дети --> ", fullNameToString(person));
        System.out.println(new Research(this.gTree).getChildren(person));
    }

    public void showPartners(Person person) {
        System.out.printf("%s в браке с --> ", fullNameToString(person));
        System.out.println(new Research(this.gTree).getPartners(person));
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
    public static ArrayList<String> fullNameToArrString(Person person){
        HashMap<String, String> fn = person.getFullName();
        String[] strings = new  String[] {fn.get("Фамилия"),
                fn.get("Имя"), fn.get("Отчество")};
        return new ArrayList<>(Arrays.asList(strings));
    }

    public static String fullNameToString(Person person){
        HashMap<String,String> strings = person.getFullName();
        return strings.get("Фамилия") + " " + strings.get("Имя") +
                " " + strings.get("Отчество");
    }

    public static String nameOfRelation(Relationship relationship){
        if (relationship == Relationship.parent) return "родитель";
        else if ((relationship == Relationship.child)) return "ребенок";
        else return "партнер";
     }
    public static void printPersonInfo(Person Person){
        System.out.print("id: " + Person.getId() + " , ");
        System.out.print("Фамилия: " + Person.getFullName().get("Фамилия") + " , ");
        System.out.print("Имя: " + Person.getFullName().get("Имя") + " , ");
        System.out.print("Отчество: " + Person.getFullName().get("Отчество") + " , ");
        System.out.print("Пол: " + Person.getSex() + " , ");
        System.out.print("Дата рождения: " + Person.getDateBirth() + " , ");
        System.out.print("Возраст: " + Person.getAge() + " , ");
        System.out.print("Жив = true/мертв = false: " + Person.getAlive() + "\n");
    }

    public void showAllRelations(Person p) {

        System.out.printf("%s is a >>> \n", fullNameToString(p));
        System.out.println(String.join("\n", Research.getAllRelations(p)));
    }
}
