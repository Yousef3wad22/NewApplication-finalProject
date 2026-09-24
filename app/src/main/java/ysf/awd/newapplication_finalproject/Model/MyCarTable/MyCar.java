package ysf.awd.newapplication_finalproject.Model.MyCarTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyCar {
    @PrimaryKey(autoGenerate = true)
    public long key_id;

    public int price;

    public int maxSpeed;

    public int year;

    @ColumnInfo(name = "full_Name")
    public String Name;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public long getKey_id() {
        return key_id;
    }

    public void setKey_id(long key_id) {
        this.key_id = key_id;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "key_id=" + key_id +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                ", year=" + year +
                ", Name='" + Name + '\'' +
                '}';
    }
}
