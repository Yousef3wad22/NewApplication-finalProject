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

    /**
     *
     */
    private void saveUser() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
//,jhhljk
        if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        MyUser myUser = new MyUser();
        myUser.setFullName(fullName);
        myUser.setEmail(email);
        myUser.setPhone(phone);
        myUser.setPassw(password);
//jjlkj
        AppDataBase db = AppDataBase.getDB(getApplicationContext());
        db.getMyUserQuery().insert(myUser);

        Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
