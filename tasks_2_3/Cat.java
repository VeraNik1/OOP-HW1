package tasks_2_3;

import java.util.Random;

import static tasks_2_3.Human.Mood.dead;
import static tasks_2_3.Human.Mood.depressed;


public class Cat extends Item {
    private enum Stage {
        sleep,//спит
        fun, //играет
        angry, //злится
        hungry,//голодная
        walks,//идет

    }

    private Sex sex;
    private int age;
    private int health; //здоровье 0-100%
    private int mood;
    private Stage stage;

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
        this.mood = 80; //начальное настроение
        this.stage = Stage.sleep;
        this.owner = owner;

    }

    /**
     * обмен веществ
     * уменьшение сытости и изменение настроения
     */
    public void metabolism() {
        this.mood = Math.min(this.mood, 100);
        if (this.mood >= 50) {
            if (new Random().nextBoolean()) {
                this.stage = Stage.fun;
            } else {
                this.stage = Stage.sleep;
            }
            this.health -= 20;}

        else if (this.health <= 0) {
            this.health = 0;
            System.out.println("Котик почти умер(. Нужно рочно покормить!");
            speak("/\\____/\\ \n| +   + | \n(  -X-  ) \n \\_|_|_/");
            owner.sethMood(depressed);
        }
        else {
            this.stage = Stage.hungry;
            System.out.println("Котик просит кушать");
            speak("МяяяяяяяуууууууУУ111111");
        }

    }

    public void kickTheCat() {
        if(owner.gethMood().equals(Human.Mood.dead)){
            System.out.println("Мертвый кота не обидит)");
            return;}
        this.stage = Stage.angry;
        this.mood -= 20;
        System.out.println("Вы пнули кота!");
        System.out.println("Зверь будет мстить!");
        viewParamCat();

    }

    public void killHuman() {
        owner.sethMood(dead);
        this.mood = 100;
        this.health = 100;
        this.stage = Stage.fun;
        owner.showHumanMood();
        System.out.println("Кот Вас убил! Game Over!");
        System.out.println("ЗЫ. А потому что нельзя пинать кошек и котов");
        viewParamCat();
}
    /**
     * попробовать погладить
     */
    public void tryToPetCat() {
        System.out.println("Вы пытаетесь погладить кота/кошку");
        viewParamCat();
        if (this.mood <= 50 && this.health <= 40) {
            this.mood -= 20;
            if (this.mood <= 0) {
                this.killHuman();}
            else if(this.mood <= 20) {System.out.println("Кот расцарапал вам руку!");
            owner.sethMood(Human.Mood.furious);
            kickTheCat();
            }
        }
        else if (this.health > 40) {
            this.stage = Stage.fun;
            speak("МрррррМрррр");
            this.mood+=40;
            owner.sethMood(Human.Mood.happy);
        } else {
            this.stage = Stage.angry;
            speak("Шшшшш!!!! Ррррр! Жраааать!");
            owner.sethMood(Human.Mood.depressed);
            this.mood *= 0.7;
        }
        viewParamCat();
    }

    public void speak() {
        System.out.println("Мяу!");
    }

    public void speak(String voice) {
        System.out.println(voice);
    }

    public void eat(Integer meal) {
        this.health += meal;
        if (this.health > 100) {
            this.health = 100;
            this.stage = Stage.fun;
            this.mood = 100;
        } else {
            this.health *= 1 + (meal / this.health);
            this.mood+=70*(meal/this.health);
            this.mood = Math.min(this.mood, 100);
        }speak("Мурррр!!!!");
        System.out.println("Кошка поела, спасибо");
        viewParamCat();
    }

    public void eat(){
        eat(20);
    }

    /**
     * Ответ на зов
     */
    public void reply() {
        if (this.stage == Stage.angry) {
            return;//злая кошка не отзывается
        } else if (this.stage == Stage.sleep) {
            this.stage = Stage.walks;
        }
        speak();
        this.metabolism();
        viewParamCat();
    }

    public void viewParamCat() {
        System.out.printf("%s --> здоровье[%d] настроение[%d] " +
                "состояние[%s]\n", this.getName(),
                this.health, this.mood, this.stage);
    }

}