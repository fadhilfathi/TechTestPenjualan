package com.example.techtestpenjualan.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techtestpenjualan.ProductAdapter;
import com.example.techtestpenjualan.R;
import com.example.techtestpenjualan.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerView = findViewById(R.id.recyclerViewProductList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Initialize your product list (replace this with your actual product data)
        productList = new ArrayList<>();
        productList.add(new Product("Product 1", 10.99));
        productList.add(new Product("Product 2", 15.99));
        productList.add(new Product("Product 3", 7.99));

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }
}
