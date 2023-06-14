package com.example.unitconverter;

//These import statements bring in the necessary classes from the Android framework that are used in the below code.
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Weight extends AppCompatActivity {

    //declares instance variables for the different UI components used in the layout.
    EditText edittext;
    Spinner spinner;
    TextView kilogram,hectogram,decagram,gram,decigram,centigram,milligram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        //initialize the UI components by finding the views with their respective IDs from the layout file.
        edittext = findViewById(R.id.edittext);
        spinner = findViewById(R.id.spinner);
        kilogram = findViewById(R.id.kilogram);
        hectogram = findViewById(R.id.hectogram);
        decagram = findViewById(R.id.decagram);
        gram = findViewById(R.id.gram);
        decigram = findViewById(R.id.decigram);
        centigram = findViewById(R.id.centigram);
        milligram = findViewById(R.id.milligram);

        // sets up the 'Spinner' component with an 'ArrayAdapter' to display the available weight volume conversion options in the dropdown menu.
        String[] arr = {"kilogram","hectogram","decagram","gram","decigram","centigram","milligram"};
        spinner.setAdapter(new ArrayAdapter(Weight.this, android.R.layout.simple_list_item_1,arr));

        //sets a listener for the spinner, which triggers the 'update()' method whenever a conversion option is selected.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //sets a 'TextWatcher' for the 'EditText' component, which calls the 'update()' method when the text in the 'EditText' is changed.
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                update();
            }
        });
    }

    /*
    This method is responsible for updating the converted values based on the input value and selected conversion option.
    It performs the conversion based on the selected option and calls the 'setkm()' method to update the UI with the converted values.
     */
    private void update(){
        if(!edittext.getText().toString().equals("")&& !spinner.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble((edittext.getText().toString()));
            switch (spinner.getSelectedItem().toString()){
                case "kilogram":
                    setkm(in*1000);
                    break;
                case "hectogram":
                    setkm(in*100);
                    break;
                case "decagram":
                    setkm(in*10);
                    break;
                case "gram":
                    setkm(in);
                    break;
                case "decigram":
                    setkm(in/10);
                    break;
                case "centigram":
                    setkm(in/100);
                    break;
                case "milligram":
                    setkm(in/1000);
                    break;
            }
        }
    }

     /*This method updates the UI components with the converted values.
     It sets the corresponding values in the TextView components based on the provided input value ('km').
     */

    private void setkm(double km){
        kilogram.setText(String.valueOf(km/1000));
        hectogram.setText(String.valueOf(km/100));
        decagram.setText(String.valueOf(km/10));
        gram.setText(String.valueOf(km*1));
        decigram.setText(String.valueOf(km*10));
        centigram.setText(String.valueOf(km*100));
        milligram.setText(String.valueOf(km*1000));

    }
}
