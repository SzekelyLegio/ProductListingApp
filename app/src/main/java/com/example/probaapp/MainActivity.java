package com.example.probaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText searchProduct;
    public Button searchButton;
    public Button validateButton;
    public Button exitButton;
    public Button OkButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = (Button) findViewById(R.id.search_Button);
        validateButton = (Button) findViewById(R.id.validate_Button);
        OkButton =(Button) findViewById(R.id.success_button);
        exitButton = (Button) findViewById(R.id.cancel_button);
        searchProduct = (EditText) findViewById(R.id.editId);
        validateButton.setEnabled(false);
        OkButton.setEnabled(false);
        searchProduct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals("")) {
                    validateButton.setEnabled(false);
                    OkButton.setEnabled(false);

                }
                else {
                    validateButton.setEnabled(true);
                    OkButton.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openSearchActivity();
                }
            });

            exitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                ResendActivity();
                }
            });

    }
    public void openSearchActivity(){
        Intent intent = new Intent(this, listProductActivity.class);
        startActivity(intent);
    }
    public void ResendActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
