package com.example.jenique.proximity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomepageToolbarIneteractions extends AppCompatActivity /*implements View.OnClickListener */{

    private TextView textViewFaction, textViewProxim;
    private Button buttonSearch;
    private ImageView imageViewProfile;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String uid;
    private ImageView imageViewProfilePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_toolbar);

        Toolbar toolbar = findViewById(R.id.new_homepage_toolbar);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null)
            uid = user.getUid();

//        setSupportActionBar(toolbar);

//        databaseReference = FirebaseDatabase.getInstance().getReference();

/*        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Image profiePic = dataSnapshot.child("users").child(uid).child("profilePic").getValue(Image.class);

              //  imageViewProfilePic.setImage

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

/*        textViewFaction = findViewById(R.id.textViewFaction);
        textViewProxim = findViewById(R.id.textViewProxim);
        buttonSearch = findViewById(R.id.buttonSearch);
        imageViewProfile = findViewById(R.id.imageViewProfile);


        textViewFaction.setOnClickListener(this);
        textViewProxim.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
        imageViewProfile.setOnClickListener(this);*/
    }

/*    public void To_FactionActivity(View view) {
        Intent i = new Intent(this, FactionActivity.class);
        startActivity(i);
    }

    public void To_SerchActivity(View view) {
        Intent i = new Intent(this, SerchActivity.class);
        startActivity(i);
    }

    public void To_ProximsActivity(View view) {
        Intent i = new Intent(this, ProximsActivit.class);
        startActivity(i);
    }
    public void To_ProfileActivity(View view) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }*/

    public void To_FactionActivity(View view) {
        startActivity(new Intent(this,FactionActivity.class));
    }

    public void To_SerchActivity(View view) {
        startActivity(new Intent(this,SerchActivity.class));
    }

    public void To_ProximsActivity(View view) {
        startActivity(new Intent(this,ProximsActivit.class));
    }
    public void To_ProfileActivity(View view) {
        startActivity(new Intent(this,ProfileActivity.class));
    }

/*    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.textViewFaction:
            {
                startActivity(new Intent(this, FactionActivity.class));
                break;
            }

            case R.id.textViewProxim:
            {
                startActivity(new Intent(this, ProximsActivit.class));
                break;
            }

            case R.id.buttonSearch:
            {
                startActivity(new Intent(this, SerchActivity.class));
                break;
            }

            case R.id.imageViewProfile:
            {
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            }

        }
    }*/
}