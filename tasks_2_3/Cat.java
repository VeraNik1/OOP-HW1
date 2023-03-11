package tasks_2_3;

public class Cat extends Pet {


    /**
     * @param name  - кличка
     * @param sex   - пол
     * @param age   - возраст
     * @param owner
     */
    public Cat(String name, Sex sex, int age, Human owner) {
        super(name, sex, age, owner);
    }

    /**
     * котик говорит, голосовой ответ зависит от состояния
     */
    @Override
    public void speak() {
        switch (Pet.getStage()) {
            case playful:
                System.out.printf("%s зовет играть: Мяу - мяу - мяу!!!!\n", this.getName());
                break;
            case angry:
                System.out.printf("%s агрессивно шипит: МааааррррАгрррррПшшшш!!!!\n", this.getName());
                break;
            case sleepy:
                System.out.printf("%s сонно мурлычет: мрррр...мрр...мррррррр...мррр\n", this.getName());
                break;
            case hungry:
                System.out.printf("%s громко просит еды: МААААААУУУ!!!ЖрАААтЬЬ111\n", this.getName());
                break;
            case moody:
                System.out.printf("%s недовольно нудит: мау-мауyy-мау-мамау-маyyy\n", this.getName());
                break;
            case offended:
                System.out.printf("%s Молчит и презрительно смотрит\n", this.getName());
                break;
        }
    }
}

