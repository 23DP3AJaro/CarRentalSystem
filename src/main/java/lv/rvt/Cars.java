package lv.rvt;

public class Cars {
    
    private String brand;
    private String model;
    private String color;
    private int mileage;
    private String license_plate;

    public Cars (String brand, String model, String color, String license_plate, int mileage){
        this.brand = brand;
        this.model = model;
        this.license_plate = license_plate;
        this.color = color;
        this.mileage = mileage;

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return license_plate;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }


}
