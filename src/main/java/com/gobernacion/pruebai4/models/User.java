package com.gobernacion.pruebai4.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "\"TBL_USUARIO\"")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "\"ID\"")
    private Integer id;

    @Column(name = "\"NOMBRE\"")
    private String name;
    
    @Column(name = "\"APELLIDO\"")
    private String lastName;

    @Column(name = "\"TIPO_IDENTIFICACION\"")
    private String identificationType;

    @Column(name = "\"NUMERO_IDENTIFICACION\"")
    private Integer identificationNumber;

    @Column(name = "\"CORREO\"")
    private String mail;

    @Column(name = "\"CELULAR\"")
    private Integer celPhone;

    @Column(name = "\"AZUCAR\"")
    private double sugar;

    @Column(name = "\"GRASA\"")
    private double fat;

    @Column(name = "\"OXIGENO\"")
    private double oxygen;

    @Column(name = "\"RIESGO\"")
    private String risk;

    @Column(name = "\"ESTADO\"")
    private Boolean status;

    @Column(name = "\"USUARIO_CREA\"")
    private String userCreatedAt;

    @Column(name = "\"USUARIO_ACTUALIZA\"")
    private String userUpdatedAt;
    
    @Column(name = "\"FECHA_CREACION\"")
    private Date createdAt;

    @Column(name = "\"FECHA_ACTUALIZACION\"")
    private Date updatedAt;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public Integer getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Integer identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(Integer celPhone) {
        this.celPhone = celPhone;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(String userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    public String getUserUpdatedAt() {
        return userUpdatedAt;
    }

    public void setUserUpdatedAt(String userUpdatedAt) {
        this.userUpdatedAt = userUpdatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) createdAt = new Date();
        if (this.updatedAt == null) updatedAt = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = new Date();
    }

    @PreRemove
    protected void preRemove() {
        this.updatedAt = new Date();
    }

    }
