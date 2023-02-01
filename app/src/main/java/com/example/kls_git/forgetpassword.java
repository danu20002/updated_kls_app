package com.example.kls_git;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {
  private TextInputLayout  emailing;
  private Button send_verify;
  private TextView clicling;
  private FirebaseAuth auth;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        emailing= findViewById(R.id.emailing);
        send_verify= findViewById(R.id.send_verificationn);
        clicling= findViewById(R.id.clickherelogining);
        auth=FirebaseAuth.getInstance();
        send_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email=emailing.getEditText().getText().toString();


                if(!email.isEmpty()){
                    forgotpassword();
                }else {
                    Toast.makeText(forgetpassword.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void forgotpassword() {
       auth=FirebaseAuth.getInstance();
       email=emailing.getEditText().getText().toString();
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(forgetpassword.this, "Check Your Email Gajni", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(forgetpassword.this,loginactivity.class));
                    finish();
                }else{
                    Toast.makeText(forgetpassword.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}