package ysf.awd.newapplication_finalproject.Model.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
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

public class signIn extends AppCompatActivity {
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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
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
            Intent intent = new Intent(signIn.this, RegisterActivity.class);
            startActivity(intent);
        });

    }
    public void signInUser() {
        String email = editUserName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editUserName.setError("Email is required");
            editUserName.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editPassword.setError("Password is required");
            editPassword.requestFocus();
            return;
        }

        MyUser user = userViewModel.login(email, password);
        if (user != null) {
            Toast.makeText(this, "Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(signIn.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

}
