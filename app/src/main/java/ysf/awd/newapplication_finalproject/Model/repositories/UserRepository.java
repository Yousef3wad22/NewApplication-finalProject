package ysf.awd.newapplication_finalproject.Model.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ysf.awd.newapplication_finalproject.Model.AppDataBase;
import ysf.awd.newapplication_finalproject.Model.MyUserTable.MyUser;
import ysf.awd.newapplication_finalproject.Model.MyUserTable.MyUserQuery;

public class UserRepository {
    private final MyUserQuery userQuery;
    private LiveData<List<MyUserQuery>> allUsers;

    public UserRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        userQuery = db.getMyUserQuery();
        allUsers = userQuery.getAll();
    }

    /**
     * استخراج جميع المستعملين
     * @return جدول يحمل جميع المستعملين
     */
    public LiveData<List<MyUserQuery>> getAllUsers(){
        return allUsers;
    }

    /**
     *  استخراج مستعمل حسب رقم المميز لهid
     * @param keyid
     * @return تعيد المستعملين حسب الid
     */
    public List<MyUser> loadAllByIds(int[] keyid){
        return userQuery.loadAllByIds(keyid);
    }

    /**
     * هل المستعمل موجود حسب الايميل وكلمة السر
     * @param myEmail
     * @param myPassw
     * @return تعيد المستعمل حسب الايميل وكلمة المرور
     */

    public List<MyUser> checkEmailPassw(String myEmail, String myPassw){
        return userQuery.checkEmailPassw(myEmail,myPassw);
    }

    /**
     * فحص هل الايميل موجود من قبل
     * @param myEmail
     * @return الايميل اذا كان موجود
     */
    public List<MyUser> checkEmail(String myEmail){
        return userQuery.checkEmail(myEmail);
    }

    /**
     * اضافة مستعمل او مجموعة مستعملين
     * @param users
     */
    public void  insertAll(MyUser... users){
        userQuery.insertAll(users);
    }

    /**
     * حذف
     * @param users
     */
    public void delete(MyUser users){
        userQuery.delete(users);
    }

    /**
     * //حذف حسب الرقم المميز id
     * @param id
     */
    public void delete(int id){
        userQuery.delete(id);
    }

    /**
     * اضافة مستعمل واحد
     * @param users
     */
    public void insert(MyUser users){
        userQuery.insert(users);
    }

    /**
     * تعديل مستعمل او قائمة مستعملين
     * @param users
     */
    public void update(MyUser users){
        userQuery.update(users);
    }





}
