//indicates the location of the file within the project structure.
package com.example.unitconverter;

//These import statements bring in the necessary classes from the AndroidX library that are used in the below code
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

//These import statements bring in the necessary classes from the Android framework that are used in the below code.
import android.content.Intent;
import android.os.Bundle;

//defines the 'MainActivity' class, which extends the 'AppCompatActivity' class. It serves as the entry point for the application and contains the main logic.
public class MainActivity extends AppCompatActivity {

    //declares the instance variables for the 'CardView' components used in the layout.
    CardView time,liquid,weight,length;

    //This method is called when the activity is created. It initializes the activity's layout by inflating the XML file 'activity_main.xml' and setting it as the content view for the activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of the 'CardView' variables by finding the views with their respective IDs from the layout file.
        time =  findViewById(R.id.time);
        liquid = findViewById(R.id.liquid);
        weight = findViewById(R.id.weight);
        length = findViewById(R.id.length);

        //This block sets a click listener for the 'time' CardView. When the CardView is clicked, it creates an 'Intent' to start the 'Time' activity and calls 'startActivity()' to begin the new activity.
        time.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Time.class);
            startActivity(intent);
        });

        //This block sets a click listener for the 'liquid' CardView. When the CardView is clicked, it creates an 'Intent' to start the 'Liquid' activity and calls 'startActivity()' to begin the new activity.
        liquid.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Liquid.class);
            startActivity(intent);
        });

        //This block sets a click listener for the 'weight' CardView. When the CardView is clicked, it creates an 'Intent' to start the 'Weight' activity and calls 'startActivity()' to begin the new activity.
        weight.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Weight.class);
            startActivity(intent);
        });
        //This block sets a click listener for the 'length' CardView. When the CardView is clicked, it creates an 'Intent' to start the 'Length' activity and calls 'startActivity()' to begin the new activity.
        length.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Length.class);
            startActivity(intent);
        });

    }
}