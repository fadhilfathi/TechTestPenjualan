package com.example.techtestpenjualan.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.techtestpenjualan.R;

public class CheckoutActivity extends AppCompatActivity {

    private TextView textViewProductName;
    private TextView textViewProductPrice;
    private Button buttonCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        textViewProductName = findViewById(R.id.textViewProductNameCheckout);
        textViewProductPrice = findViewById(R.id.textViewProductPriceCheckout);
        buttonCheckout = findViewById(R.id.buttonCheckout);

        // Retrieve product details passed from ProductDetailActivity
        String productName = getIntent().getStringExtra("productName");
        double productPrice = getIntent().getDoubleExtra("productPrice", 0.0);

        // Display product details on the checkout screen
        textViewProductName.setText("Product Name: " + productName);
        textViewProductPrice.setText("Price: $" + productPrice);

        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the checkout logic here
                // You can proceed with the payment process or any other actions
                // For example, you can display a purchase confirmation message
                showPurchaseConfirmation();
            }
        });
    }

    private void showPurchaseConfirmation() {
        // Display a confirmation message to the user
        // You can use a dialog, a toast, or navigate to a confirmation page
        // Example: Toast.makeText(this, "Purchase successful!", Toast.LENGTH_SHORT).show();
    }
}
