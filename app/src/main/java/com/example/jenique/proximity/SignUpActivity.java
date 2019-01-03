package com.example.jenique.proximity;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener firebaseAuthListener;

//    EditText nameI, passwrdI, usernameI, emailI, phoneNrI;
//    Spinner genderSp, professionSp, factionSp, traitsSp, interestsSp, buzzSp;
//    ArrayAdapter<CharSequence> genderAdapt, professionAdapt, factionAdapt, traitsAdapt, interestsAdapt, buzzAdapt;
//    String gend, prof, fact, trait, inter, bzz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        setSpinners();
//        setInfoVars();
//
//        mAuth = FirebaseAuth.getInstance();
//        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                if (user != null) {
//                    Intent intent = new Intent(SignUpActivity.this, FactionActivity.class);
//                    startActivity(intent);
//                    finish();
//                    return;
//                }
//            }
//        };
    }

    public void login(View view) {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        return;
    }

    public void registerMe(View view) {
//        final String email = emailI.getText().toString();
//        final String username = usernameI.getText().toString();
//        final String name = nameI.getText().toString();
////        final String phoneNr = phoneNrI.getText().toString();
//        final String password = passwrdI.getText().toString();
//
////        if (email == "" || username == "" || name == "" || password == "") {
////            Toast.makeText(RegisterActivity.this, "some fields are empty. please complete all fields", Toast.LENGTH_SHORT).show();
////
////        } else {
//
//        Query usernameQuery = FirebaseDatabase.getInstance().getReference().child("Users").orderByChild("username").equalTo(username);
//        usernameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.getChildrenCount() > 0) {
//                    Toast.makeText(SignUpActivity.this, "Username already in use", Toast.LENGTH_SHORT).show();
//                } else {
//                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (!task.isSuccessful()) {
//                                Toast.makeText(SignUpActivity.this, "Sign-up Error", Toast.LENGTH_SHORT).show();
//                            } else {
//                                String user_id = mAuth.getCurrentUser().getUid();
//                                final DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);
//
//                                Map newPost = new HashMap();
//                                newPost.put("name", name);
//                                newPost.put("username", username);
////                                    newPost.put("phoneNr", phoneNr); //for some reason, won't allow nr...
//                                newPost.put("gender", gend);
//                                newPost.put("profession", prof);
//                                newPost.put("faction", fact);
//                                newPost.put("interests", inter);
//                                newPost.put("traits", trait);
//                                newPost.put("buzz", bzz);
//                                newPost.put("invToken", user_id);
//
//                                current_user_db.setValue(newPost);
//
//                                String uname = mAuth.getUid();
//                                Toast.makeText(SignUpActivity.this, uname + "uname and user_id" + user_id, Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(SignUpActivity.this, "Database Error" + databaseError, Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

//    }

    private void setInfoVars() {
////        nameI = findViewById(R.id.name);
//        usernameI = findViewById(R.id.editTextUsername);
//        emailI = findViewById(R.id.userEmail);
////        phoneNrI = findViewById(R.id.phoneNr);
//        passwrdI = findViewById(R.id.userPassword);
    }

    private void setSpinners() {
//      GENDER
/*        genderSp = findViewById(R.id.gender);
        genderAdapt = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        genderAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSp.setAdapter(genderAdapt);
        genderSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gend = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), gend + " is gender set", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gend = parent.getItemAtPosition(0).toString();
                Toast.makeText(getBaseContext(), gend + " is no gender set", Toast.LENGTH_SHORT).show();
            }
        });
//      PROFESSION
        professionSp = findViewById(R.id.profession);
        professionAdapt = ArrayAdapter.createFromResource(this, R.array.profession, android.R.layout.simple_spinner_item);
        professionAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        professionSp.setAdapter(professionAdapt);
        professionSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prof = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), prof + " is profession set", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "no profession is set", Toast.LENGTH_SHORT).show();
            }
        });
//      FACTION
        factionSp = findViewById(R.id.faction);
        factionAdapt = ArrayAdapter.createFromResource(this, R.array.factions, android.R.layout.simple_spinner_item);
        factionAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factionSp.setAdapter(factionAdapt);
        factionSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fact = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), fact + " is faction set", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "no faction is set", Toast.LENGTH_SHORT).show();
            }
        });
//      TRAITS
        traitsSp = findViewById(R.id.traits);
        traitsAdapt = ArrayAdapter.createFromResource(this, R.array.traits, android.R.layout.simple_spinner_item);
        traitsAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traitsSp.setAdapter(traitsAdapt);
        traitsSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                trait = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), trait + " is traits set", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "no traits are set", Toast.LENGTH_SHORT).show();
            }
        });
//      INTERESTS
        interestsSp = findViewById(R.id.interests);
        interestsAdapt = ArrayAdapter.createFromResource(this, R.array.interests, android.R.layout.simple_spinner_item);
        interestsAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interestsSp.setAdapter(interestsAdapt);
        interestsSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inter = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), inter + " is interests set", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "no interests are set", Toast.LENGTH_SHORT).show();
            }
        });
//      BUZZ
        buzzSp = findViewById(R.id.buzz);
        buzzAdapt = ArrayAdapter.createFromResource(this, R.array.buzz, android.R.layout.simple_spinner_item);
        buzzAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buzzSp.setAdapter(buzzAdapt);
        buzzSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bzz = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), bzz + " is buzz set", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "no buzz is set", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
////////////////////////////////RED COMMENT
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(firebaseAuthListener);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mAuth != null) {
//            mAuth.removeAuthStateListener(firebaseAuthListener);
//        }
//    }
    //////////////////////////////////
}

