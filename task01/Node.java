class Node {
    private Person p1;//персона
    private Relationship re; //родственное отношение
    private Person p2;//родственник

    public Node(Person person, Relationship re, Person relative) {
        if (person == null || relative == null) return;
        this.p1 = person;
        this.re = re;
        this.p2 = relative;
    }

    //геттеры
    public Person getP1() {return p1;}
    public Person getP2() {return p2;}
    public Relationship getRe() {return re;}

    @Override
    public String toString() {
        return String.format("<%s (id = %s) is a %s for %s (id = %s)>\n",
                Show.fullNameToString(p1), p1.getId(), re, Show.fullNameToString(p2), p2.getId());
    }

    public void setP2(Person person) {
        this.p2=person;
    }


}