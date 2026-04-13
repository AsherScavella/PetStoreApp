package petstore.inventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Pet class represents a general pet in the pet store system.
 * It serves as the base (parent) class for all pet types such as
 * Bird and Fish.
 *
 * This class includes common attributes like ID, name, date of birth,
 * and description. It also handles validation for name and date input.
 *
 * Features:
 * - Automatically assigns unique IDs to pets
 * - Validates name and date of birth
 * - Formats date using MM-DD-YYYY
 * - Provides display and string output methods
 *
 * This class demonstrates key object-oriented principles such as:
 * - Encapsulation (private/protected fields with getters/setters)
 * - Inheritance (extended by Bird and Fish classes)
 *
 * @author Asher Scavella
 * @since 2026-04-13
 * @version 1.0
 */
public class Pet {

    /** Tracks the last assigned pet ID */
    private static int lastId = 0;

    /** Formatter used for date of birth (MM-DD-YYYY) */
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("M-d-yyyy");

    /** Unique identifier for the pet */
    protected final int id;

    /** Name of the pet */
    protected String name;

    /** Date of birth of the pet */
    protected LocalDate dateDOB;

    /** Description of the pet */
    protected String description;

    /**
     * Constructs a Pet object with a name and date of birth.
     * Automatically assigns a unique ID.
     *
     * @param name the name of the pet
     * @param dateDOB the date of birth (MM-DD-YYYY format)
     * @throws Exception if name or date is invalid
     */
    public Pet(String name, String dateDOB) throws Exception {
        setName(name);
        setDateDOB(dateDOB);
        this.id = ++Pet.lastId;
    }

    /**
     * Constructs a Pet object with a given ID, name, and date of birth.
     *
     * @param id the unique ID of the pet
     * @param name the name of the pet
     * @param dateDOB the date of birth (MM-DD-YYYY format)
     * @throws Exception if name or date is invalid
     */
    public Pet(int id, String name, String dateDOB) throws Exception {
        this.id = id;
        setName(name);
        setDateDOB(dateDOB);
    }

    /**
     * Sets the last used ID value (used when loading data from file).
     *
     * @param lastId the last ID value to set
     */
    public static void setLastId(int lastId) {
        Pet.lastId = lastId;
    }

    /**
     * Returns the unique ID of the pet.
     *
     * @return the pet ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the pet.
     *
     * @return the pet name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name the name to assign
     * @throws Exception if the name is null or blank
     */
    public void setName(String name) throws Exception {
        if (name == null || name.isBlank()) {
            throw new Exception("Invalid! Name can not be empty.");
        }
        this.name = name.trim();
    }

    /**
     * Returns the formatted date of birth.
     *
     * @return the date of birth in MM-DD-YYYY format
     */
    public String getDateDOB() {
        return dateDOB.format(Pet.formatter);
    }

    /**
     * Sets the date of birth for the pet.
     *
     * @param dateReceived the date string in MM-DD-YYYY format
     * @throws Exception if the date format is invalid
     */
    public void setDateDOB(String dateReceived) throws Exception {
        try {
            this.dateDOB = LocalDate.parse(dateReceived, Pet.formatter);
        } catch (Exception e) {
            throw new Exception("Invalid date! Date of Birth Must be MM-DD-YYYY");
        }
    }

    /**
     * Returns the description of the pet.
     *
     * @return the pet description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the pet.
     *
     * @param description the description to assign
     */
    public void setDescription(String description) {
        this.description = description.trim();
    }

    /**
     * Displays basic pet information in a formatted table style.
     */
    public void displayPet() {
        System.out.printf("%3d %-15s %10s", id, name, getDateDOB());
    }

    /**
     * Returns a string representation of the pet.
     *
     * @return formatted string with ID, name, and date of birth
     */
    @Override
    public String toString() {
        return id + " " + name + " " + getDateDOB();
    }

} // end of Pet class