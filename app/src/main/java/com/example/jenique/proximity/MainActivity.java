package com.example.jenique.proximity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText editTextEmail, editTextPassword;
    private TextView textViewSignUp;
    private Button buttonSignIn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewSignUp = findViewById(R.id.Sign_up);
        progressBar = findViewById(R.id.progressBar);
        //editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

        buttonSignIn = findViewById(R.id.buttonSignIn);

        buttonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);


    }
/*    public void To_FactionActivity(View view)
    {
        Intent i = new Intent(this,FactionActivity.class);
        startActivity(i);
    }*/

/*    public void To_SignUpActivity(View view)
    {
        Intent i = new Intent(this, SignUpActivity.class);
                startActivity(i);
    }*/


    private void enterHomepage()
    {
        startActivity(new Intent(MainActivity.this, FactionActivity.class));
    }

    private void signInUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty())
        {
            editTextEmail.setError("Please add your email");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            editTextPassword.setError("Please add your password");
            editTextPassword.requestFocus();
            return;
        }


       mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser user = mAuth.getCurrentUser();
                    editTextEmail.setVisibility(View.INVISIBLE);
                    editTextPassword.setVisibility(View.INVISIBLE);
                    buttonSignIn.setVisibility(View.INVISIBLE);
                    textViewSignUp.setVisibility(View.INVISIBLE);
                    editTextEmail.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
//                    Intent intent = new Intent(MainActivity.this, FactionActivity.class);
//                    startActivity(intent);
                    enterHomepage();
                }

            }
        });{

        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.buttonSignIn:
            {
                signInUser();
                break;
            }
            case R.id.Sign_up:
            {
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            }
        }
    }
}
