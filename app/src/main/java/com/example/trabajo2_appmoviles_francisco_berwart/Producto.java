package com.example.trabajo2_appmoviles_francisco_berwart;
/**
 * Tipo producto:
 * - Automovil
 * - Mantenimiento
 * - Imprenta
 * - etc...
 * MINIMO 10!
 */

/**
 * Estados en un arreglo:
 * - Disponible
 * - Control de Calidad
 * - No Vigente
 * - En Transito
 */

public class Producto {

    private String idProd, nombreProd, tipoProd, estadoProd;


    /**
     * Constructor.
     * Crear un constructor que tenga por defeceto el arreglo con los tipos de producto.
     * Junto con el estado del producto -> esto esta en un arreglo de tipo string.
     */
    // Constructor por defecto.
    public Producto() {
        this.idProd = "1A";
        this.nombreProd = "MARK1";
        this.tipoProd = "Heavy weight body armor";
        this.estadoProd = "Disponible";
    }

    // Constructor con parametros.
    public Producto(String id, String nom, String tip, String est) {
        this.idProd = id;
        this.nombreProd = nom;
        this.tipoProd = tip;
        this.estadoProd = est;
    }


    /**
     * Metodo toString.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "idProd='" + idProd + '\'' +
                ", nombreProd='" + nombreProd + '\'' +
                ", tipoProd='" + tipoProd + '\'' +
                ", estadoProd='" + estadoProd + '\'' +
                '}';
    }

    /**
     * Metodos Setter y Getter.
     */
    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public String getEstadoProd() {
        return estadoProd;
    }

    public void setEstadoProd(String estadoProd) {
        this.estadoProd = estadoProd;
    }
}
