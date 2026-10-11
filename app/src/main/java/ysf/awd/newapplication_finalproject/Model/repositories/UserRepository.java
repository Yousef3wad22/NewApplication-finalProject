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
    public LiveData<List<MyUserQuery>> getAllUsers(){
        return allUsers;
    }
    public List<MyUser> loadAllByIds(int[] keyid){
        return userQuery.loadAllByIds(keyid);
    }

    public List<MyUser> checkEmailPassw(String myEmail, String myPassw){
        return userQuery.checkEmailPassw(myEmail,myPassw);
    }
    public List<MyUser> checkEmail(String myEmail){
        return userQuery.checkEmail(myEmail);
    }
    public void  insertAll(MyUser... users){
        userQuery.insertAll(users);
    }
    public void delete(MyUser... users){
        userQuery.delete(users);
    }





}
