package petstore.app;

import petstore.inventory.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Pet p1 = new Pet("Frank", "1-1-2026");


            p1.displayPet();

            System.out.println(p1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Bird b1 = new Bird( 10,"Fred", "4-1-2026", true, NestType.BURROW);

            b1  .displayPet();
            Bird.setLastId(10);

            Fish f3 = new Fish( "Bob", "4-1-2026", true, WaterType.SALT);

            f3  .displayPet();
        } catch (Exception e) {

            {
                System.out.println(e.getMessage());
            }

        }
    }
}




