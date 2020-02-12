package com.example.arsla.clever_currency_exchange

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var fromToMultipler = 10.0 //set to 10 for debugging purposes
        var currencyFromTextView = findViewById<TextView>(R.id.currencyFrom)
        var currencyToTextView = findViewById<TextView>(R.id.currencyTo)


        //Create the From currency list here
        var currencyFrom = mutableListOf<Currency>()
        val JPY = Currency("JPY", 109.83) //VAR can change. VAL does not
        val USD = Currency("USD", 1.00)
        val RUB = Currency("RUB", 63.68)

        currencyFrom.add(JPY)
        currencyFrom.add(USD)
        currencyFrom.add(RUB)


        //Create the To currency list here
        var currencyTo = mutableListOf<Currency>()

        //Hard coded in until a large, constantly updated dataset will be found
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
        fun getMultiFromObject(currencyObject: Currency) = currencyObject.getMultiplier()

        //This is the on item selected listener. It does something when an item is selected
        spinnerFrom.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                var currencyObject = spinnerFrom.selectedItem as Currency
                fromToMultipler = getMultiFromObject(currencyObject)

            }
        }


        fun convertStringToDouble(string: String) = string.toDouble()
        fun doTheExchange (original : Double, multiplier: Double): String {
            val returnExchange = round((original/multiplier) * 100)/100
            return returnExchange.toString()
        }


        //as the user types, the currency will be automatically converted
        currencyFromTextView.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {

                var stringChanged = currencyFromTextView.text.toString().toDoubleOrNull()

                if (stringChanged != null) {
                    //stringChanged = stringChanged / fromToMultipler
                    //stringChanged = roundTwoDecimal(stringChanged)
                    //currencyToTextView.text = stringChanged.toString()

                    currencyToTextView.text = doTheExchange(stringChanged, fromToMultipler)


                } else {
                    currencyToTextView.text = null
                }

            }
        })






    }
}
