package com.example.week2day1_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CarRegistrationActivity extends AppCompatActivity {

    // EditText's for user to input info
    EditText etYear;
    EditText etMake;
    EditText etModel;
    EditText etColor;
    EditText etEngine;
    EditText etTransmission;

    // the intent to be passed back to main
    Intent passedIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_registration);
        etYear = findViewById(R.id.etYear);
        etMake = findViewById(R.id.etMake);
        etModel = findViewById(R.id.etModel);
        etColor = findViewById(R.id.etColor);
        etEngine = findViewById(R.id.etEngine);
        etTransmission = findViewById(R.id.etTransmission);
        passedIntent = new Intent();
    }

    public void onClick(View view) {
        String Year = etYear.getText().toString();
        String Make = etMake.getText().toString();
        String Model = etModel.getText().toString();
        String Color = etColor.getText().toString();
        String Engine = etEngine.getText().toString();
        String Transmission = etTransmission.getText().toString();

        // Create a car object with the user's input
        Car passedCar = new Car(Year, Make, Model, Color, Engine, Transmission);

        // Create a new Bundle
        Bundle bundle = new Bundle();

        // put the car object inside the bundle
        bundle.putParcelable("car", passedCar);

        // pass the bundle back to main
        passedIntent = new Intent(this, MainActivity.class);
        passedIntent.putExtras(bundle);
        setResult(111, passedIntent);
        finish();
    }
}
