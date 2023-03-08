package tasks_2_3;


import static tasks_2_3.Human.Mood.*;
import static tasks_2_3.Human.Status.dead;


public class Cat extends Item {

    enum Stage {
        sleepy,//спит
        playful, //играет
        angry, //злится
        hungry,//голодная
        offended, //обижен
        moody //не в настроении

    }
    private Stage stage;
    public Stage getStage() {
        return stage;
    }
    public void setStage(Stage angry) {
        this.stage = stage;
    }



    private Sex sex;
    private int age;
    private int health; //здоровье 1-100
    private int mood; //настроение 1-100
    private int hunger; //голод 1-100

    public int getHunger() {
        return hunger;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int mood) {
        this.health = health;
    }
    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    private Human owner;

    /**
     * @param name - кличка
     * @param sex  - пол
     * @param age  - возраст
     */
    public Cat(String name, Sex sex, int age, Human owner) {
        super(name);
        this.sex = sex;
        this.age = age;
        this.health = 70; //начальное здоровье
        this.mood = 70; //начальное настроение
        this.hunger = 25; //начальный голод
        this.stage = Stage.sleepy; //начальное состояние
        this.owner = owner;

    }
    /** Действия кота

    /**
     * убить человека
     * меняет параметры котика и состояние хозяина
     */
    public void killHuman() {
        this.mood = 100;
        this.health = 100;
        this.hunger = 0;
        System.out.printf("%s Вас убил! Game Over!", this.getName());
        System.out.println("ЗЫ. А потому что нельзя пинать кошек и котов");
        owner.setStat(dead);}
    /**
     * укусить человека
     * меняет параметры котика и хозяина
     */
    public void biteHuman() {
            this.mood += 15;
            autoCorrection();
            System.out.println("Получи кусь!");
            owner.sethMood(furious);
            }

    /**
     * кот пришел погладиться
     * меняет параметры котика и хозяина
     */
    public void cameForSnuggling() {
        this.mood += 10;
        this.health += 10;
        this.hunger += 10;
        autoCorrection();
        owner.sethMood(happy);
    }

    /**
     * кот играет с хозяином
     */
    public void playing() {
        this.mood += 10;
        this.health -= 10;
        this.hunger += 20;
        autoCorrection();
        owner.sethMood(happy);
    }

    /**
     * котик ест
     * меняет параметры котика
     */

    public void eat(Integer meal) {
        this.health += meal;
        this.mood+=20;
        this.hunger -= meal;
        autoCorrection();
        if(this.hunger == 0) {
            System.out.println("Кот переел, его стошнило");
            this.hunger += 15;
        }
    }
    public void eat(){
        eat(20);
    }

    /**
     * котика пинают(
     * меняет параметры котика
     */

    public void beaten() {
        this.health -= 8;
        this.mood-=45;
        autoCorrection();
    }

    /**
     * котик говорит, голосовой ответ зависит от состояния
     */
    public void speak() {
        switch (stage) {
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

    /**
     * поведение кота в зависимости от настроения и голода
     *
     */
    public void behaviorOfCat() {

            if (this.health==0){
                System.out.println("Котик умер(");
                System.out.println("/\\____/\\ \n| +   + | \n(  -X-  ) \n \\_|_|_/");
                owner.sethMood(depressed);
                owner.showHumanMood();
                System.out.println("Мы в ответе за тех, кого приручили");
                System.exit(0);}
            if (this.mood<=0 || this.hunger<=0){
                this.stage = Stage.angry;}
            else if (this.hunger>=80){
                this.stage = Stage.hungry;}
            else if (this.mood<= 30 && this.hunger >= 60
                     && this.health > 0 && this.health <= 30){
                this.stage = Stage.offended;}
            else if (this.mood > 30 && this.mood<= 60 && this.hunger >= 40
                    && this.hunger< 60 && this.health > 30 && this.health <= 60){
                this.stage = Stage.moody;}
            else if (this.mood > 60 && this.mood<= 85 && this.hunger >= 20
                    && this.hunger< 60 && this.health > 60 && this.health <= 85){
                this.stage = Stage.playful;}
            else if (this.mood > 95 && this.hunger< 5 && this.health > 95){
                this.stage = Stage.sleepy;}
            else {this.stage = Stage.playful;}
            autoCorrection();
    }

    /**
     * показать, как котик себя чувствует и что делает
     */
    public void viewParamCat() {
        System.out.printf("%s --> здоровье[%d] настроение[%d] " +
                "голод[%s] состояние[%s]\n", this.getName(),
                this.health, this.mood, this.hunger, this.stage);
    }

    public int correctInt(int num){
        if (num > 100) return 100;
        if (num <0) return 0;
        return num;

    }

    /**
     * корректировка параметров
     */
    public void autoCorrection() {
        this.hunger = correctInt(this.hunger);
        this.mood = correctInt(this.mood);
        this.health = correctInt(this.health);
    }

}