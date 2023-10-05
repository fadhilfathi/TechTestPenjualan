package com.example.techtestpenjualan.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.techtestpenjualan.R;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView textViewProductName;
    private TextView textViewProductPrice;
    private Button buttonBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        textViewProductName = findViewById(R.id.textViewProductName);
        textViewProductPrice = findViewById(R.id.textViewProductPrice);
        buttonBuy = findViewById(R.id.buttonBuy);

        // Retrieve product details from Intent or any other data source
        String productName = getIntent().getStringExtra("productName");
        double productPrice = getIntent().getDoubleExtra("productPrice", 0.0);

        // Display product details on the screen
        textViewProductName.setText(productName);
        textViewProductPrice.setText("Price: $" + productPrice);

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the CheckoutActivity when the "Buy" button is clicked
                Intent intent = new Intent(ProductDetailActivity.this, CheckoutActivity.class);
                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                startActivity(intent);
            }
        });
    }
}

