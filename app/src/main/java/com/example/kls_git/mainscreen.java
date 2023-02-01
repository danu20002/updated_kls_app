package com.example.kls_git;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class mainscreen extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
TextInputLayout usn_feliding,password_feilding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        drawerLayout=findViewById(R.id.drawerlayout);
        navigationView=findViewById(R.id.navview);
        toolbar=findViewById(R.id.toolbar);

            loadfragment(new home_fragment(),0);
        //step1
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(mainscreen.this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.home){
                      loadfragment(new home_fragment(),1);
                } else if (id==R.id.profile) {
                        loadfragment(new profile_fragment(),2);
                } else if (id==R.id.ise) {

                } else if (id==R.id.cse) {

                }else if (id==R.id.ec){

                } else if (id==R.id.eee) {

                }else{

                }

                return true;
            }
        });
    }

    private void loadfragment(Fragment fragment,int flag) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(flag==0)
        fragmentTransaction.add(R.id.framelayout,fragment);
        else
            fragmentTransaction.replace(R.id.framelayout,fragment);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }


}