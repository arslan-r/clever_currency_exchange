package com.example.arsla.clever_currency_exchange

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var fromToMultipler = 10.0; //set to 10 for debugging purposes


        //Create the From currency list here
        var currencyFrom = mutableListOf<Currency>()
        val JPY = Currency( "JPY", 109.83) //VAR can change. VAL does not
        val USD = Currency("USD", 1.00)
        val RUB = Currency("RUB", 63.68)

        currencyFrom.add(JPY)
        currencyFrom.add(USD)
        currencyFrom.add(RUB)



        //Create the To currency list here
        var currencyTo = mutableListOf<Currency>()
        currencyTo.add(USD)

        //Make an adapter and link it here
        val ArrayAdapterFrom = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyFrom)
        ArrayAdapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Do the same
        val ArrayAdapterTo = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyTo)
        ArrayAdapterTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Link all of this to the activity
        spinnerFrom.adapter = ArrayAdapterFrom
        spinnerTo.adapter = ArrayAdapterTo


        //pulls the multiplier from the currency object passed in
        fun getMultiFromObject ( currencyObject: Currency) = currencyObject.getMultiplier()


        spinnerFrom.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                 //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                var currencyObject = spinnerFrom.selectedItem as Currency
                fromToMultipler = getMultiFromObject(currencyObject)

            }
        }










    }
}
