package com.paramonga.ssff.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AF_REGIS_INVENTARIO_PBA")
public class AfRegisInventarioPba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inv")
    private Long idInv;

    @Column(name = "cod_product")
    private String codProduct;

    @Column(name = "type_product")
    private String typeProduct;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "observation")
    private String observation;

    @Column(name = "cod_marca")
    private String codMarca;

    @Column(name = "nro_serie")
    private String nroSerie;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "cenco")
    private String cenco;

    @Column(name = "hour")
    private LocalDateTime hour;

    @Column(name = "estado_validacion")
    private Integer estadoValidacion;

    @PrePersist
    public void prePersist() {
        this.hour = LocalDateTime.now();
    }

    public Long getIdInv() {
        return idInv;
    }

    public void setIdInv(Long idInv) {
        this.idInv = idInv;
    }

    public String getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(String codProduct) {
        this.codProduct = codProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCenco() {
        return cenco;
    }

    public void setCenco(String cenco) {
        this.cenco = cenco;
    }

    public LocalDateTime getHour() {
        return hour;
    }

    public void setHour(LocalDateTime hour) {
        this.hour = hour;
    }

    public Integer getEstadoValidacion() {
        return estadoValidacion;
    }

    public void setEstadoValidacion(Integer estadoValidacion) {
        this.estadoValidacion = estadoValidacion;
    }

}