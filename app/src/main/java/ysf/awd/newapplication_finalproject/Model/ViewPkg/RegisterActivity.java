package ysf.awd.newapplication_finalproject.Model.ViewPkg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ysf.awd.newapplication_finalproject.R;

public class RegisterActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editTextTextMultiLine;
    private EditText editTextText;
    private EditText editTextText2;
    private EditText editTextText11;
    private Button btnSaveTask;

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
        textView= findViewById(R.id.textView);
        editTextTextMultiLine= findViewById(R.id.editTextTextMultiLine);
        editTextText= findViewById(R.id.editTextText);
        editTextText2= findViewById(R.id.editTextText2);
        editTextText11= findViewById(R.id.editTextText11);
        btnSaveTask= findViewById(R.id.btnSaveTask);


    }
}