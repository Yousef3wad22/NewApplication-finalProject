package ysf.awd.newapplication_finalproject.Model.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ysf.awd.newapplication_finalproject.Model.AppDataBase;
import ysf.awd.newapplication_finalproject.Model.MyCarTable.MyCar;
import ysf.awd.newapplication_finalproject.Model.MyCarTable.MyCarQuery;

public class CarRepository {
    private final MyCarQuery carQuery;

    private final LiveData<List<MyCar>> allCars;

    public CarRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        carQuery = db.getMyCarQuery();
        allCars = carQuery.getAllCars();
    }
    public void insertCar(MyCar car){
        carQuery.insertCar(car);
    }
    public void updateCar(MyCar car){
        carQuery.updateCar(car);
    }
    public void deleteCar(MyCar car){
        carQuery.deleteCar(car);
    }
    public LiveData<List<MyCar>> getAllCars(){
        return allCars;
    }
   public MyCar getCarById(long id){
        return carQuery.getCarById(id);
    }


}
