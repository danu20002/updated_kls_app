package com.example.kls_git;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview =findViewById(R.id.textview);
        TextView janan=findViewById(R.id.jnanganga);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,loginactivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                        Animation animation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.animations);
                        textview.startAnimation(animation);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                janan.append("J");
                            }
                        },100);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("N");
                    }
                },200);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("A");
                    }
                },300);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("N");
                    }
                },400);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("A");
                    }
                },500);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("G");
                    }
                },600);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("A");
                    }
                },700);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("N");
                    }
                },800);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("G");
                    }
                },900);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        janan.append("A");
                    }
                },1000);
                MediaPlayer md=MediaPlayer.create(MainActivity.this,R.raw.clicking_sound);
                md.start();
            }

        },0000);

    }
}