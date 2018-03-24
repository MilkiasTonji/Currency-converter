package com.example.milkias.currencyconverter;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


@RequiresApi(api = Build.VERSION_CODES.M)
public class Currency_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String money [] = {"USD","UERO","ETB","AUD"};
    EditText amount;
    Spinner mSpinner_from;
    Spinner mSpinner_to;
    Button convert_button;
    TextView result;
    EditText exchange_rate;

    /*
    USD - ETB = 27.29
    USD-USD = 1
    USD-UERO = 0.810543
    USD-AUD = 1.29848
    AUD-ETB = 21.2329
    EURO-ETB = 34.0160
    */

//    int white = getColor(R.color.white);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.edit_amount);
        mSpinner_from = (Spinner) findViewById(R.id.spinner_from);
        mSpinner_to = (Spinner) findViewById(R.id.spinner_to);
        convert_button = (Button) findViewById(R.id.button_convert);
        result = (TextView) findViewById(R.id.text_result);
        exchange_rate = (EditText) findViewById(R.id.edit_exchange);




        mSpinner_from.setOnItemSelectedListener(this);
        mSpinner_to.setOnItemSelectedListener(this);


        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,money);
        mSpinner_from.setAdapter(itemAdapter);
        mSpinner_to.setAdapter(itemAdapter);


        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double exchange_amount = Double.parseDouble(amount.getText().toString());

                String selectItem = String.valueOf(mSpinner_from.getSelectedItem());
                String selectedItemTwo = String.valueOf(mSpinner_to.getSelectedItem());

                if(selectItem.equals(money[0]) && selectedItemTwo.equals(money[0])){
                    Double rate = 1.0;
                    Double dollar_amount = (exchange_amount * rate);
                    result.setText(dollar_amount.toString());
                    exchange_rate.setText("Exchange rate is :" + "1");
                }

                if(selectItem.equals(money[0]) && selectedItemTwo.equals(money[1])){
                    Double rate = 0.810543;
                    Double dollar_amount = (exchange_amount * rate);
                    result.setText(dollar_amount.toString());
                    exchange_rate.setText("Exchange rate is :" + "0.810");
                }

                if(selectItem.equals(money[0]) && selectedItemTwo.equals(money[2])){
                    Double rate = 27.29;
                    Double dollar_amount = (exchange_amount * rate);
                    result.setText(dollar_amount.toString());
                    exchange_rate.setText("Exchange rate is :" + "27.29");
                }

                if(selectItem.equals(money[0]) && selectedItemTwo.equals(money[3])){
                    Double rate = 1.29848;
                    Double dollar_amount = (exchange_amount * rate);
                    result.setText(dollar_amount.toString());
                    exchange_rate.setText("Exchange rate is :" + "1.29848");
                }


                if(selectItem.equals(money[1]) && selectedItemTwo.equals(money[2])){
                    Double rate = 34.0160;
                    Double dollar_amount = (exchange_amount * rate);
                    result.setText(dollar_amount.toString());
                    exchange_rate.setText("Exchange rate is :" + "34.0160");
                }

                if(selectItem.equals(money[3]) && selectedItemTwo.equals(money[2])){
                    Double rate = 1.2329;
                    Double dollar_amount = (exchange_amount * rate);
                    result.setText(dollar_amount.toString());
                    exchange_rate.setText("Exchange rate is :" + "1.2329");
                }

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectItem = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
//        TextView textView = (TextView) findViewById(R.id.spinner_from);

    }


//        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this,
//                R.array.amount_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mSpinner_from.setAdapter(adapter);
//
//
//         ArrayAdapter<CharSequence> adapter_to = ArrayAdapter.createFromResource(this,
//                R.array.amount_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mSpinner_to.setAdapter(adapter_to);

}
