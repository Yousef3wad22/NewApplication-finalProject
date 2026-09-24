package ysf.awd.newapplication_finalproject.Model;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ysf.awd.newapplication_finalproject.Model.MyCarTable.MyCar;
import ysf.awd.newapplication_finalproject.Model.MySubjectTable.MySubject;
import ysf.awd.newapplication_finalproject.Model.MySubjectTable.MySubjectQuery;
import ysf.awd.newapplication_finalproject.Model.MyTaskTable.MyTask;
import ysf.awd.newapplication_finalproject.Model.MyTaskTable.MyTaskQuery;
import ysf.awd.newapplication_finalproject.Model.MyUserTable.MyUser;
import ysf.awd.newapplication_finalproject.Model.MyUserTable.MyUserQuery;

/**
 * الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
 * وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
@Database(entities = {MyUser.class, MySubject.class, MyTask.class, MyCar.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDataBase db;

    /**
     * يعيد كائن لعمليات جدول المستعملين
     * @return
     */
    public abstract MyUserQuery getMyUserQuery();

    /**
     * يعيد كائن لعمليات جدول الموضوع
     * @return
     */
    public abstract MySubjectQuery getMySubjectQuery();

    /**
     * يعيد كائن لعمليات جدول المهمات
     * @return
     */
    public abstract MyTaskQuery getMyTaskQuery();

    /**
     * بناء قاعدة البيانات واعادة كائن يؤشر عليها
     * @param context
     * @return
     */
    public static AppDataBase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                            AppDataBase.class,
                            "yousefDataBase" // اسم قاعدة البيانات
                    )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }
}