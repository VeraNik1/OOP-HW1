import java.util.ArrayList;
import java.util.HashSet;

/**
 * 1. при добавлении связей необходима проверка, чтобы
 * не было например у одной персоны не было одновременно
 * нескольких типов связей, которые противоречат друг другу
 * например, одна и таже person1 может быть случайно задана,
 * как parent, child, partner для person2, либо можно дедушку/бабушку/сестру/брата/самого себя
 * случайно можно поставить партнером и ошибки при добавлении не возникнет
 * 2. необходима возможность удаления/редактирования ошибочной информации в дереве
 * **/
class GeoTree implements SaveAndLoadGeoTree{
    private final HashSet<Node> tree = new HashSet<>();

    public HashSet<Node> getTree() {
        return tree;
    }

    /**
     * Проверка персон на null
     *
     * @param person1 - исходные персоны
     * @param person2 - исходные персоны
     * @return - true(если есть null)
     */
    private boolean wrongPerson(Person person1, Person person2) {
        return (person1 == null || person2 == null
                || person1.equals(person2));
    }
    /**
     * Добавление отношений
     *
     * @param p1   - родитель
     * @param p2 - потомок
     * @param rel - p1 rel p2
     *
     */
    public void addRelation(Person p1, Person p2, Relationship rel){
        if (wrongPerson(p1, p2)){//нельзя добавлять null и самого себя
            System.out.println("Добавление не было выполнено, нельзя добавлять null или самого себя");
            return;
        }
        tree.add(new Node(p1, rel, p2));
        tree.add(new Node(p2, rel.getMirrorRel(), p1));
    }



}