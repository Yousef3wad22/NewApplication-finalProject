package ysf.awd.newapplication_finalproject.Model.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ysf.awd.newapplication_finalproject.Model.Model.MyCarTable.MyCar;
import ysf.awd.newapplication_finalproject.Model.repositories.CarRepository;

public class CarViewModel {
    private CarRepository repository;

    private LiveData<List<MyCar>> allCars;

    public CarViewModel(Application application) {
        repository = new CarRepository(application);
        allCars = repository.getAllCars();
    }
    public LiveData<List<MyCar>> getAllCars() {
        return allCars;
    }
    void insertCar(MyCar car){
        repository.insertCar(car);
    }
    void updateCar(MyCar car){
        repository.updateCar(car);
    }
    void deleteCar(MyCar car){
        repository.deleteCar(car);
    }
    public MyCar getCarById(long id){
        return repository.getCarById(id);
    }
}
