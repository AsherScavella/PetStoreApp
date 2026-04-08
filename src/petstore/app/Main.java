package petstore.app;

import petstore.inventory.Fish;
import petstore.inventory.Pet;
import petstore.inventory.WaterType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Pet p1 = new Pet("Frank", "1-1-2026");
            System.out.println(p1);
            p1.setDescription("Test Description");
            System.out.println(p1.getDescription());
            p1.displayPet();

            System.out.println(p1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Fish f1 = new Fish("Fred", "4-1-2026", true, WaterType.SALT);
            System.out.println(f1);
            f1.setDescription("Test Description");
            System.out.println(f1.getDescription());
            f1.displayPet();
        } catch (Exception e) {

            {
                System.out.println(e.getMessage());
            }

        }
    }
}




