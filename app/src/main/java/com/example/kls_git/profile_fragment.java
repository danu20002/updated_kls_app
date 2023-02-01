package com.example.kls_git;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class profile_fragment extends Fragment {



    public profile_fragment() {
        // Required empty public constructor
    }


TextView fullname,usn;
    TextInputLayout usn_edit,fullname_edit,phonenumber_edit,email_edit;
    DatabaseReference reference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewroot = inflater.inflate(R.layout.fragment_profile_fragment, container, false);
        // Inflate the layout for this fragment
        reference = FirebaseDatabase.getInstance().getReference("users");
        fullname = viewroot.findViewById(R.id.full_name_text);
        usn = viewroot.findViewById(R.id.usn);


        usn_edit = viewroot.findViewById(R.id.usn_p_field);
        fullname_edit = viewroot.findViewById(R.id.fullname_p_field);
        phonenumber_edit = viewroot.findViewById(R.id.phonenumber_p_field);
        email_edit = viewroot.findViewById(R.id.email_p_field);

return viewroot;
    }
}