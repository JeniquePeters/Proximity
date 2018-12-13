package com.example.jenique.proximity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class SerchActivity extends HomepageToolbarIneteractions implements View.OnClickListener {

    private ExpandableListAdapter expandableListAdapter;
    private List<Event> eventList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch);

    }

    public void activate_compatible_view(View view)
    {
/*        TextView textView = findViewById(R.id.info_text_box);
        Button button = findViewById(R.id.info_button);

        textView.setText("Look for people in your faction with traits and and interests like yours!");
        button.setVisibility(View.VISIBLE);
        button.setText("Search");*/

    }

    public void activate_Random_view(View view)
    {
/*        TextView textView = findViewById(R.id.info_text_box);
        Button button = findViewById(R.id.info_button);

        textView.setText("Take a risk and connect with random people in your faction!");
        button.setVisibility(View.VISIBLE);
        button.setText("Search");*/
    }

    public void activate_specific_view(View view)
    {
/*        TextView textView = findViewById(R.id.info_text_box);
        Button button = findViewById(R.id.info_button);

        textView.setText("If your looking for something more specific, this is the place to be! Find people in your faction with the traits and interests to your liking.");
        button.setVisibility(View.VISIBLE);
        button.setText("Specify");*/
    }

    @Override
    public void onClick(View view) {

    }
}