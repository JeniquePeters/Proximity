package com.example.jenique.proximity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.squareup.picasso.Picasso;

public class PersonalisationActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, View.OnClickListener{

    private static final int PICK_IMAGE_REQUEST = 1;

    private EditText editTextUserName;
    private ImageView imageViewProfile;
    private ImageView imageViewEditImage;
    private Button buttonSaveChanges;

    private Uri mImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalisation);

        Button factionFinder = findViewById(R.id.popup);

        factionFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop = new PopupMenu(PersonalisationActivity.this,view);
                pop.setOnMenuItemClickListener(PersonalisationActivity.this);
                pop.inflate(R.menu.menu_faction_items);
                pop.show();
            }
        });

        editTextUserName = findViewById(R.id.editTextUserName);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        imageViewEditImage = findViewById(R.id.imageViewEditImage);
        buttonSaveChanges = findViewById(R.id.buttonSaveChanges);


        imageViewEditImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profilePicSelection();
            }
        });
    }

    private void profilePicSelection()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intent,PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null)
        {
            mImageUri = data.getData();
//            Picasso.with(this).load(mImageUri).into(imageViewProfile);
            imageViewProfile.setImageURI(mImageUri);
        }
    }

    public void back_to_profile(View view) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        Button button = findViewById(R.id.popup);

        switch(menuItem.getItemId()){
            case R.id.UJ:
                button.setText("Faction: University of Johannesburg");
                return true;

            case R.id.Wits:
                button.setText("Faction: University of Witwatersrand");
                return true;

            case R.id.UP:
                button.setText("Faction: University of Pretoria");
                return true;

            case R.id.UCT:
                button.setText("Faction: University of Cape Town");
                return true;

            case R.id.Sell:
                button.setText("Faction: University of Stellenbosch");
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {

    }
}
