package ysf.awd.newapplication_finalproject.Model.ViewPkg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ysf.awd.newapplication_finalproject.Model.AppDataBase;
import ysf.awd.newapplication_finalproject.Model.Model.MyUserTable.MyUser;
import ysf.awd.newapplication_finalproject.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> saveUser());
    }


     //تقوم بتجميع النصوص التي أدخلها المستعمل في حقول الشاشة مع حذف المسافات الزائدة من البداية والنهاية باستخدام .trim():
    private void saveUser() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
//,تفحص هل يوجد أي حقل فارغ. إذا كان هناك حقل فارغ، تُظهر رسالة تنبيه للمستعمل (Toast) وتوقف تنفيذ العملية (return):
        if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

//نشئ كائناً جديداً من فئة MyUser وتُدخل فيه البيانات التي قرأتها من الشاشة:
        MyUser myUser = new MyUser();
        myUser.setFullName(fullName);
        myUser.setEmail(email);
        myUser.setPhone(phone);
        myUser.setPassw(password);

        //تتصل بقاعدة البيانات وتنفذ استعلام الإدخال لتخزين المستعمل الجديد في الجدول:
        AppDataBase db = AppDataBase.getDB(getApplicationContext());
        db.getMyUserQuery().insert(myUser);

        //تظهر رسالة للمستعمل تؤكد نجاح عملية التسجيل، ثم تُغلق شاشة التسجيل وتعود للشاشة السابقة عبر الدالة finish():
        Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
