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
class GeoTree {
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
     * Отношения родитель <--> потомок
     *
     * @param parent   - родитель
     * @param child - потомок
     */
    public void addParentAndChild(Person parent, Person child) {
        if (wrongPerson(parent, child)) {//нельзя добавлять null и самого себя
            System.out.println("Добавление не было выполнено, нельзя добавлять null или самого себя");
            return;
        }

        tree.add(new Node(parent, Relationship.parent, child)); //  parent родитель для children
        tree.add(new Node(child, Relationship.child, parent)); // children ребенок для parent %(
    }

    /**
     * Отношения супруг <-> супруга (партнер)
     *
     * @param partner1 - первый супруг(а)
     * @param partner2 - второй супруг(а)
     */
    public void addPartner(Person partner1, Person partner2) {
        if (wrongPerson(partner1, partner2)) {
            System.out.println("Добавление не было выполнено, " +
                    "нельзя добавлять null или самого себя");
            return; //нельзя добавлять null и самого себя
        }
        tree.add(new Node(partner1, Relationship.partner, partner2));
        tree.add(new Node(partner2, Relationship.partner, partner1));

    }

}