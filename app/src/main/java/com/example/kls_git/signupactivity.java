package com.example.kls_git;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupactivity extends AppCompatActivity {
    TextView clickhere_to_login;
    Button signup_btn;
    TextInputLayout firstname, USN, Email, phone_no, password;
FirebaseDatabase firebaseDatabase;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        clickhere_to_login = findViewById(R.id.clickherelogin);
        clickhere_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(signupactivity.this,R.anim.animations);
                clickhere_to_login.startAnimation(animation);
                Intent intent = new Intent(signupactivity.this, loginactivity.class);
                startActivity(intent);
                finish();
            }
        });
        signup_btn = findViewById(R.id.sign_up_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname = findViewById(R.id.firstname);
                USN = findViewById(R.id.Username_usn);
                Email = findViewById(R.id.email);
                phone_no = findViewById(R.id.phonenumber);
                password = findViewById(R.id.password);
                String first_nam = firstname.getEditText().getText().toString();
                String usn = USN.getEditText().getText().toString();
                String email = Email.getEditText().getText().toString();
                String Phone_num = phone_no.getEditText().getText().toString();
                String Password = password.getEditText().getText().toString();
                if (!first_nam.isEmpty()) {
                    firstname.setError(null);
                    firstname.setErrorEnabled(false);
                    if (!usn.isEmpty()) {
                        USN.setError(null);
                        USN.setErrorEnabled(false);
                        if (!email.isEmpty()) {
                            Email.setError(null);
                            Email.setErrorEnabled(false);
                            if (!Phone_num.isEmpty()) {
                                phone_no.setError(null);
                                phone_no.setErrorEnabled(false);
                                if (!Password.isEmpty()) {
                                    password.setError(null);
                                    password.setErrorEnabled(false);
                                    if(email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                                        if(Password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")){
                                             if(Phone_num.matches("^\\d{10}$")){

                                                 firebaseDatabase = FirebaseDatabase.getInstance();
                                                 reference = firebaseDatabase.getReference("datauser");

                                                final String first_nam_s = firstname.getEditText().getText().toString();
                                                 String usn_s = USN.getEditText().getText().toString();
                                                 String email_s = Email.getEditText().getText().toString();
                                                 String Phone_num_s = phone_no.getEditText().getText().toString();
                                                 String Password_s = password.getEditText().getText().toString();
                                                 storing_data storing_data = new storing_data(first_nam_s, usn_s, email_s, Phone_num_s, Password_s);
                                                 reference.child(usn_s).setValue(storing_data);


                                                 Toast.makeText(signupactivity.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                                                 Intent intent = new Intent(signupactivity.this, loginactivity.class);
                                                 startActivity(intent);
                                                 finish();
                                             }else{
                                               phone_no.setError("please enter valid number");
                                             }
                                        }else {
                                            password.setError("please enter one(uppercase,lowercase,special char,number)");
                                        }
                                    }else{
                                        Email.setError("Invalid email");
                                    }
                                } else {
                                    password.setError("please enter password");
                                }
                            } else {
                                phone_no.setError("please enter phone number");
                            }
                        } else {
                            Email.setError("please enter Email");
                        }
                    } else {
                        USN.setError("please enter USN");
                    }
                } else {
                    firstname.setError("please enter full name");
                }
            }
        });
    }

}