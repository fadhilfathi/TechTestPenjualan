package com.example.techtestpenjualan;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PenjualanDatabase.db";
    public static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    private static final String DEFAULT_ADMIN_USERNAME = "admin";
    private static final String DEFAULT_ADMIN_PASSWORD = "admin";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT);";

    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_PRODUCT_CODE = "product_code";
    private static final String COLUMN_PRODUCT_NAME = "product_name";
    private static final String COLUMN_PRICE_PRODUCTS = "price"; // Use a unique name
    private static final String COLUMN_CURRENCY = "currency";
    private static final String COLUMN_DISCOUNT = "discount";
    private static final String COLUMN_DIMENSION = "dimension";
    private static final String COLUMN_UNIT_PRODUCTS = "unit"; // Use a unique name

    private static final String CREATE_PRODUCTS_TABLE =
            "CREATE TABLE " + TABLE_PRODUCTS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT_CODE + " TEXT, " +
                    COLUMN_PRODUCT_NAME + " TEXT, " +
                    COLUMN_PRICE_PRODUCTS + " INTEGER, " + // Use the unique name
                    COLUMN_CURRENCY + " TEXT, " +
                    COLUMN_DISCOUNT + " INTEGER, " +
                    COLUMN_DIMENSION + " TEXT, " +
                    COLUMN_UNIT_PRODUCTS + " TEXT);"; // Use the unique name

    private static final String TABLE_TRANSACTION_HEADER = "transaction_header";
    private static final String COLUMN_DISCOUNT_CODE = "discount_code";
    private static final String COLUMN_DISCOUNT_NUMBER = "discount_number";
    private static final String COLUMN_USER = "user";
    private static final String COLUMN_TOTAL = "total";
    private static final String COLUMN_DATE = "date";

    private static final String CREATE_TRANSACTION_HEADER_TABLE =
            "CREATE TABLE " + TABLE_TRANSACTION_HEADER + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DISCOUNT_CODE + " TEXT, " +
                    COLUMN_DISCOUNT_NUMBER + " TEXT, " +
                    COLUMN_USER + " TEXT, " +
                    COLUMN_TOTAL + " NUMERIC, " +
                    COLUMN_DATE + " DATE);";

    private static final String TABLE_TRANSACTION_DETAIL = "transaction_detail";
    private static final String COLUMN_DOCUMENT_CODE = "document_code";
    private static final String COLUMN_DOCUMENT_NUMBER = "document_number";
    private static final String COLUMN_PRODUCT_CODE_TRANSACTION = "product_code"; // Changed name to COLUMN_PRODUCT_CODE_TRANSACTION
    private static final String COLUMN_PRICE_TRANSACTION = "price"; // Changed name to COLUMN_PRICE_TRANSACTION
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_UNIT_TRANSACTION = "unit"; // Changed name to COLUMN_UNIT_TRANSACTION
    private static final String COLUMN_SUB_TOTAL = "sub_total";
    private static final String COLUMN_CURRENCY_TRANSACTION = "currency"; // Changed name to COLUMN_CURRENCY_TRANSACTION

    private static final String CREATE_TRANSACTION_DETAIL_TABLE =
            "CREATE TABLE " + TABLE_TRANSACTION_DETAIL + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DOCUMENT_CODE + " TEXT, " +
                    COLUMN_DOCUMENT_NUMBER + " TEXT, " +
                    COLUMN_PRODUCT_CODE_TRANSACTION + " TEXT, " +
                    COLUMN_PRICE_TRANSACTION + " INTEGER, " +
                    COLUMN_QUANTITY + " INTEGER, " +
                    COLUMN_UNIT_TRANSACTION + " TEXT, " +
                    COLUMN_SUB_TOTAL + " INTEGER, " +
                    COLUMN_CURRENCY_TRANSACTION + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(CREATE_PRODUCTS_TABLE);
        db.execSQL(CREATE_TRANSACTION_HEADER_TABLE);
        db.execSQL(CREATE_TRANSACTION_DETAIL_TABLE); // Membuat tabel "transaction_detail"
        insertDefaultAdminUser(db);
        insertDummyProducts(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION_HEADER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION_DETAIL);
        onCreate(db);
    }

    private void insertDefaultAdminUser(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, DEFAULT_ADMIN_USERNAME);
        values.put(COLUMN_PASSWORD, DEFAULT_ADMIN_PASSWORD);

        // Insert the values into the 'users' table
        db.insert(TABLE_NAME, null, values);
    }

    private void insertDummyProducts(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        // Dummy Product 1
        values.put(COLUMN_PRODUCT_CODE, "P001");
        values.put(COLUMN_PRODUCT_NAME, "Product 1");
        values.put(COLUMN_PRICE_PRODUCTS, 10); // Use the unique name
        values.put(COLUMN_CURRENCY, "USD");
        values.put(COLUMN_DISCOUNT, 0);
        values.put(COLUMN_DIMENSION, "10x10");
        values.put(COLUMN_UNIT_PRODUCTS, "pcs"); // Use the unique name
        db.insert(TABLE_PRODUCTS, null, values);

        // Dummy Product 2
        values.clear();
        values.put(COLUMN_PRODUCT_CODE, "P002");
        values.put(COLUMN_PRODUCT_NAME, "Product 2");
        values.put(COLUMN_PRICE_PRODUCTS, 20); // Use the unique name
        values.put(COLUMN_CURRENCY, "USD");
        values.put(COLUMN_DISCOUNT, 5);
        values.put(COLUMN_DIMENSION, "15x15");
        values.put(COLUMN_UNIT_PRODUCTS, "pcs"); // Use the unique name
        db.insert(TABLE_PRODUCTS, null, values);

        // Add more dummy products as needed
    }

}

