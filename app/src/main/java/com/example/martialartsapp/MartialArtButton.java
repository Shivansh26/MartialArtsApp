package com.example.martialartsapp;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.martialartsapp.Model.MartialArt;

public class MartialArtButton extends AppCompatButton {
    private MartialArt martialArtObject;

    public MartialArtButton(Context context, MartialArt martialArt){
        super(context);
        martialArtObject = martialArt;

    }
    public String getMartialArtColor() {
        return martialArtObject.getMartialArtColor();
    }
    public double getMartialArtPrice(){
        return martialArtObject.getMartialArtPrice();
    }
}
