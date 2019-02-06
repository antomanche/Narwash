
package com.example.listview_narwash;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView mytitle;
    LinearLayout linerlayout;
    EditText editText;
    EditText editPassword;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        mytitle = findViewById(R.id.mytitle);
        linerlayout = findViewById(R.id.linearLayout);
        editText = findViewById(R.id.insertuser);
        editPassword = findViewById(R.id.insertpassword);
        button = findViewById(R.id.login_button);
    }
}
