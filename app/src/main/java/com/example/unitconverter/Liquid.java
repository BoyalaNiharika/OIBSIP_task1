package com.example.unitconverter;

//import statements bring in the necessary classes from the Android framework that are used in this code.
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

public class Liquid extends AppCompatActivity {

    //declares instance variables for the different UI components used in the layout.
    EditText edittext;
    Spinner spinner;
    TextView kiloliter,hectoliter,decaliter,liter,deciliter,centiliter,milliliter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquid);

        //initialize the UI components by finding the views with their respective IDs from the layout file.
        edittext = findViewById(R.id.edittext);
        spinner = findViewById(R.id.spinner);
        kiloliter = findViewById(R.id.kiloliter);
        hectoliter = findViewById(R.id.hectoliter);
        decaliter = findViewById(R.id.decaliter);
        liter = findViewById(R.id.liter);
        deciliter = findViewById(R.id.deciliter);
        centiliter = findViewById(R.id.centiliter);
        milliliter = findViewById(R.id.milliliter);

        // sets up the 'Spinner' component with an 'ArrayAdapter' to display the available liquid volume conversion options in the dropdown menu.
        String[] arr = {"kiloliter","hectoliter","decaliter","liter","deciliter","centiliter","milliliter"};
        spinner.setAdapter(new ArrayAdapter(Liquid.this, android.R.layout.simple_list_item_1,arr));

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
                case "kiloliter":
                    setkm(in*1000);
                    break;
                case "hectoliter":
                    setkm(in*100);
                    break;
                case "decaliter":
                    setkm(in*10);
                    break;
                case "liter":
                    setkm(in);
                    break;
                case "deciliter":
                    setkm(in/10);
                    break;
                case "centiliter":
                    setkm(in/100);
                    break;
                case "milliliter":
                    setkm(in/1000);
                    break;
            }
        }
    }

    /*
    This method updates the UI components with the converted values.
     It sets the corresponding values in the TextView components based on the provided input value ('km').
     */
    private void setkm(double km){
        kiloliter.setText(String.valueOf(km/1000));
        hectoliter.setText(String.valueOf(km/100));
        decaliter.setText(String.valueOf(km/10));
        liter.setText(String.valueOf(km*1));
        deciliter.setText(String.valueOf(km*10));
        centiliter.setText(String.valueOf(km*100));
        milliliter.setText(String.valueOf(km*1000));

    }
}
