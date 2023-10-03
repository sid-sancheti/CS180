package Midterm1;

public class Luggage {
    
    private String brand;
    private String model;
    private String type;
    private String size;
    private double weight;
    private double purchasePrice;
    
    public Luggage(String brand, String model, String type, String size, double weight, double purchasePrice) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.size = size;
        this.weight = weight;
        this.purchasePrice = purchasePrice;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getType() { return type; }
    public String getSize() { return size; }
    public double getWeight() { return weight; }
    public double getPurchasePrice() { return purchasePrice; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setType(String type) { this.type = type; }
    public void setSize(String size) { this.size = size; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }


    public String toString() {
        return String.format("Luggage<brand=" + brand + ", model=" + model + ", type=" + type + ", size=" + size + ", weight=" + "%.2f" + ", purchasePrice=" + "%.2f" + ">", weight, purchasePrice);
    }
}
