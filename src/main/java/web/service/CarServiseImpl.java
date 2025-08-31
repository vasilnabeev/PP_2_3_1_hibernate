package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiseImpl implements CarService {

    @Override
    public List<Car> getCars(int count) {
        List<Car> carList = CarList.carList;

        if (count <= 0) {
            return new ArrayList<>();
        }
        if (count > carList.size()) {
            return new ArrayList<>(carList);
        }

        return new ArrayList<>(carList.subList(0, count));
    }
}
