package ysf.awd.newapplication_finalproject.Model.MyCarTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyCar {
    @PrimaryKey(autoGenerate = true)
    public long key_Id;

    public int price;



}
