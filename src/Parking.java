import java.util.Objects;

public class Parking {
    private int id;
    private String name;
    private String adrress;
    private Car[] regular;
    private Car[] handiPark;
    private int numOfHandi;
    private int numOfregular;

    public Parking(int id, String name, String adrress, int numOfRegularSpots, int numOfHandiSpots) {
        setId(id);
        setName(name);
        setAdrress(adrress);
        this.regular = new Car[numOfRegularSpots];
        this.handiPark = new Car[numOfHandiSpots];
        this.numOfregular = 0;
        this.numOfHandi = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public int getNumOfHandi() {
        return numOfHandi;
    }

    public int getNumOfregular() {
        return numOfregular;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "name='" + name + '\'' +
                ", num of Handicapped spots:=" + handiPark.length +
                "parked cars: " + numOfHandi +
                ", num of regular sports=" + regular.length +
                "parked cars: " + numOfregular +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return id == parking.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Car exit(String plateNumber, boolean isHandicapped){
        int index;
        if(isHandicapped){
           Car res= handiPark[findByPlateNumber(plateNumber,isHandicapped)];
            handiPark[findByPlateNumber(plateNumber,isHandicapped)]=null;
            numOfHandi--;
            return res;
        }
        Car res= regular[findByPlateNumber(plateNumber,isHandicapped)];
        regular[findByPlateNumber(plateNumber,isHandicapped)]=null;
        numOfregular--;
        return res;


    }

    public boolean park(Car c, boolean isHandicapped) {
        if (isHandicapped) {
            if (!c.isHandi()) {
                return false;
            } else {
                if (isFull(true)) {
                    return false;
                } else {
                    addtoArr(c, handiPark);
                    numOfHandi++;
                    return true;
                }
            }
        } else {
            if (isFull(false)) {
                return false;
            } else {
                addtoArr(c, regular);
                numOfregular++;
                return true;
            }
        }
    }


    private void addtoArr(Car c, Car[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = c;
                break;
            }
        }
    }

    public boolean isFull(boolean isHandiCapped) {
        return isHandiCapped ? getNumOfHandi() == handiPark.length : getNumOfregular() == regular.length;
    }

    public boolean isFull() {
        return isFull(true) && isFull(false);
    }

    public int getNextCarParkingSpot(boolean isHandicapped) {
        return isHandicapped ? getEmptySpot(handiPark) : getEmptySpot(regular);
    }

    private int getEmptySpot(Car[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int getNumOfCars(boolean isHandicapped) {
        return isHandicapped ? getNumOfHandi() : getNumOfregular();
    }

    public int getNumOCars() {
        return getNumOfCars(true) + getNumOfCars(false);

    }

    public int size() {
        return size(true) + size(false);
    }

    public int size(boolean isHandicapped) {
        return isHandicapped ? handiPark.length : regular.length;
    }

    public int findByPlateNumber(String plateNumber, boolean isHandicapped) {
        if (isHandicapped) {
            return findInArr(handiPark, plateNumber);
        } else {
            return findInArr(regular, plateNumber);
        }
    }

    private int findInArr(Car[] arr, String plateNumber) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                continue;
            if (arr[i].getPlateNUm().equals(plateNumber)) {
                return i;
            }
        }
        return -1;
    }
}
