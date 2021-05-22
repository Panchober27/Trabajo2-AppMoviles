package com.example.trabajo2_appmoviles_francisco_berwart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        // Metodo con los listeners
        //adapterComponentsListeners();
        events();
        Toast.makeText(this, "Ahora viene agregar solo datos de prueba :=)", Toast.LENGTH_LONG).show();
    }

    // Metodo para las funciones/metodos de los distintos botones.
    private void clickButtons(View btn) {
        if (btn.getId() == R.id.btnAddProducto) {
            // Vaciar el LOG_D para mandar la lista actualizada. ??????
            // Validar que los Componentes idProducto y NombreProducto se hayan ingrsado.

            // Tambien validar que el AutoCompleteTextView no este vacio!!!!
            // Despues generar un titulo y validacion más toda la logica para un spinner adecuado!.

            validaciones.validComponent(edIDProd);
            validaciones.validComponent(edNomProd);
            if (validaciones.validComponent(edIDProd) && validaciones.validComponent(edNomProd)) {
                if (findProductById(edIDProd.getText().toString())) {
                    // Update
                    updateProduct(edIDProd.getText().toString());
                    cleanComponents();
                    Toast.makeText(ProductoActivity.this, "SE MODIFICA PRODUCTO", Toast.LENGTH_LONG).show();
                } else {
                    addProduct();
                }
            }
        }
        if (btn.getId() == R.id.btnCancelarProducto) {
            finish();
        }
    }


    // Metodo de Inicializaciones
    private void inits() {
        // Colocar codigo de imagen de actionBar.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        edIDProd = findViewById(R.id.edIDtProducto);
        edNomProd = findViewById(R.id.edNombreProducto);
        spinProds = findViewById(R.id.spinProds);
        autoProds = findViewById(R.id.autoProds);
        tvUserName = findViewById(R.id.tvUserName);
        tvNombres = findViewById(R.id.tvNombres);
        btnAddProd = findViewById(R.id.btnAddProducto);
        btnCancelProd = findViewById(R.id.btnCancelarProducto);
        /**
         * En cuanto a los adapter, creo que tendre que hacer mas de 1, para pasar distintos arrays a los
         */
        chargeArrays();
        adapterEstados = new ArrayAdapter(this, android.R.layout.simple_list_item_1, estadoProd);
        adapterTipos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tipoProd);
        spinProds.setAdapter(adapterEstados);
        autoProds.setAdapter(adapterTipos);
        // Le asigno desde que caracter va a buscar las coincidencias.
        autoProds.setThreshold(1);
        componentsListeners();

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
        autoProds.setText("");
    }


    // Metodo para cargar los arrays de Estados y Tipos
    private void chargeArrays() {
        estadoProd = new String[]{"Disponible", "Control de Calidad", "No Vigente", "En Transito"};
        tipoProd = new String[]{
                "Alimentos",
                "Automoviles",
                "Servicios",
                "Containers",
                "Compras",
                "Consumo",
                "Coleccionables",
                "Industrial",
                "Ingenería",
                "Suscripcipón",
        };
    }


    // Metodos para los listeners del Spinner y el AutoCompleteTextView
    private void componentsListeners() {
        spinProds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object object = parent.getItemAtPosition(position);
                String estP = object.toString();
                estadoProducto = estP;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Obtener el Producto.
        autoProds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Castear a Array de productos.
                Object itemSel = parent.getItemAtPosition(position);
                String tp = itemSel.toString();  // tp => tipo de producto con
                tipoProducto = tp;
            }
        });
        edIDProd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                findProductById(s.toString());
            }
        });
    }


    private void updateProduct(String id) {
        for (int i = 0; i < productos.size(); i++) {
            if(id.equals(productos.get(i).getIdProd())){
                productos.get(i).setNombreProd(edNomProd.getText().toString());
                productos.get(i).setTipoProd(autoProds.getText().toString());
                productos.get(i).setEstadoProd(estadoProducto);
                Log.d("TAG_", "updateProduct: " + productos.get(i).toString());
            }
        }
    }


    private void addProduct() {
        idProd = edIDProd.getText().toString();
        nombreProd = edNomProd.getText().toString();
        productos.add(new Producto(idProd, nombreProd, tipoProducto, estadoProducto));
        for (int i = 0; i < productos.size(); i++) {
            Log.d("TAG_", "..  \n" +
                    "Producto " + (i + 1)
                    + ": \n"
                    + productos.get(i).toString());
            Log.d("TAG_", "");
            Log.d("TAG_", "");
        }
        cleanComponents();
    }


    private boolean findProductById(String param) {
        boolean var = false;
        if (productos.size() >= 1) {
            for (int i = 0; i < productos.size(); i++) {
                if (param.equals(productos.get(i).getIdProd())) { // SI EXISTE
                    edNomProd.setText(productos.get(i).getNombreProd());
                    autoProds.setText(productos.get(i).getTipoProd());
                    int position = 0;
                    String estado = productos.get(i).getEstadoProd();
                    if (estado.equals("Disponible")) {
                        position = 0;
                    } else if (estado.equals("Control de Calidad")) {
                        position = 1;
                    } else if (estado.equals("No Vigente")) {
                        position = 2;
                    } else if (estado.equals("En Transito")) {
                        position = 3;
                    }
                    spinProds.setSelection(position);
                    var = true;
                    // SPinner !!!!!!!!!!!
                }
            }
        } else {
            var = false;
        }
        return var;
    }


}