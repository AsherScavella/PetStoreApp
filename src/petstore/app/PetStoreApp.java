package petstore.app;

import petstore.inventory.Bird;
import petstore.inventory.Fish;
import petstore.inventory.NestType;
import petstore.inventory.Pet;
import petstore.inventory.WaterType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author PUT_YOUR_NAMES_HERE
 *  @since PUT_THE_CURRENT_DATE_HERE
 *  @version 1.0 beta
 *  @see <a href="{PUT_YOUR_URL_HERE}">GitHub Repository</a>
 *
 */
public class PetStoreApp {

    private static final String INVENTORY_FILE = "PetStoreData.txt";

    private static final String DOUBLE_DASH_LINE =
            String.format("%50s", "").replace(' ', '=');

    private static final String SINGLE_DASH_LINE =
            DOUBLE_DASH_LINE.replace('=', '-');

    private final List<Pet> inventory;

    public PetStoreApp() {
        this.inventory = new ArrayList<>();
    }

    private void displayAppHeading() {
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println("Welcome to the Pet Store App");
        System.out.println(DOUBLE_DASH_LINE);
    }

    private void deletePet() {
        System.out.println("Delete Pet");
        System.out.println(SINGLE_DASH_LINE);

        int id = Input.getInt("Please enter the pet id: ");

        for (int i = 0; i < inventory.size(); i++) {
            Pet pet = inventory.get(i);

            if (pet.getId() == id) {
                inventory.remove(i);
                System.out.println("Successful Delete: " + pet);
                Input.getLine("Press enter to continue...");
                return;
            }
        }

        System.out.println("ERROR: Pet ID: " + id + " NOT found!");
        Input.getLine("Press enter to continue...");
    }

    private Bird addBird(String name, String dateDOB, String description) throws Exception {
        Bird bird;
        int userInput;
        boolean fly;
        NestType nest = null;

        userInput = Input.getIntRange("Can fly? 1=Yes, 2=No: ", 1, 2);
        fly = (userInput == 1);

        try {
            userInput = Input.getIntRange("Nest Type 1=BURROW, 2=CUP, 3=DOME: ", 1, 3);
            nest = NestType.values()[userInput - 1];
        } catch (Exception e) {
            throw new Exception("Invalid data! Bird Nest Type = " + nest);
        }

        bird = new Bird(name, dateDOB, fly, nest);
        bird.setDescription(description);

        return bird;
    }

    private Fish addFish(String name, String dateDOB, String description) throws Exception {
        Fish fish;
        int userInput;
        boolean migratory;
        WaterType water = null;

        userInput = Input.getIntRange("Migratory? 1=Yes, 2=No: ", 1, 2);
        migratory = (userInput == 1);

        try {
            userInput = Input.getIntRange("Water Type 1=BOTH, 2=FRESH, 3=SALT: ", 1, 3);
            water = WaterType.values()[userInput - 1];
        } catch (Exception e) {
            throw new Exception("Invalid data! Fish Water Type = " + water);
        }

        fish = new Fish(name, dateDOB, migratory, water);
        fish.setDescription(description);

        return fish;
    }

    private Pet addBasicPet(String name, String dateDOB, String description) throws Exception {
        Pet pet = new Pet(name, dateDOB);
        pet.setDescription(description);
        return pet;
    }

    private void addPet() throws Exception {
        System.out.println("Add Pet");
        System.out.println(SINGLE_DASH_LINE);

        System.out.println("Please enter the following pet information:");
        String name = Input.getString("Name: ");
        String dateDOB = Input.getDate("Date of Birth (MM-DD-YYYY): ");
        String description = Input.getLine("Description or press enter to continue: ");

        int petType = Input.getIntRange("Type 1=Pet, 2=Bird, 3=Fish: ", 1, 3);

        switch (petType) {
            case 1:
                Pet p = addBasicPet(name, dateDOB, description);
                inventory.add(p);
                System.out.println("Successful Add: " + p);
                Input.getLine("Press enter to continue...");
                break;
            case 2:
                Bird b = addBird(name, dateDOB, description);
                inventory.add(b);
                System.out.println("Successful Add: " + b);
                Input.getLine("Press enter to continue...");
                break;
            case 3:
                Fish f = addFish(name, dateDOB, description);
                inventory.add(f);
                System.out.println("Successful Add: " + f);
                Input.getLine("Press enter to continue...");
                break;
            default:
                throw new Exception("Invalid Input! Pet Type = " + petType);
        }
    }

    private void displayInventory() {
        System.out.println("Pet Inventory");
        System.out.println(SINGLE_DASH_LINE);
        System.out.println("ID  Name            DOB        Details");
        System.out.println("--- --------------- ---------- -------------------");

        for (Pet pet : inventory) {
            pet.displayPet();
        }
        System.out.println();

        Input.getLine("Press enter to continue...");
    }

    public void saveInventory() {
        System.out.println("Saving data! Please wait...");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PetStoreApp.INVENTORY_FILE))) {

            for (Pet pet : inventory) {

                if (pet instanceof Bird) {
                    Bird bird = (Bird) pet;
                    bw.write("BIRD|");
                    bw.write(bird.getId() + "|" + bird.getName() + "|" + bird.getDateDOB() + "|"
                            + safeDescription(bird.getDescription()) + "|"
                            + bird.isFly() + "|" + bird.getNest() + "\n");
                } else if (pet instanceof Fish) {
                    Fish fish = (Fish) pet;
                    bw.write("FISH|");
                    bw.write(fish.getId() + "|" + fish.getName() + "|" + fish.getDateDOB() + "|"
                            + safeDescription(fish.getDescription()) + "|"
                            + fish.isMigratory() + "|" + fish.getWater() + "\n");
                } else {
                    bw.write("PET|");
                    bw.write(pet.getId() + "|" + pet.getName() + "|" + pet.getDateDOB() + "|"
                            + safeDescription(pet.getDescription()) + "\n");
                }
            }

            bw.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(inventory.size() + " pet records successfully written to " + PetStoreApp.INVENTORY_FILE);
        Input.getLine("Press enter to continue...");
    }

    public void loadInventory() {
        System.out.println("Loading data! Please wait...");

        inventory.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(PetStoreApp.INVENTORY_FILE))) {

            String inLine;

            while ((inLine = br.readLine()) != null) {

                String[] data = inLine.split("[|]");

                switch (data[0]) {
                    case "PET":
                        Pet p = new Pet(Integer.parseInt(data[1]), data[2], data[3]);
                        p.setDescription(data.length > 4 ? data[4] : "");
                        inventory.add(p);
                        break;

                    case "BIRD":
                        Bird b = new Bird(
                                Integer.parseInt(data[1]),
                                data[2],
                                data[3],
                                Boolean.parseBoolean(data[5]),
                                NestType.valueOf(data[6])
                        );
                        b.setDescription(data[4]);
                        inventory.add(b);
                        break;

                    case "FISH":
                        Fish f = new Fish(
                                Integer.parseInt(data[1]),
                                data[2],
                                data[3],
                                Boolean.parseBoolean(data[5]),
                                WaterType.valueOf(data[6])
                        );
                        f.setDescription(data[4]);
                        inventory.add(f);
                        break;

                    default:
                        throw new Exception("Invalid pet type: " + data[0]);
                }
            }

            if (!inventory.isEmpty()) {
                Pet.setLastId(inventory.get(inventory.size() - 1).getId());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(inventory.size() + " pet records successfully loaded from " + PetStoreApp.INVENTORY_FILE);
        Input.getLine("Press enter to continue...");
    }

    private String safeDescription(String description) {
        return description == null ? "" : description;
    }

    private void mainMenu() throws Exception {
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println(SINGLE_DASH_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_DASH_LINE);

            System.out.println("0 = End Program");
            System.out.println("1 = Add Pet");
            System.out.println("2 = Delete Pet");
            System.out.println("3 = Display Inventory");
            System.out.println("4 = Save Inventory");
            System.out.println("5 = Load Inventory");

            System.out.println(SINGLE_DASH_LINE);
            int userInput = Input.getIntRange("Menu Choice: ", 0, 5);
            System.out.println(SINGLE_DASH_LINE);

            switch (userInput) {
                case 0:
                    keepRunning = false;
                    break;
                case 1:
                    try {
                        this.addPet();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 2:
                    try {
                        this.deletePet();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        Input.getLine("Press enter to continue...");
                    }
                    break;
                case 3:
                    displayInventory();
                    break;
                case 4:
                    saveInventory();
                    break;
                case 5:
                    loadInventory();
                    break;
                default:
                    throw new Exception("Invalid menu choice: " + userInput);
            }
        }
    }

    public static void main(String[] args) {
        PetStoreApp app = new PetStoreApp();

        app.displayAppHeading();

        try {
            app.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error.");
        }

        Input.sc.close();
    }
}