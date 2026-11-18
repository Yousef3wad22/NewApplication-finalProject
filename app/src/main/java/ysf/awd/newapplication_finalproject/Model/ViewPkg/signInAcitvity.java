package ysf.awd.newapplication_finalproject.Model.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ysf.awd.newapplication_finalproject.Model.Model.MyUserTable.MyUser;
import ysf.awd.newapplication_finalproject.Model.viewmodel.UserViewModel;
import ysf.awd.newapplication_finalproject.R;

public class signInAcitvity extends AppCompatActivity {
    private TextView signText;
    private EditText editUserName;
    private EditText editPassword;
    private Button button2;
    private Button btnGoToRegister;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signIn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        signText = findViewById(R.id.signText);
        editUserName = findViewById(R.id.editUserName);
        editPassword = findViewById(R.id.editPassword);
        button2 = findViewById(R.id.button2);
        btnGoToRegister = findViewById(R.id.btnGoToRegister);
        button2.setOnClickListener(v -> signInUser());

        btnGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(signInAcitvity.this, RegisterActivity.class);
            startActivity(intent);
        });


    }
    public boolean signInUser() {
        String email = editUserName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        boolean isValid = true;

        // فحص البريد الإلكتروني
        if (TextUtils.isEmpty(email)) {
            editUserName.setError("الرجاء إدخال البريد الإلكتروني");
            editUserName.requestFocus();
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editUserName.setError("صيغة البريد الإلكتروني غير صحيحة");
            editUserName.requestFocus();
            isValid = false;
        } else {
            editUserName.setError(null);
        }

        // فحص كلمة المرور
        if (TextUtils.isEmpty(password)) {
            editPassword.setError("الرجاء إدخال كلمة المرور");
            editPassword.requestFocus();
            isValid = false;
        } else if (password.length() < 6) {
            editPassword.setError("كلمة المرور يجب أن تتكون من 6 خانات على الأقل");
            editPassword.requestFocus();
            isValid = false;
        } else {
            editPassword.setError(null);
        }

        // التنفيذ والانتقال للصفحة الرئيسية (فقط إذا كانت المدخلات سليمة)
        if (isValid) {
            // فحص البيانات مع قاعدة البيانات أو ViewModel
            MyUser user = userViewModel.login(email, password);

            if (user != null) { // تم العثور على المستخدم (بيانات صحيحة)
                Toast.makeText(this, "Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();

                // الانتقال إلى الصفحة الرئيسية
                button2.setOnClickListener(v -> {
                    Intent intent = new Intent(signInAcitvity.this, MainActivity.class);
                    startActivity(intent);
                });

            } else { // البريد أو كلمة المرور غير صحيحة في قاعدة البيانات
                Toast.makeText(this, "البريد الإلكتروني أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
            }
        }

        return isValid;
    }


}

