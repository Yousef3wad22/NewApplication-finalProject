package ysf.awd.newapplication_finalproject.Model.ViewPkg;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import ysf.awd.newapplication_finalproject.R;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        // عرض الصفحة الرئيسية كصفحة افتراضية عند بدء التطبيق لأول مرة
        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
        }
        bottomNav.setOnItemSelectedListener(item -> { // معالج الحدث عند اختيار عنصر من عناصر الشريط السفلي
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.nav_dashboard) {
                replaceFragment(new DashboardFragment());
                return true;
            } else if (itemId == R.id.nav_settings) {
                replaceFragment(new SettingsFragment());
                return true;
            }
            return false;
        });
    }
    // FrameLayout دالة مساعدة لتبديل محتوى الـ
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_history) {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }else if ((id == R.id.action_signout)) {
            showYesNoDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    /**
     * بناء ديالوج
     */
    public void showYesNoDialog()
    {
        //تجهيز بنَاء شباك حوار "ديالوج" يتلقى بارمتر مؤشر للنشاط (اكتيفيتي) الحالي
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sign out");// تحديد العنوان
        builder.setMessage("Are you sure?");// تحدي فحوى شباك الحوار
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
                //معالجة حدث للموافقة
                Toast.makeText(MainActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//بناء شباك الحوار -ديالوج
        dialog.show();//عرض الشباك
    }



}
