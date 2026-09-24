package ysf.awd.newapplication_finalproject.Model.MyCarTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyCarQuery {

    // إضافة سيارة جديدة
    @Insert
    void insertCar(MyCar car);

    // تحديث بيانات سيارة
    @Update
    void updateCar(MyCar car);

    // حذف سيارة
    @Delete
    void deleteCar(MyCar car);

    // جلب جميع السيارات
    @Query("SELECT * FROM MyCar")
    List<MyCar> getAllCars();

    // جلب سيارة بواسطة المعرف (ID)
    @Query("SELECT * FROM MyCar WHERE key_id = :id")
    MyCar getCarById(long id);
}