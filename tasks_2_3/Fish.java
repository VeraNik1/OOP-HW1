package tasks_2_3;

import static tasks_2_3.Human.Mood.depressed;

public class Fish extends Pet implements BehindGlassPets {


    /**
     * @param name  - кличка
     * @param sex   - пол
     * @param age   - возраст
     * @param owner
     */
    public Fish(String name, Sex sex, int age, Human owner) {
        super(name, sex, age, owner);
        this.setStage(Stage.silent);
    }


    /**
     * рыба не говорит
     */
    @Override
    public void speak() {
    behavior();
}
    @Override
    public void beaten(){
        this.setHunger(this.getHunger() + 10);
        this.setHealth(this.getHealth() - 10);
        System.out.println("Невозможно пнуть рыбку!");
    }

    @Override
    public void playing(){
        this.setHunger(this.getHunger() + 10);
        this.setHealth(this.getHealth() - 10);
        System.out.println("Рыбка не понимает что вы от нее хотите!");
    }

    @Override
    public void cameForSnuggling(){
        this.setHunger(this.getHunger() + 10);
        this.setHealth(this.getHealth() - 10);
        System.out.println("Рыбка боится и прячется под камень");
    }
    @Override
    public void behaviorOfPet() {
        super.setStage(Stage.silent);
        if (this.getHealth()==0){
            System.out.printf("%s умер(\n", this.getName());
            System.out.println("  _|_  \n   |   \n___|___\n   |   \n   |/   \n  /|   \n   |   \n   |   \n");
            System.out.println("Мы в ответе за тех, кого приручили");
            System.exit(0);}
         autoCorrection();
    }

}
