package com.paramonga.ssff.entities;

import javax.persistence.*;

@Entity
@Table(name = "VW_PRODUCTO_GENERAL")
public class ProductoGeneral {

    @Id
    @Column(name = "cod_product")
    private String codProduct;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cenco")
    private String cenco;

    public String getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(String codProduct) {
        this.codProduct = codProduct;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCenco() {
        return cenco;
    }

    public void setCenco(String cenco) {
        this.cenco = cenco;
    }
}