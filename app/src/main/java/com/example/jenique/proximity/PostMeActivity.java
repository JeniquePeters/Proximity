/*
package com.example.jenique.proximity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class PostMeActivity extends AppCompatActivity {

    public ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_me);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        image = findViewById(R.id.imageView);
    }

    public void setImage(View view) {

        image.setImageResource(R.drawable.android_man_mobile2);
    }

    public void post(View view) {
        Intent profIntent = new Intent(PostMeActivity.this, PXActivity.class);
        startActivity(profIntent);
        Snackbar.make(view, "successfully posted", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
*/
