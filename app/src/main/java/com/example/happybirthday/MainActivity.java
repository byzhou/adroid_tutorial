package com.example.happybirthday;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    public int     numberOfCoffees = 2;
    public int      orderTimes      = 0;
    public boolean toppingsAdded           ;
    public String username = "No one";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        numberOfCoffees = 2;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void increment(View view){

        orderTimes = 0;
        numberOfCoffees = numberOfCoffees + 1 ;
        display(numberOfCoffees);
        TextView thankYouTextView = (TextView) findViewById(R.id.thank_you);
        String thankYouString = "Amount due $" + numberOfCoffees * 5;
        thankYouTextView.setText(thankYouString);
        updateNumberView();
        displayName();
    }

    public void updateStatus(View view){
        displayName();
    }
    public void decrement(View view){
        orderTimes = 0;
        if (numberOfCoffees > 0) {
            numberOfCoffees = numberOfCoffees - 1;
        }

        display(numberOfCoffees);
        TextView thankYouTextView = (TextView) findViewById(R.id.thank_you);
        String thankYouString = "Amount due $" + numberOfCoffees * 5;
        thankYouTextView.setText(thankYouString);
        updateNumberView();
        displayName();
    }

    private void displayName(){
        TextView displayNameView = (TextView) findViewById(R.id.name_view);
        CheckBox checkBox = (CheckBox) findViewById(R.id.topppings_view);
        if (checkBox.isChecked()) {
            toppingsAdded = true;
        } else {
            toppingsAdded = false;
        }

        String outputMessage = "";
        if (toppingsAdded) {
            outputMessage.concat("Name:");
            outputMessage.concat(" ");
            outputMessage.concat(username);
            outputMessage.concat(" ");
            outputMessage.concat("Toppings added");
            displayNameView.setText(outputMessage);
        } else {
            outputMessage.concat("Name:");
            outputMessage.concat(" ");
            outputMessage.concat(username);
            displayNameView.setText(outputMessage);
        }

    }

    private void updateNumberView(){
        TextView quantityView = (TextView) findViewById(R.id.quantity_view);
        String quantityViewText = "Quantity: " + numberOfCoffees;
        quantityView.setText(quantityViewText);
    }

    /**
     * This method is called when the order button is clicked.
     * @param view is the view that we are going to work on
     */
    public void submitOrder(View view) {

        display(numberOfCoffees);
        EditText editText = (EditText) findViewById(R.id.edit_name_view);
        username = editText.getText().toString();
    }

    /*
      @param quantity is the input of the function
     */
    public int calculatePrice(int quantity){
        return quantity * 5;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        TextView thankYouTextView = (TextView) findViewById(R.id.thank_you);
        String thankYouString = "Thank you!";
        if (orderTimes == 0) {
            thankYouString = "Thank you!";
            orderTimes = orderTimes + 1;
        } else if (orderTimes == 1) {
            thankYouString = "That would be $" + numberOfCoffees * 5 + " bucks, dude!";
            orderTimes = orderTimes + 1;
        } else if (orderTimes == 2) {

            thankYouString = "You owe $" + numberOfCoffees * 5 + " bucks, dude!";
            orderTimes = orderTimes + 1;
        }
        thankYouTextView.setText(thankYouString);
    }

}