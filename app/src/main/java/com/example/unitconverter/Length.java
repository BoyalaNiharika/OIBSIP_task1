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

public class Length extends AppCompatActivity {
    //variables
    EditText edittext;
    Spinner spinner;
    TextView kilometer,hectometer,decameter,meter,decimeter,centimeter,millimeter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        //initialize the UI components by finding the views with their respective IDs from the layout file.
        edittext = findViewById(R.id.edittext);
        spinner = findViewById(R.id.spinner);
        kilometer = findViewById(R.id.kilometer);
        hectometer = findViewById(R.id.hectometer);
        decameter = findViewById(R.id.decameter);
        meter = findViewById(R.id.meter);
        decimeter = findViewById(R.id.decimeter);
        centimeter = findViewById(R.id.centimeter);
        millimeter = findViewById(R.id.millimeter);

        //sets up the 'Spinner' component with an 'ArrayAdapter' to display the available length conversion options in the dropdown menu.
        String[] arr = {"kilometer","hectometer","decameter","meter","decimeter","centimeter","millimeter"};
        spinner.setAdapter(new ArrayAdapter(Length.this, android.R.layout.simple_list_item_1,arr));

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
    It checks if the input value and conversion option are not empty,
    converts the input value to a double, and performs the corresponding conversion based on the selected option.
    The setkm() method is called to update the UI with the converted values.
    */
    private void update(){
        if(!edittext.getText().toString().equals("")&& !spinner.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble((edittext.getText().toString()));
            switch (spinner.getSelectedItem().toString()){
                case "kilometer":
                    setkm(in*1000);
                    break;
                case "hectometer":
                    setkm(in*100);
                    break;
                case "decameter":
                    setkm(in*10);
                    break;
                case "meter":
                    setkm(in);
                    break;
                case "decimeter":
                    setkm(in/10);
                    break;
                case "centimeter":
                    setkm(in/100);
                    break;
                case "millimeter":
                    setkm(in/1000);
                    break;
            }
        }
    }

    /*
    This method updates the UI components with the converted values.
    It sets the corresponding values in the 'TextView' components based on the provided input value ('km').
     */
    private void setkm(double km){
        kilometer.setText(String.valueOf(km/1000));
        hectometer.setText(String.valueOf(km/100));
        decameter.setText(String.valueOf(km/10));
        meter.setText(String.valueOf(km*1));
        decimeter.setText(String.valueOf(km*10));
        centimeter.setText(String.valueOf(km*100));
        millimeter.setText(String.valueOf(km*1000));

    }
}




