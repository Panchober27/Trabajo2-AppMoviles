package com.example.trabajo2_appmoviles_francisco_berwart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText user, password;
    private Button btnOk, btnCancel;
    Validaciones validaciones = new Validaciones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializaciones.
        inits();
        // Listeners para los botones.
        events();
    }

    private void clickButtons(View btn) {
        if (btn.getId() == R.id.btnOk) {
            validaciones.checkEmail(user);
            validaciones.checkPassword(password);
            if (validaciones.checkEmail(user) && validaciones.checkPassword(password)) {
                Intent i = new Intent(this, ProductoActivity.class);
                i.putExtra("keyUserName", user.getText().toString());
                i.putExtra("keyData", "esto es un futuro dato extra del usuario, como nombres y apellidos.");
                startActivity(i);
            }
        }
        // Boton de Cancelar
        if (btn.getId() == R.id.btnCanel) {
            finish();
        }
    }


    private void inits() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
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