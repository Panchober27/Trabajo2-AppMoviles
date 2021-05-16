package com.example.trabajo2_appmoviles_francisco_berwart;


import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

    public Validaciones() {

    }

    // Metodo para validar el componente de la password.
    public boolean checkPassword(TextInputEditText param) {
        String strPar = param.getText().toString();
        if (!strPar.isEmpty()) {
            return true;
        } else {
            param.setError("Campo Vacio!");
            return false;
        }

    }

    // Metodo para validar que Componente no este vacio.
    public boolean checkEmail(TextInputEditText param) {
        String strPar = param.getText().toString();
        if (!strPar.isEmpty()) {
            if (validarEmail(strPar)) {
                return true;
            } else {
                param.setError("Username debe ser Email!");
                return false;
            }
        } else {
            param.setError("Campo Vacio");
            return false;
        }
    }

    public static boolean validarEmail(String email) {
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher match = pat.matcher(email);
        return match.find();
    }// Fin del Metodo

    public static boolean validComponent(TextInputEditText param) {
        String strPar = param.getText().toString();
        if (!strPar.isEmpty()) {
            return true;
        } else {
            param.setError("Campo Vacio!");
            return false;
        }
    }


}
