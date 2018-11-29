package com.example.jenique.proximity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUsername, textViewStatus;
    private FirebaseUser user;
    private String uid;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewUsername = findViewById(R.id.textViewUsername);
        textViewStatus = findViewById(R.id.textViewStatus);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
            uid = user.getUid();
        Toast.makeText(getApplicationContext(),"userID is " + uid,Toast.LENGTH_SHORT).show();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userName = dataSnapshot.child("users").child(uid).child("username").getValue(String.class);
                String status = dataSnapshot.child("users").child(uid).child("status").getValue(String.class);

                Toast.makeText(getApplicationContext(), userName,Toast.LENGTH_SHORT).show();
                textViewUsername.setText(userName);
                textViewStatus.setText(status);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    public void To_personalisationActivity(View view) {
        Intent i = new Intent(this, PersonalisationActivity.class);
        startActivity(i);
    }

    public void back_to_main(View view) {
        Intent i = new Intent(this, FactionActivity.class);
        startActivity(i);
    }
}
