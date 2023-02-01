package com.example.kls_git;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;


public class home_fragment extends Fragment {



    public home_fragment() {
        // Required empty public constructor
    }
LottieAnimationView google,insta,facebook;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewroot=inflater.inflate(R.layout.fragment_home_fragment, container, false);
        // Inflate the layout for this fragment
        google=(LottieAnimationView) viewroot.findViewById(R.id.google_anim);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.git.edu/"));
                startActivity(intent);
            }
        });
        insta=(LottieAnimationView) viewroot.findViewById(R.id.insta);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/klsgitbelagavi/"));
                startActivity(intent);
            }
        });
        facebook=(LottieAnimationView) viewroot.findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/KLSGITBelagavi"));
                startActivity(intent);
            }
        });
        return viewroot;

    }


}