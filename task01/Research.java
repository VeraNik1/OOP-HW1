import java.util.*;

public class Research{
    final ArrayList<Person> result = new ArrayList<>();
    static HashSet<Node> tree;

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<Person> spend(Person p, Relationship re) {
        ArrayList<Person> result = new ArrayList<>(); // создаем новый список результатов перед каждым поиском
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(p.getFullName()) && t.getRe() == re) {
                Person member = t.getP2();
                result.add(member);
            }
        }
        Collections.sort(result, new PersonAgeComparator());
        return result;
    }

    /**
     * Получаем родителей person
     *
     * @param person .
     * @return список родителей
     */
    public ArrayList<Person> getParents(Person person) {

        return spend(person, Relationship.child);
    }

    /**
     * Получаем всех детей person
     *
     * @param person .
     * @return - список детей
     */
    public ArrayList<Person> getChildren(Person person) {

        return spend(person, Relationship.parent);
    }

    /**
     * Получить братьев и сестер
     *
     * @param person .
     * @return - список братьев и сестер
     */
    public ArrayList<Person> getSiblings(Person person) {
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
            result.add(p);
        }
        Collections.sort(result, new PersonAgeComparator());
        return result;


    }
    /**
     * Получить партнеров по браку
     *
     * @param person .
     * @return - возвращает партнеров по браку (муж/жена)
     */
    public ArrayList<Person> getPartners(Person person) {

        return spend(person, Relationship.partner);
    }
    public static HashMap<Person, Relationship> getAllRelations(Person p) {
        HashMap<Person, Relationship> res = new HashMap<>();
        for (Node t : tree) {
            if (t.getP1().getFullName().equals(p.getFullName())) {
                res.put(t.getP2(), t.getRe());
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

    /**
     * получить бабушек и дедушек
     *
     * @param person
     * @return
     */
    public ArrayList<Person> getGrandParents(Person person) {
        if (person == null) return null;
        ArrayList<Person> result = new ArrayList<>();
        for (Person parent : getParents(person)) {
            result.addAll(getParents(parent));
        }
        Collections.sort(result, new PersonAgeComparator());
        return result;
    }

    /** удаление из списка умерших людей
     *
     * @param list - лист из персон
     * @return - лист из персон со статусом alive = "true"
     */
    public ArrayList<Person> getAlive(ArrayList<Person> list){
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()){
            Person next = iterator.next();
            if (next.getAlive().equals(false)){
                iterator.remove();
            }
        }
        return list;
    }



}
