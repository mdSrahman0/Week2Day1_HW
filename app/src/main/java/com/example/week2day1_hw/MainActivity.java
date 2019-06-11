// Md Rahman

package com.example.week2day1_hw;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG_MAIN_ACTIVITY";
    // display the info of the last car saved
    TextView tvLastCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        tvLastCar = findViewById(R.id.tvLastCar);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStartCarRegActivity:
                startActivityForResult();
                break;
        } // end switch
    }

    private void startActivityForResult() {
        Intent intent = new Intent(this, CarRegistrationActivity.class);
        startActivityForResult(intent, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: " + requestCode);

        // first make sure we have correct request code AND data does exist
        if(requestCode == 111 && data != null){
            Bundle passedBundle = data.getExtras();
            Log.d(TAG, "onActivityResult: Inside First if");

            // make sure bundle does exist
            if(passedBundle != null) {
                Car car = passedBundle.getParcelable("car");
                Log.d(TAG, "onActivityResult: Inside second if");

                // make sure car does exist
                if (car != null) {
                    tvLastCar.setVisibility(View.VISIBLE);
                    tvLastCar.setText("SAVED CAR:\n\n");

                    // use toString to display
                    tvLastCar.append(car.toString());
                    Log.d(TAG, "onActivityResult: Inside final if");
                }
            }
        } // end outermost if
    } // end onActivityResult
} // end MainActivity
