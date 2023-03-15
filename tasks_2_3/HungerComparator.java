package tasks_2_3;

import java.util.Comparator;

public class HungerComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet o1, Pet o2) {
        return o2.getHunger() - o1.getHunger();
    }

}
