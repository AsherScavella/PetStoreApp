package petstore.inventory;

/**
 * The Fish class represents a type of Pet that includes
 * additional attributes specific to fish such as whether
 * the fish is migratory and the type of water it lives in.
 *
 * This class extends the Pet class and demonstrates
 * inheritance by adding fish-specific properties.
 *
 * Features:
 * - Tracks if the fish is migratory
 * - Stores water type (FRESH, SALT, BOTH)
 * - Overrides display method to show extra fish details
 *
 * @author Asher Scavella
 * @since 2026-04-13
 * @version 1.0
 */
public class Fish extends Pet {

    /** Indicates if the fish is migratory */
    private boolean migratory;

    /** The type of water the fish lives in */
    private WaterType water;

    /**
     * Constructs a Fish object with name, date of birth,
     * migratory status, and water type.
     *
     * @param name the name of the fish
     * @param dateDOB the date of birth of the fish
     * @param migratory true if the fish is migratory, false otherwise
     * @param water the type of water the fish lives in
     * @throws Exception if invalid data is provided to the Pet constructor
     */
    public Fish(String name, String dateDOB, boolean migratory, WaterType water) throws Exception {
        super(name, dateDOB);
        setMigratory(migratory);
        setWater(water);
    }

    /**
     * Constructs a Fish object with an ID, name, date of birth,
     * migratory status, and water type.
     *
     * @param id the unique ID of the fish
     * @param name the name of the fish
     * @param dateDOB the date of birth of the fish
     * @param migratory true if the fish is migratory, false otherwise
     * @param water the type of water the fish lives in
     * @throws Exception if invalid data is provided to the Pet constructor
     */
    public Fish(int id, String name, String dateDOB, boolean migratory, WaterType water) throws Exception {
        super(id, name, dateDOB);
        setMigratory(migratory);
        setWater(water);
    }

    /**
     * Returns whether the fish is migratory.
     *
     * @return true if the fish is migratory, false otherwise
     */
    public boolean isMigratory() {
        return migratory;
    }

    /**
     * Sets whether the fish is migratory.
     *
     * @param migratory true if the fish is migratory, false otherwise
     */
    public void setMigratory(boolean migratory) {
        this.migratory = migratory;
    }

    /**
     * Returns the water type of the fish.
     *
     * @return the water type
     */
    public WaterType getWater() {
        return water;
    }

    /**
     * Sets the water type of the fish.
     *
     * @param water the water type to assign
     */
    public void setWater(WaterType water) {
        this.water = water;
    }

    /**
     * Displays fish information including inherited pet details
     * and additional fish-specific attributes (migratory and water type).
     */
    @Override
    public void displayPet() {
        super.displayPet();
        System.out.printf(" %-5s %-5s\n", migratory, water);
    }
}
