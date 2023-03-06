import java.util.ArrayList;
import java.util.HashSet;

public class Research{
    final ArrayList<ArrayList<String>> result = new ArrayList<>();
    static ArrayList<Node> tree;

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }


    public ArrayList<ArrayList<String>> spend(Person p, Relationship re) {
        ArrayList<ArrayList<String>> result = new ArrayList<>(); // создаем новый список результатов перед каждым поиском
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(p.getFullName()) && t.getRe() == re) {
                ArrayList<String> name = Show.fullNameToArrString(t.getP2());
                result.add(name);
            }
        }
        return result;
    }

    /**
     * Получаем родителей person
     *
     * @param person .
     * @return список имен родителей
     */
    public ArrayList<ArrayList<String>> getParents(Person person) {

        return spend(person, Relationship.child);
    }

    /**
     * Получаем всех детей person
     *
     * @param person .
     * @return - список имен детей
     */
    public ArrayList<ArrayList<String>> getChildren(Person person) {

        return spend(person, Relationship.parent);
    }

    /**
     * Получить братьев и сестер
     *
     * @param person .
     * @return - список имен братьев и сестер
     */
    public ArrayList<ArrayList<String>> getSiblings(Person person) {
        ArrayList<Node> parents = new ArrayList<>();
        for (Node parent : tree) {//собираем список родителей
            if (parent.getRe() == Relationship.parent && parent.getP2().equals(person)) {
                parents.add(parent);// в parents получили список родителей
                if (parents.size() > 1) break;
            }
        }
        HashSet <Person> brother_sister = new HashSet<>();
        for (Node parent : parents) {// находим всех братьев и сестер
            for (Node t : tree) {
                if (parent.getP1().equals(t.getP1()) &&
                        t.getRe() == Relationship.parent && //если отношение -> родитель
                        !t.getP2().equals(person)) {//кроме самого person
                    brother_sister.add(t.getP2());
                }
            }
        }
        for (Person p : brother_sister) {
            result.add(Show.fullNameToArrString(p));
        }
        return result;

    }

    /**
     * Получить партнеров по браку
     *
     * @param person .
     * @return - возвращает партнеров по браку (муж/жена)
     */
    public ArrayList<ArrayList<String>> getPartners(Person person) {

        return spend(person, Relationship.partner);
    }
    public static ArrayList<String> getAllRelations(Person p) {
        ArrayList<String> res = new ArrayList<>();
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(p.getFullName())) {
                res.add(t.getRe() + " for: " + Show.fullNameToString(t.getP2()));
            }
        }
        return res;

    }

    /**
     * Проверить есть ли родственная связь типа children, parent or partner между двумя персонами
     * @return - возвращает true при наличии связи, иначе false
     */
    public static boolean hasRelated(Person p1, Person p2, Relationship re) {
        for (Node t : tree) {
            if ((t.getP1().getFullName().equals(p1.getFullName()) &&
                    t.getP2().getFullName().equals(p2.getFullName()))
                    || (t.getP1().getFullName().equals(p2.getFullName())
                    && t.getP2().getFullName().equals(p1.getFullName()))) {
                if (t.getRe() == re) {
                    return true;
                }
            }
        }
        return false;
    }
}
