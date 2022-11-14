package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login2;
    EditText username2,password2;
    int count=0;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username2=findViewById(R.id.username2);
        password2=findViewById(R.id.password2);
        login2=findViewById(R.id.login2);
        login2.setOnClickListener(this);
        Bundle bundle = getIntent().getBundleExtra("data");
        username=bundle.getString("namekey").toString();
        password=bundle.getString("passkey").toString();
    }

    @Override
    public void onClick(View v) {
    if(v.equals(login2))
    {
        String login_name,login_pwd;
        login_name=username2.getText().toString();
        login_pwd=password2.getText().toString();
        if(login_name.equals(username) && login_pwd.equals(password))
        {
            Toast.makeText(getBaseContext(), "success", Toast.LENGTH_LONG).show();
            Intent in = new Intent(LoginActivity.this,homepage.class);
            startActivity(in);
        }
        else
        {
            count++;
            if(count==3)
            {
                Toast.makeText(getBaseContext(),"BLOCKED",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getBaseContext(),"WRONG PASSWORD",Toast.LENGTH_LONG).show();
            }
        }
    }
    }
}