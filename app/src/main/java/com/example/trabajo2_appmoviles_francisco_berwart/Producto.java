package com.example.trabajo2_appmoviles_francisco_berwart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Producto extends AppCompatActivity {

    private TextView tvUserName, tvNombres;
    private Spinner spinProds;
    private AutoCompleteTextView autoProds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        // Inicializaciones
        inits();
        chargeBundles();
        Toast.makeText(this, "Ahora viene agregar solo datos de prueba :=)", Toast.LENGTH_LONG).show();
    }


    // Metodo de Inicializaciones
    private void inits() {
        // Colocar codigo de imagen de actionBar.
        // Seria choro hacer esto desde Validaciones :)

        spinProds = findViewById(R.id.spinProds);
        autoProds = findViewById(R.id.autoProds);
        tvUserName = findViewById(R.id.tvUserName);
        tvNombres = findViewById(R.id.tvNombres);
    }

    /**
     * Metodo de carga de los Bundles.
     * Las keys desde MainActivity (El login).
     * traer datos: username y nombres del usuario.
     */
    private void chargeBundles(){
        Bundle b = getIntent().getExtras();
        if(b != null){
            String userName = String.valueOf(b.get("keyUserName"));
            String userData = String.valueOf(b.get("keyData"));

            tvNombres.setText(tvNombres.getText() + " " + userData);
            tvUserName.setText(tvUserName.getText() + " " + userName);

        }
    }
}