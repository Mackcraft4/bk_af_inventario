package com.paramonga.ssff.dto;

public class ScanInventarioDTO {

    private String codProducto;
    private String typeProduct;
    private String cenco;

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getCenco() {
        return cenco;
    }

    public void setCenco(String cenco) {
        this.cenco = cenco;
    }
}