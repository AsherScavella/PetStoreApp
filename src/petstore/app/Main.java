package petstore.app;

import petstore.inventory.Pet;

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

        Pet p1 = new Pet("Frank", "1-1-2026");
        System.out.println(p1);

    }
}