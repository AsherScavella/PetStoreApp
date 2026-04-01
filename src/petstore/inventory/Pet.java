package petstore.inventory;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pet {
    private static int lastId = 0;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");

    protected final int id;
    protected String name;
    protected LocalDate dateDOB;
    protected String description;

    public Pet(String name, String dateDOB) throws Exception {
        setName(name);
        setDateDOB(dateDOB);
        this.id = ++Pet.lastId;
    }

    public Pet(int id, String name, String dateDOB) throws Exception {
        this.id = id;
        setName(name);
        setDateDOB(dateDOB);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isBlank()) {
            throw new Exception("Invalid! Name can not be empty.");
        }

        this.name = name.trim();
    }

    public String getDateDOB() {
        return dateDOB.format(Pet.formatter);
    }

    public void setDateDOB(String dateReceived) throws Exception {
        try {
            this.dateDOB = LocalDate.parse(dateReceived, Pet.formatter);
        } catch (Exception e) {
            throw new Exception("Invalid date! Date of Birth Must be MM-DD-YYYY");
        }
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description.trim();
    }

    public void displayPet(){
        System.out.printf("%3d %-15s %10s", id, name, getDateDOB());
    }

    @Override
    public String toString(){
        return id + " " + name + " " + getDateDOB();
    }

} // close of the Pet Class

