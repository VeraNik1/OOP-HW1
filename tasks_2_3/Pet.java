package tasks_2_3;

import java.util.ArrayList;

import static tasks_2_3.Human.Mood.*;
import static tasks_2_3.Human.Status.dead;

public abstract class Pet implements Comparable<Pet>{
    enum Stage {
        sleepy,//спит
        playful, //играет
        angry, //злится
        hungry,//голодная
        offended, //обижен
        moody, //не в настроении
        silent //для неговорящих животных

    }
    private static Stage stage;
    public static Pet.Stage getStage() {
        return stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    private String name;
    private Sex sex;
    private int age;
    private int health; //здоровье 1-100
    private int mood; //настроение 1-100
    private int hunger; //голод 1-100

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getHunger() {
        return hunger;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
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

    public Pet(String name, Sex sex, int age, Human owner) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.health = 70; //начальное здоровье
        this.mood = 70; //начальное настроение
        this.hunger = 25; //начальный голод
        this.stage = Pet.Stage.sleepy; //начальное состояние
        this.owner = owner;

    }
    /** Действия домашнего животного

     /**
     * убить человека
     * меняет параметры котика и состояние хозяина
     */
    public void killHuman() {
        this.mood = 100;
        this.health = 100;
        this.hunger = 0;
        System.out.printf("%s Вас убил! Game Over!\n", name);
        System.out.println("ЗЫ. А потому что нельзя пинать животных");
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
     * пет пришел погладиться
     * меняет параметры пета и хозяина
     */
    public void cameForSnuggling() {
        this.mood += 10;
        this.health += 10;
        this.hunger += 10;
        autoCorrection();
        owner.sethMood(happy);
    }

    /**
     * пет играет с хозяином
     */
    public void playing() {
        this.mood += 10;
        this.health -= 10;
        this.hunger += 20;
        autoCorrection();
        owner.sethMood(happy);
    }

    /**
     * пет ест
     * меняет параметры котика
     */

    public void eat(Integer meal) {
        this.health += meal;
        this.mood+=20;
        this.hunger -= meal;
        autoCorrection();
        if(this.hunger == 0) {
            System.out.printf("%s переел, его стошнило\n", name);
            this.hunger += 15;
        }
    }
    public void eat(){
        eat(20);
    }

    /**
     * пета пинают(
     * меняет параметры котика
     */

    public void beaten() {
        this.health -= 8;
        this.mood-=45;
        autoCorrection();
    }

    /**
     * пет говорит, голосовой ответ зависит от состояния
     */
    public void speak() {
    }

    /**
     * поведение пета в зависимости от настроения и голода
     *
     */
    public void behaviorOfPet() {
        if (this.health==0){
            System.out.printf("%s умер(\n", name);
            System.out.println("  _|_  \n   |   \n___|___\n   |   \n   |/   \n  /|   \n   |   \n   |   \n");
            owner.sethMood(depressed);
            owner.showHumanMood();
            System.out.println("Мы в ответе за тех, кого приручили");
            System.exit(0);}
        if (mood<=0 || hunger<=0){
            stage = Pet.Stage.angry;}
        else if (this.hunger>=80){
            stage = Pet.Stage.hungry;}
        else if (this.mood<= 30 && this.hunger >= 60
                && this.health > 0 && this.health <= 30){
            stage = Pet.Stage.offended;}
        else if (this.mood > 30 && this.mood<= 60 && this.hunger >= 40
                && this.hunger< 60 && this.health > 30 && this.health <= 60){
            stage = Pet.Stage.moody;}
        else if (this.mood > 60 && this.mood<= 85 && this.hunger >= 20
                && this.hunger< 60 && this.health > 60 && this.health <= 85){
            stage = Pet.Stage.playful;}
        else if (this.mood > 95 && this.hunger< 5 && this.health > 95){
            stage = Pet.Stage.sleepy;}
        else {stage = Pet.Stage.playful;}
        autoCorrection();
    }

    /**
     * показать, как пет себя чувствует и что делает
     */
    public void viewParamPet() {
        System.out.printf("%s --> здоровье[%d] настроение[%d] " +
                        "голод[%s] состояние[%s]\n", name,
                health, mood, hunger, stage);
    }

    public int correctInt(int num){
        if (num > 100) return 100;
        if (num < 0) return 0;
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

    /**
     * компаратор по умолчанию
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Pet o) {
        return this.age - o.getAge();
    }
    @Override
    public String toString() {
        return String.format("{%s (%s) %s}",this.name,this.sex,this.age);
    }
}

