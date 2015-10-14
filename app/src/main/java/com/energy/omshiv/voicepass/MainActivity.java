package com.energy.omshiv.voicepass;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {


    private Button Login;
    private Button Register;
    private EditText UserName;
    private EditText Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = (EditText) findViewById(R.id.uLogin);
        Password = (EditText) findViewById(R.id.uPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button)findViewById(R.id.btnRegister);
        Login = (Button) findViewById(R.id.btnLogin);



        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent takeUserHome = new Intent(MainActivity.this, Register.class);
                startActivity(takeUserHome);

            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = UserName.getText().toString().trim();
                String password = Password.getText().toString().trim();


                UserName.getText().clear();
                Password.getText().clear();


                ParseUser.logInInBackground(username, password, new LogInCallback() {

                    @Override
                    public void done(ParseUser parseUser, com.parse.ParseException e) {

                        if (e == null) {
                            // success !

                            Toast.makeText(MainActivity.this, "Success ! Welcome", Toast.LENGTH_LONG).show();
                            // Take user to homepage
                            Intent takeUserHome = new Intent(MainActivity.this, Home.class);
                            UserName.getText().clear();
                            Password.getText().clear();
                            startActivity(takeUserHome);


                        } else {
                            // sorry there is a login problem
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage(e.getMessage());
                            builder.setTitle("Sorry");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {


                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    }
                });


            }
        });




    }


}
