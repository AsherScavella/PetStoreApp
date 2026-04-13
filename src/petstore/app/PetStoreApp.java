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
 * PetStoreApp is a console-based program used to manage a pet store inventory.
 * This application allows the user to add, delete, display, save, and load pets.
 * It supports multiple pet types including basic pets, birds, and fish.
 *
 * The program uses object-oriented programming concepts such as inheritance,
 * polymorphism, and encapsulation. It also uses file handling to save and
 * retrieve pet inventory data from a text file.
 *
 * @author Asher Scavella
 * @since 2026-04-13
 * @version 1.0
 * @see <a href="https://github.com/AsherScavella/PetStoreApp">GitHub Repository</a>
 */
public class PetStoreApp {

    private static final String INVENTORY_FILE = "PetStoreData.txt";

    private static final String DOUBLE_DASH_LINE =
            String.format("%50s", "").replace(' ', '=');

    private static final String SINGLE_DASH_LINE =
            DOUBLE_DASH_LINE.replace('=', '-');

    private final List<Pet> inventory;

    /**
     * Constructs a new PetStoreApp object and initializes
     * the inventory list.
     */
    public PetStoreApp() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Displays the heading for the application when the program starts.
     */
    private void displayAppHeading() {
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println("Welcome to the Pet Store App");
        System.out.println(DOUBLE_DASH_LINE);
    }

    /**
     * Deletes a pet from the inventory by asking the user
     * to enter a pet ID. If the pet is found, it is removed.
     * If the pet is not found, an error message is displayed.
     */
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

    /**
     * Creates a Bird object using user-provided information.
     *
     * @param name the name of the bird
     * @param dateDOB the date of birth of the bird
     * @param description the description of the bird
     * @return a new Bird object
     * @throws Exception if an invalid nest type is entered
     */
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

    /**
     * Creates a Fish object using user-provided information.
     *
     * @param name the name of the fish
     * @param dateDOB the date of birth of the fish
     * @param description the description of the fish
     * @return a new Fish object
     * @throws Exception if an invalid water type is entered
     */
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

    /**
     * Creates a basic Pet object using the provided values.
     *
     * @param name the name of the pet
     * @param dateDOB the date of birth of the pet
     * @param description the description of the pet
     * @return a new Pet object
     * @throws Exception if the Pet constructor throws an exception
     */
    private Pet addBasicPet(String name, String dateDOB, String description) throws Exception {
        Pet pet = new Pet(name, dateDOB);
        pet.setDescription(description);
        return pet;
    }

    /**
     * Prompts the user for pet information and adds the pet
     * to the inventory based on the selected pet type.
     *
     * @throws Exception if an invalid pet type is entered
     */
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

    /**
     * Displays all pets currently stored in the inventory.
     */
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

    /**
     * Saves all pets in the inventory to a text file.
     * Each pet is stored in a formatted line based on its type.
     */
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

    /**
     * Loads pet records from the inventory text file and rebuilds
     * the inventory list with Pet, Bird, and Fish objects.
     */
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

    /**
     * Returns a safe description value.
     * If the description is null, an empty string is returned.
     *
     * @param description the original description
     * @return the original description or an empty string if null
     */
    private String safeDescription(String description) {
        return description == null ? "" : description;
    }

    /**
     * Displays the main menu and processes user choices
     * until the user decides to end the program.
     *
     * @throws Exception if an invalid menu choice occurs
     */
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

    /**
     * Starts the PetStoreApp program.
     * This is the main entry point of the application.
     *
     * @param args command-line arguments
     */
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