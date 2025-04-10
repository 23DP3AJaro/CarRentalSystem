package lv.rvt;

public class Cars {
    private int Car_ID;
    private String brand;
    private String model;
    private String color;
    private int mileage;
    private String license_plate;
    private int year_of_manufacture;
    private double rental_price;
    private boolean isAvailable;

    public Cars (String brand, String model, int year_of_manufacture, String color, String license_plate, int mileage, double rental_price) throws Exception{
        
        this.Car_ID = Manager.getLastIdFromCsv("cars.csv") + 1;	
        this.brand = brand;
        this.model = model;
        this.license_plate = license_plate;
        this.color = color;
        this.mileage = mileage;
        this.rental_price = rental_price;
        this.year_of_manufacture = year_of_manufacture;
        this.isAvailable = true;
    }

    public int getId() {
        return Car_ID;
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

    public double getRentalPrice(){
        return rental_price;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public int getYearOfManufacture(){
        return year_of_manufacture;
    }

}
