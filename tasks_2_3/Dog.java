package tasks_2_3;


public class Dog extends Pet {


    /**
     * @param name  - кличка
     * @param sex   - пол
     * @param age   - возраст
     * @param owner
     */
    public Dog(String name, Sex sex, int age, Human owner) {
        super(name, sex, age, owner);
    }

    /**
     * собака говорит, голосовой ответ зависит от состояния
     */
    @Override
    public void speak() {
        switch (Pet.getStage()) {
            case playful:
                System.out.printf("%s зовет играть: Тяу-тяу-тяу!!!!\n", this.getName());
                break;
            case angry:
                System.out.printf("%s агрессивно рычит: ррррррРРРРРррррррр!!!!\n",this.getName());
                break;
            case sleepy:
                System.out.printf("%s сонно сопит: пфпфпфпфпффф...\n", this.getName());
                break;
            case hungry:
                System.out.printf("%s громко просит еды: АВАВАВАВАВААВ!!!ЖрАААтЬЬ111\n",this.getName());
                break;
            case moody:
                System.out.printf("%s скулит: уууууууууу\n", this.getName());
                break;
            case offended:
                System.out.printf("%s отыернулся от хозяина\n", this.getName());
                break;
        }
    }
}