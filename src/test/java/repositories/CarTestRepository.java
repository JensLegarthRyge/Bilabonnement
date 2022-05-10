package repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Enum.EnergyLabel;
import com.example.bilabonnement.models.Enum.FuelType;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;
import java.util.Arrays;

//Jens Legarth Ryge

public class CarTestRepository implements CRUDInterface<Car> {
    ArrayList<Car> allCars = new ArrayList<>(
            Arrays.asList(
                    new Car(1, "BS23576", "YSK7759123J1723", false, true, FuelType.DIESEL,
                            17.4, EnergyLabel.D, "JETBLACK", 144699,  109, 1.3),
                    new Car(2, "UX89717", "JLKJD1892731JKASD", true, true, FuelType.PETROL,
                            20.8, EnergyLabel.B, "CORALBLUE", 89599,  76, 1.4),
                    new Car(3, "AL86337", "YSK7759123J1723", false, false, FuelType.ELECTRIC,
                            11, EnergyLabel.A, "ANTHRACITEGRAY", 699095,  170, 2.7),
                    new Car(4, "HC10728", "YSK7759123J1723", false, false, FuelType.PETROL,
                            11, EnergyLabel.A, "ASDFRACITEGRAY", 4000,  100, 1.2),
                    new Car(5, "TT92091", "YSK7759123J1723", false, false, FuelType.PETROL,
                            11, EnergyLabel.A, "LSODACITEGRAY", 5000,  110, 1.1)
            )
    );

    @Override
    public boolean create(Car entity) {
        return false;
    }

    @Override
    public ArrayList<Car> getAll() {
        return allCars;
    }

    @Override
    public Car getSingleById(int id) {
        for (Car cr:allCars) {
            if (cr.getId()==id){
                return cr;
            }
        }
        return null;
    }

    @Override
    public boolean update(Car entity) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
