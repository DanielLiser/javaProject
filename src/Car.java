import java.util.Objects;

public class Car {
    private String manufacture;
    private String model;
    private String color;
    private int year;
    private String plateNUm;
    private boolean isHandi;
    public Car(String manufacture,String model, String color,int year,String plateNUm,boolean isHandi){
        setManufacture(manufacture);
        setModel(model);
        setColor(color);
        setYear(year);
        setPlateNUm(plateNUm);
        setHandi(isHandi);
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNUm() {
        return plateNUm;
    }

    public void setPlateNUm(String plateNUm) {
        this.plateNUm = plateNUm;
    }

    public boolean isHandi() {
        return isHandi;
    }

    public void setHandi(boolean handi) {
        isHandi = handi;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(plateNUm, car.plateNUm);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plateNUm);
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", plateNUm='" + plateNUm + '\'' +
                ", isHandi=" + isHandi +
                '}';
    }
}
