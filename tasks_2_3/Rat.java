package tasks_2_3;


public class Rat extends Pet {

    /**
     * @param name  - кличка
     * @param sex   - пол
     * @param age   - возраст
     * @param owner
     */
    public Rat(String name, Sex sex, int age, Human owner) {
        super(name, sex, age, owner);
    }

    /**
     * котик говорит, голосовой ответ зависит от состояния
     */
    @Override
    public void speak() {
        switch (Pet.getStage()) {
            case playful:
                System.out.printf("%s зовет играть: Пи-Пи-ПИ-пиии!!!!\n", this.getName());
                break;
            case angry:
                System.out.printf("%s агрессивно оскалилась: Пибе Пипипидец!!\n", this.getName());
                break;
            case sleepy:
                System.out.printf("%s храпит: хрррррррр\n", this.getName());
                break;
            case hungry:
                System.out.printf("%s громко просит еды: ПИИИИИИИИИИПИИИИИИИИИИИИ!!!ЖрАААтЬЬ111\n", this.getName());
                break;
            case moody:
                System.out.printf("%s скребет обои: шуршуршур\n", this.getName());
                break;
            case offended:
                System.out.printf("%s Презрительно смотрит на хозяина\n", this.getName());
                break;
        }
    }
}