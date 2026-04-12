package petstore.inventory;

public class Bird extends Pet {
    private boolean fly;
    private NestType nest;

    public Bird(String name, String dateDOB, boolean fly, NestType nest) throws Exception {
        super(name, dateDOB);
        setFly(fly);
        setNest(nest );
    }

    public Bird(int id, String name, String dateDOB, boolean fly, NestType nest) throws Exception {
        super(id, name, dateDOB);
        setFly(fly);
        setNest(nest );
    }


    public boolean isFly() {
        return fly;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }

    public NestType getNest() {
        return nest;
    }

    public void setNest(NestType nest) {
        this.nest = nest;
    }

    @Override
    public void displayPet(){
        super.displayPet();
        System.out.printf(" %-5s %-5s\n", fly, nest);
    }
}
