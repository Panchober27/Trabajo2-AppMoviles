package com.example.trabajo2_appmoviles_francisco_berwart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajo2_appmoviles_francisco_berwart.Validaciones;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {

    private Validaciones validaciones = new Validaciones();
    private String idProd, nombreProd, tipoProducto, estadoProducto;
    private TextView tvUserName, tvNombres;
    private TextInputEditText edIDProd, edNomProd;
    private Spinner spinProds;
    private AutoCompleteTextView autoProds;
    private Button btnAddProd, btnCancelProd;
    private String[] tipoProd = new String[10];
    private String[] estadoProd = new String[4];
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayAdapter adapterTipos, adapterEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        // Inicializaciones
        inits();
        chargeBundles();
        events();
        Toast.makeText(this, "Ahora viene agregar solo datos de prueba :=)", Toast.LENGTH_LONG).show();
    }

    // Metodo para las funciones/metodos de los distintos botones.
    private void clickButtons(View btn) {
        if (btn.getId() == R.id.btnAddProducto) {
            // Validar que los Componentes idProducto y NombreProducto se hayan ingrsado.
            validaciones.validComponent(edIDProd);
            validaciones.validComponent(edNomProd);
            if (validaciones.validComponent(edIDProd) && validaciones.validComponent(edNomProd)) {
                cleanComponents();
                Toast.makeText(this, "Se agregara un Producto!", Toast.LENGTH_LONG).show();
                // Convierto a Strings los valores de los editText.
                idProd = edIDProd.getText().toString();
                nombreProd = edNomProd.getText().toString();
                tipoProducto = "tipo 1";
                estadoProducto = "Disponible";
                productos.add(new Producto(idProd, nombreProd, tipoProducto, estadoProducto));
                // Enviar los datos => Listado de productos al LOG.
                // Quizas crear un bucle for para mostar los items del arraylist productos.
                Log.d("TAG_", "Productos: " + productos.toString());
            }


        }
        if (btn.getId() == R.id.btnCancelarProducto) {
            Toast.makeText(this, "Se Cancelo la carga de un Producto!", Toast.LENGTH_LONG).show();
        }
    }


    // Metodo de Inicializaciones
    private void inits() {
        // Colocar codigo de imagen de actionBar.
        // Seria choro hacer esto desde Validaciones :)
        edIDProd = findViewById(R.id.edIDtProducto);
        edNomProd = findViewById(R.id.edNombreProducto);
        spinProds = findViewById(R.id.spinProds);
        autoProds = findViewById(R.id.autoProds);
        tvUserName = findViewById(R.id.tvUserName);
        tvNombres = findViewById(R.id.tvNombres);
        btnAddProd = findViewById(R.id.btnAddProducto);
        btnCancelProd = findViewById(R.id.btnCancelarProducto);
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


    // Metodo para asiganr los listners a los botones.
    private void events() {
        btnAddProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButtons(v);
            }
        });
        btnCancelProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButtons(v);
            }
        });
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


    // Metodo para limpiar los componentes.
    private void cleanComponents() {
        edIDProd.setText("");
        edNomProd.setText("");
    }


    // Metodo para cargar los arrays de Estados y Tipos
    private void chargeArrays() {
        estadoProd = new String[]{"Disponible", "Control de Calida", "No Vigente", "En Transito"};
        tipoProd = new String[]{"tipo 1", "tipo 2", "tipo 3", "tipo 4", "tipo 5", "tipo 6", "tipo 7", "tipo 8", "tipo 9", "tipo 10"};
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