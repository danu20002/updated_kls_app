package com.example.kls_git;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class loginactivity extends AppCompatActivity {
Button signinbtn;
ProgressBar progressBar;
TextInputLayout username_login,password_login;
TextView clickhere,forgot;
FirebaseAuth auth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for removing status bar
            //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loginactivity);
        signinbtn=findViewById(R.id.signinbtn);
        clickhere=findViewById(R.id.clickhere);
        forgot=findViewById(R.id.forgotpassword);
        username_login=findViewById(R.id.username_login);
        password_login=findViewById(R.id.password_login);
        progressBar=findViewById(R.id.progressBar);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=username_login.getEditText().getText().toString();
                String password=password_login.getEditText().getText().toString();
                if(!username.isEmpty()){
                    username_login.setError(null);
                    username_login.setErrorEnabled(false);
                     if(!password.isEmpty()){
                            password_login.setError(null);
                            password_login.setErrorEnabled(false);
                            final String USN_data=username_login.getEditText().getText().toString();
                            final String  password_data=password_login.getEditText().getText().toString();

                         FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                         DatabaseReference reference=firebaseDatabase.getReference("datauser");
                         Query check_usn=reference.orderByChild("usn").equalTo(USN_data);
                         check_usn.addListenerForSingleValueEvent(new ValueEventListener() {
                             @Override
                             public void onDataChange(@NonNull DataSnapshot snapshot) {
                                 if(snapshot.exists()){
                                     username_login.setError(null);
                                     username_login.setErrorEnabled(false);
                                     String check_password=snapshot.child(USN_data).child("password").getValue(String.class);
                                     if(check_password.equals(password_data)){
                                       password_login.setError(null);
                                       password_login.setErrorEnabled(false);
                                            progressBar.setVisibility(progressBar.getProgress());
                                          String usn=snapshot.child(USN_data).child("usn").getValue(String.class);
                                                 Intent intent=new Intent(loginactivity.this,interfacectivity.class);

                                         intent.putExtra("usn",usn);
                                         intent.putExtra("password",check_password);
                                         startActivity(intent);

                                 Toast.makeText(loginactivity.this, "logged in successfully", Toast.LENGTH_SHORT).show();
//                                         Intent intent=new Intent(loginactivity.this,interfacectivity.class);
//                                         startActivity(intent);


                                         finish();
                                     }else{
                                         password_login.setError("wrong password");
                                     }
                                 }else{
                                     username_login.setError("user doesn't Exists ");
                                 }
                             }

                             @Override
                             public void onCancelled(@NonNull DatabaseError error) {

                             }
                         });


                     }else{
                         password_login.setError("please enter password");
                     }
                }else{
                    username_login.setError("please enter USN");
                }

            }
        });
  clickhere.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Animation animation= AnimationUtils.loadAnimation(loginactivity.this,R.anim.animations);
         clickhere.startAnimation(animation);
          new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                  Intent intent=new Intent(loginactivity.this,signupactivity.class);
                  Toast.makeText(loginactivity.this, "please signup here", Toast.LENGTH_SHORT).show();
                  startActivity(intent);
                  finish();
              }
          },1000);

      }
  });
  forgot.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
                       Intent intent=new Intent(getApplicationContext(),forgetpassword.class);
                       startActivity(intent);
      }
  });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(loginactivity.this,signupactivity.class));
            Toast.makeText(this, "Firstly sign Up ", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}