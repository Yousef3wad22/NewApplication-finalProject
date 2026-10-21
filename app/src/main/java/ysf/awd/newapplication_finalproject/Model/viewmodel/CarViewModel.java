package ysf.awd.newapplication_finalproject.Model.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ysf.awd.newapplication_finalproject.Model.AppDataBase;
import ysf.awd.newapplication_finalproject.Model.MyCarTable.MyCar;
import ysf.awd.newapplication_finalproject.Model.MyCarTable.MyCarQuery;
import ysf.awd.newapplication_finalproject.Model.repositories.TaskRepository;

public class CarViewModel {
    private final Repository repository;

    private final LiveData<List<MyCarQuery>> allCars;

    public CarViewModel(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        carQuery = db.getMyCarQuery();
        allCars = carQuery.getAllCars();
    }
    void insertCar(MyCar car){
        carQuery.insertCar(car);
    }
    void updateCar(MyCar car){
        carQuery.updateCar(car);
    }
    void deleteCar(MyCar car){
        carQuery.deleteCar(car);
    }
    public LiveData<List<MyCarQuery>> getAllCars(){
        return allCars;
    }
    MyCar getCarById(long id){
        return r.getCarById(id);
    }

}
