package com.example.trabajo2_appmoviles_francisco_berwart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText user, password;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializaciones.
        inits();
        // Listeners para los botones.
        events();
    }

    private void clickButtons(View btn){
        if(btn.getId() == R.id.btnOk){
            Toast.makeText(this,"Ahora Validaciones",Toast.LENGTH_LONG).show();
        }

        if(btn.getId() == R.id.btnCanel){
            finish();
        }
    }



    private void inits() {
        user = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCanel);
    }


    private void events() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButtons(v);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButtons(v);
            }
        });
    }


}