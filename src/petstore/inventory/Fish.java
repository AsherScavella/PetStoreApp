package petstore.inventory;

public class Fish extends Pet {
    private boolean migratory;
    private WaterType water;

    public Fish(String name, String dateDOB, boolean migratory, WaterType water) throws Exception {
        super(name, dateDOB);
        setMigratory(migratory);
        setWater(water);
    }

    public boolean isMigratory() {
        return migratory;
    }

    public void setMigratory(boolean migratory) {
        this.migratory = migratory;
    }

    public WaterType getWater() {
        return water;
    }

    public void setWater(WaterType water) {
        this.water = water;
    }
}