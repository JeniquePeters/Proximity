package com.example.jenique.proximity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

     private static final String TAG = "SignUpActivity";
     private FirebaseAuth mAuth;
     private EditText editTextEmail, editTextPassword, editTextRedoPassword, editTextUsername;
     private RadioGroup radioGroup;
     private RadioButton radioButton;
//     private StorageReference mStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViewById(R.id.textViewSignUp).setOnClickListener(this);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.userEmail);
        editTextPassword = findViewById(R.id.userPassword);
        editTextRedoPassword = findViewById(R.id.editTextRedoPassword);
        radioGroup = findViewById(R.id.radioGroupGenderSelection);

         mAuth = FirebaseAuth.getInstance();
//       mStorageRef = FirebaseStorage.getInstance().getReference();c
    }

    public void checkButton(View view)
    {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);


    }

/*    private void setProfilePic(String gender)
    {
        File localFile = null;
        try {
            localFile = File.createTempFile("image", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StorageReference riversRef = mStorageRef.child("DefaultUserProfilePics/user.png");
        riversRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

            }
        });
    }*/

    private void registerUser()
    {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String redoPassword = editTextRedoPassword.getText().toString().trim();

        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
       if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Invalid email address");
           editTextEmail.requestFocus();
           return;
        }


        if(password.isEmpty())
       {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }


       if(password.length()<6)
       {
            editTextPassword.setError("Invalid password length (6 or greater)");
            editTextPassword.requestFocus();
            return;
        }


        if(!password.equals(redoPassword))
        {
            editTextRedoPassword.setError("Passwords do not match");
            editTextRedoPassword.requestFocus();
            return;
        }

       mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    String userId = mAuth.getCurrentUser().getUid();
                    String gender = radioButton.getText().toString().trim();
                    Toast.makeText(getApplicationContext(),"You are now registered!",Toast.LENGTH_SHORT).show();
                    Log.d(TAG,"Email sent.");


 //                 FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("users").child(userId);
                    String username = editTextUsername.getText().toString().trim();
                    Map newPost = new HashMap();

                    newPost.put("username", username);
                    newPost.put("gender", gender);
                    newPost.put("status", "Hello i'm using proximity" );

/*                    if(radioButton.getText().equals("Female"))
                        newPost.put("profilePic", R.drawable.girl);
                    else if (radioButton.getText().equals("Male"))
                    //    newPost.put("profilePic", Im);*/

//                    setProfilePic(gender);
//
                    myRef.setValue(newPost);

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
       switch(view.getId())
        {
            case R.id.textViewSignUp:
                registerUser();
            break;
        }
    }
}
