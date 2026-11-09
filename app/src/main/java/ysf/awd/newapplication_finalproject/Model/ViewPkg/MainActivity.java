package ysf.awd.newapplication_finalproject.Model.ViewPkg;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ysf.awd.newapplication_finalproject.Model.AppDataBase;
import ysf.awd.newapplication_finalproject.Model.Model.MySubjectTable.MySubject;
import ysf.awd.newapplication_finalproject.Model.Model.MySubjectTable.MySubjectQuery;
import ysf.awd.newapplication_finalproject.R;

public class MainActivity extends AppCompatActivity {
    private Button btnAddTaskScreen;
    private Button btnRegisterScreen;
    private Button btnSignInScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //بناء قاعدة بيانات وارجاع مؤشر عليها1
        AppDataBase db = AppDataBase.getDB(getApplicationContext());
        //2 مؤشر لكائن عمليات  لجدول
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        //3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1 = new MySubject();
        s1.setTitle("Math");
        MySubject s2 = new MySubject();
        s2.title = "Computers";
        //4 اضافة كائن للجدول
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        btnAddTaskScreen = findViewById(R.id.btnAddTaskScreen);
        btnRegisterScreen = findViewById(R.id.btnRegisterScreen);
        btnSignInScreen = findViewById(R.id.btnSignInScreen);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_history) {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_signout) {
            Intent intent = new Intent(MainActivity.this, SignOutActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
        startActivity(i);
    }

    public void onClickR(View view) {
        Intent i = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void onClickS(View view) {
        Intent i = new Intent(MainActivity.this, signInAcitvity.class);
        startActivity(i);
    }

    /**
     * بناء ديالوج
     */
    public void showYesNoDialog()
    {
        //تجهيز بنّاء شباك حوار "ديالوغ" يتلقى بارمتر مؤشر للنشاط (اكتيفيتي) الحالي
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log out");//تحديد العنوان
        builder.setMessage("Are you sure?");//تحدي فحوى شباك الحوار


        //النص على الزر ومعالج الحدث
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(MainActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //النص على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث الموافقة
                Toast.makeText(MainActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//بناء شباك الحوار -ديالوغ
        dialog.show();//عرض الشباك


    }
}
