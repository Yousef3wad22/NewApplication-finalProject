package ysf.awd.newapplication_finalproject.Model.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import ysf.awd.newapplication_finalproject.Model.MyUserTable.MyUser;
import ysf.awd.newapplication_finalproject.Model.MyUserTable.MyUserQuery;
import ysf.awd.newapplication_finalproject.Model.repositories.UserRepository;

public class UserViewModel {
    private final UserRepository repository;
    private final LiveData<List<MyUserQuery>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super();
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
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
        return repository.loadAllByIds(keyid);
    }

    /**
     * هل المستعمل موجود حسب الايميل وكلمة السر
     * @param myEmail
     * @param myPassw
     * @return تعيد المستعمل حسب الايميل وكلمة المرور
     */

    public List<MyUser> checkEmailPassw(String myEmail, String myPassw){
        return repository.checkEmailPassw(myEmail,myPassw);
    }

    /**
     * فحص هل الايميل موجود من قبل
     * @param myEmail
     * @return الايميل اذا كان موجود
     */
    public List<MyUser> checkEmail(String myEmail){
        return repository.checkEmail(myEmail);
    }

    /**
     * اضافة مستعمل او مجموعة مستعملين
     * @param users
     */
    public void  insertAll(MyUser... users){
        repository.insertAll(users);
    }

    /**
     * حذف
     * @param users
     */
    public void delete(MyUser users){
        repository.delete(users);
    }

    /**
     * //حذف حسب الرقم المميز id
     * @param id
     */
    public void delete(int id){
        repository.delete(id);
    }

    /**
     * اضافة مستعمل واحد
     * @param users
     */
    public void insert(MyUser users){
        repository.insert(users);
    }

    /**
     * تعديل مستعمل او قائمة مستعملين
     * @param users
     */
    public void update(MyUser users){
        repository.update(users);
    }

}
