package com.example.jenique.proximity;
//COUNTS AS MAIN ACTIVITY...

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class invitedActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseAuth mAuth;

    public LinearLayout firstlayout, secondlayout, thirdlayout;

    public boolean toggle = true;

    public EditText phoneNrI;

    public TextView test;

    public String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        setContentView(R.layout.activity_invited);

        firstlayout = this.findViewById(R.id.view1);
        secondlayout = this.findViewById(R.id.view2);
        thirdlayout = this.findViewById(R.id.view3);

        phoneNrI = this.findViewById(R.id.phoneNr);*/


//        test = this.findViewById(R.id.invitedByTV); FOLLOW TEST - DISPLAYS ALL USERS IN DB

        mAuth = FirebaseAuth.getInstance();
        setupFirebaseListener();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mRef = database.getReference("Users");



//      USE THIS TO CHECK NRS
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String childValue = String.valueOf(dataSnapshot.getValue());
//                test.setText(childValue);
//                Toast.makeText(invitedActivity.this, childValue, )
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        connect to DB and find phone nr in invited table. if no nr - not allowed to join,
//        else - display who invited them and join button

    }


    public void toggleTest(View view) {
        toggle = !toggle;

        if(toggle == true) {
            firstlayout.setVisibility(LinearLayout.GONE);
            secondlayout.setVisibility(LinearLayout.VISIBLE);
        } else {
            firstlayout.setVisibility(LinearLayout.VISIBLE);
            secondlayout.setVisibility(LinearLayout.GONE);
        }
    }

    public void checkInvites(View view) {
        //IF you have been invited:
        firstlayout.setVisibility(LinearLayout.GONE);
        secondlayout.setVisibility(LinearLayout.VISIBLE);
        toggle = true;
        //else:
        //display thirdlayout with 'sorry' message
    }

    public void inviteFailed(View view) {
        //IF you have been invited:
        firstlayout.setVisibility(LinearLayout.GONE);
//        secondlayout.setVisibility(LinearLayout.VISIBLE);
        thirdlayout.setVisibility(LinearLayout.VISIBLE);

        //else:
        //display thirdlayout with 'sorry' message
    }

    public void joinNow(View view) {

        Intent intent = new Intent(invitedActivity.this, SignUpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

//    sends user back to PXActivity, because they're still logged in!
    private void setupFirebaseListener() {
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //user is logged in
                    Toast.makeText(invitedActivity.this, "user is still logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(invitedActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthStateListener);
        }
    }
}
