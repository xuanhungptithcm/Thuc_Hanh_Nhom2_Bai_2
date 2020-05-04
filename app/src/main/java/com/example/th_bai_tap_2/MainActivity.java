package com.example.th_bai_tap_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtUsername,txtPassword;
    Button btnLogin;
    CheckBox cbSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if(!username.equals("") && !password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công\n Username: " + username +"\n Password:" + password, Toast.LENGTH_LONG).show();
                } else {
                    if(username.equals("") && password.equals("")) {
                        Toast.makeText(getApplicationContext(), "Vui lòng điền tên đăng nhập và mật khẩu", Toast.LENGTH_LONG).show();
                        txtUsername.requestFocus();
                    } else {
                        if(username.equals("")) {
                            Toast.makeText(getApplicationContext(), "Vui lòng điền tên đăng nhập", Toast.LENGTH_LONG).show();
                            txtUsername.requestFocus();
                        }
                        if(password.equals("")) {
                            Toast.makeText(getApplicationContext(), "Vui lòng mật khẩu", Toast.LENGTH_LONG).show();
                            txtPassword.requestFocus();
                        }
                    }

                }

            }
        });
        cbSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                   Toast.makeText(getApplicationContext(), "Bật lưu thông tin người dùng", Toast.LENGTH_LONG).show();
               } else {
                   Toast.makeText(getApplicationContext(), "Không lưu thông tin người dùng", Toast.LENGTH_LONG).show();
               }
            }
        });


    }

    private void setControl() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        cbSave = findViewById(R.id.cbSave);
    }
}
