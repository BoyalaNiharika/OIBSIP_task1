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

public class Time extends AppCompatActivity {

    //declares instance variables for the different UI components used in the layout.
    EditText edittext;
    Spinner spinner;
    TextView second,minute,hour,day,week,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        //initialize the UI components by finding the views with their respective IDs from the layout file.
        edittext = findViewById(R.id.edittext);
        spinner = findViewById(R.id.spinner);
        second = findViewById(R.id.seconds);
        minute = findViewById(R.id.minutes);
        hour = findViewById(R.id.hours);
        day = findViewById(R.id.days);
        week = findViewById(R.id.weeks);
        month = findViewById(R.id.months);
        year = findViewById(R.id.years);

        // sets up the 'Spinner' component with an 'ArrayAdapter' to display the available time volume conversion options in the dropdown menu.
        String[] arr = {"years","months","weeks","days","hours","minutes","seconds"};
        spinner.setAdapter(new ArrayAdapter(Time.this, android.R.layout.simple_list_item_1,arr));

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
                case "seconds":
                    setkm(in/3.154e+7);
                    break;
                case "minutes":
                    setkm(in/525600);
                    break;
                case "hours":
                    setkm(in/8760);
                    break;
                case "days":
                    setkm(in/365);
                    break;
                case "weeks":
                    setkm(in/52.143);
                    break;
                case "months":
                    setkm(in/12);
                    break;
                case "years":
                    setkm(in);
                    break;
            }
        }
    }

    /*This method updates the UI components with the converted values.
     It sets the corresponding values in the TextView components based on the provided input value ('km').
     */
    private void setkm(double km){
        second.setText(String.valueOf(km*3.154e+7));
        minute.setText(String.valueOf(km*525600));
        hour.setText(String.valueOf(km*8760));
        day.setText(String.valueOf(km*365));
        week.setText(String.valueOf(km*52.143));
        month.setText(String.valueOf(km*12));
        year.setText(String.valueOf(km*1));

    }
}