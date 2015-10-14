package com.energy.omshiv.voicepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.io.File;

public class Register extends Activity {

    private Button Register;
    private Button Login;
    private EditText UserName;
    private EditText Password;
    private EditText Email;
    private EditText RecordPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        UserName = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Email = (EditText) findViewById(R.id.email);
        RecordPassword = (EditText)findViewById(R.id.sound);
        Register = (Button)findViewById(R.id.btnRegister);
        Login = (Button)findViewById(R.id.btnLogin);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String uName = UserName.getText().toString().trim();
                String uPassword = Password.getText().toString().trim();
                String uEmail = Email.getText().toString().trim();
                String uRecord = RecordPassword.getText().toString().trim();


                ParseUser user = new ParseUser();


                user.setPassword(uPassword);
                user.setUsername(uName);
                user.setEmail(uEmail);
                user.put("sound", uRecord);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            // user signed up successfully

                            Toast.makeText(Register.this, "Success ! Welcome", Toast.LENGTH_LONG).show();
                            // take user homepage
                            Intent takeUserHome = new Intent(Register.this, Home.class);
                            startActivity(takeUserHome);

                        } else {
                            //there was an error signing up user.

                        }
                    }
                });

            }
        });



    }



    }

