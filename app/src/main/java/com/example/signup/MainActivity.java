package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button signup,login;
    EditText username,password;
    String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
    //String regularExpression="^(?=.*[a-z])$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(signup))
        {
            String newuname=username.getText().toString();
            String newpass=password.getText().toString();
            if(validatePassword(newpass))
            {
                Bundle bundle=new Bundle();
                bundle.putString("namekey",newuname);
                bundle.putString("passkey",newpass);
                Intent it=new Intent(this,LoginActivity.class);
                it.putExtra("data",bundle);
                startActivity(it);
            }
            else
            {
                Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
            }
        }
        else if(v.equals(login))
        {
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }
    public boolean validatePassword(String password)
    {
        Pattern pattern= Pattern.compile(regularExpression);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}