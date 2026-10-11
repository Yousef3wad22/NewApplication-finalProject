package ysf.awd.newapplication_finalproject.Model.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ysf.awd.newapplication_finalproject.Model.AppDataBase;
import ysf.awd.newapplication_finalproject.Model.MyTaskTable.MyTask;
import ysf.awd.newapplication_finalproject.Model.MyUserTable.MyUserQuery;

public class UserRepository {
    private final MyUserQuery userQuery;
    private final LiveData<List<MyTask>> allUsers;

    public taskRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        userQuery = db.getMyUserQuery();
        allUsers = userQuery.getAll();

}
