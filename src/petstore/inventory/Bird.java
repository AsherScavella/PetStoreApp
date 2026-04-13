package petstore.inventory;

/**
 * The Bird class represents a type of Pet that includes
 * additional attributes specific to birds such as whether
 * the bird can fly and the type of nest it builds.
 *
 * This class extends the Pet class and demonstrates
 * inheritance by adding bird-specific properties.
 *
 * Features:
 * - Tracks if the bird can fly
 * - Stores nest type (BURROW, CUP, DOME)
 * - Overrides display method to show extra bird details
 *
 * @author Asher Scavella
 * @since 2026-04-13
 * @version 1.0
 */
public class Bird extends Pet {

    /** Indicates if the bird can fly */
    private boolean fly;

    /** The type of nest the bird builds */
    private NestType nest;

    /**
     * Constructs a Bird object with name, date of birth,
     * flying ability, and nest type.
     *
     * @param name the name of the bird
     * @param dateDOB the date of birth of the bird
     * @param fly true if the bird can fly, false otherwise
     * @param nest the type of nest the bird builds
     * @throws Exception if invalid data is provided to the Pet constructor
     */
    public Bird(String name, String dateDOB, boolean fly, NestType nest) throws Exception {
        super(name, dateDOB);
        setFly(fly);
        setNest(nest);
    }

    /**
     * Constructs a Bird object with an ID, name, date of birth,
     * flying ability, and nest type.
     *
     * @param id the unique ID of the bird
     * @param name the name of the bird
     * @param dateDOB the date of birth of the bird
     * @param fly true if the bird can fly, false otherwise
     * @param nest the type of nest the bird builds
     * @throws Exception if invalid data is provided to the Pet constructor
     */
    public Bird(int id, String name, String dateDOB, boolean fly, NestType nest) throws Exception {
        super(id, name, dateDOB);
        setFly(fly);
        setNest(nest);
    }

    /**
     * Returns whether the bird can fly.
     *
     * @return true if the bird can fly, false otherwise
     */
    public boolean isFly() {
        return fly;
    }

    /**
     * Sets whether the bird can fly.
     *
     * @param fly true if the bird can fly, false otherwise
     */
    public void setFly(boolean fly) {
        this.fly = fly;
    }

    /**
     * Returns the nest type of the bird.
     *
     * @return the nest type
     */
    public NestType getNest() {
        return nest;
    }

    /**
     * Sets the nest type of the bird.
     *
     * @param nest the nest type to assign
     */
    public void setNest(NestType nest) {
        this.nest = nest;
    }

    /**
     * Displays bird information including inherited pet details
     * and additional bird-specific attributes (fly and nest type).
     */
    @Override
    public void displayPet() {
        super.displayPet();
        System.out.printf(" %-5s %-5s\n", fly, nest);
    }
}
