package com.example.martialartsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.martialartsapp.Model.DatabaseHandler;
import com.example.martialartsapp.Model.MartialArt;

public class AddMartialArtActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextName, editTextPrice, editTextColor;
    Button btnAddMartialArt, btnGoBack;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);
       // Toast.makeText(AddMartialArtActivity.this, "Add Martial Activity", Toast.LENGTH_SHORT).show();

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextColor = (EditText)findViewById(R.id.editTextColor);
        btnAddMartialArt = (Button)findViewById(R.id.btnAddMartialArt);
        btnGoBack = (Button)findViewById(R.id.btnGoBack);

        databaseHandler = new DatabaseHandler(AddMartialArtActivity.this);

        btnAddMartialArt.setOnClickListener(AddMartialArtActivity.this);
        btnGoBack.setOnClickListener(AddMartialArtActivity.this);

    }
    private void addMartialArtObjectToDatabase(){
       String nameValue = editTextName.getText().toString();
       String priceValue = editTextPrice.getText().toString();
       String colorValue = editTextColor.getText().toString();
       try{
           double priceDoubleValue = Double.parseDouble(priceValue);
           MartialArt martialArtObject = new MartialArt(0, nameValue, priceDoubleValue, colorValue);
           databaseHandler.addMartialArt(martialArtObject);
           Toast.makeText(AddMartialArtActivity.this,
                   martialArtObject+" This Martial Art is saved to the database",
                   Toast.LENGTH_SHORT).show();

       } catch(Exception e){
           e.printStackTrace();
       }

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAddMartialArt:
                addMartialArtObjectToDatabase();
                break;

            case R.id.btnGoBack:
                this.finish();
                break;

        }
    }
}