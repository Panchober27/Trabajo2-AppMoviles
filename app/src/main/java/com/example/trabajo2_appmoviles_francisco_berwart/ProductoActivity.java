package com.example.trabajo2_appmoviles_francisco_berwart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {

    private TextView tvUserName, tvNombres;
    private Spinner spinProds;
    private AutoCompleteTextView autoProds;
    private String[] tipoProd = new String[10];
    private String[] estadoProd = new String[4];
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayAdapter adapter, adapterTipos, adapterEstados;

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
        //chargeProdsList();
        //adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, productos);
        //spinProds.setAdapter(adapter);
        //autoProds.setAdapter(adapter);
        /**
         * En cuanto a los adapter, creo que tendre que hacer mas de 1, para pasar distintos arrays a los
         */
        chargeArrays();
        adapterEstados = new ArrayAdapter(this, android.R.layout.simple_list_item_1, estadoProd);
        adapterTipos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tipoProd);
        spinProds.setAdapter(adapterEstados);
        autoProds.setAdapter(adapterTipos);

    }

    /**
     * Metodo de carga de los Bundles.
     * Las keys desde MainActivity (El login).
     * traer datos: username y nombres del usuario.
     */
    private void chargeBundles() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            String userName = String.valueOf(b.get("keyUserName"));
            String userData = String.valueOf(b.get("keyData"));

            tvNombres.setText(tvNombres.getText() + " " + userData);
            tvUserName.setText(tvUserName.getText() + " " + userName);

        }
    }


    // Metodo para cargar la lista de productos.
    private void chargeProdsList() {
        productos.add(new Producto("1A", "MARK1", "War Machine", "Disponible"));
        productos.add(new Producto("2A", "MARK12", "War Machine", "Disponible"));
        productos.add(new Producto("3A", "MARK15", "War Machine", "No Vigente"));
        productos.add(new Producto("4A", "MARK22", "War Machine", "En Transito"));
        // en el futuro se ingresaran mas demos de producto.
    }

    // Metodo para cargar los arrays de Estados y Tipos
    private void chargeArrays() {
        estadoProd = new String[]{"Disponible", "Control de Calida", "No Vigente", "En Transito"};
        tipoProd = new String[]{"tipo 1","tipo 2","tipo 3","tipo 4","tipo 5","tipo 6","tipo 7","tipo 8","tipo 9","tipo 10"};
    }


    // Metodo para aplicar el Adapter a el spinner y al autoCompleteTextView
    // OJO que con el autoCompleteTextView se debe realizar una busqueda en base a la 3era coincidencia!
    // revisar eso!!!...
    private void adapterComponentsListeners() {
        spinProds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


}