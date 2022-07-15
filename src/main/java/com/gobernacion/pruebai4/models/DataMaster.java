package com.gobernacion.pruebai4.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "\"TBL_MAESTRO_DATO\"")
public class DataMaster {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "\"ID\"")
    private Integer id;

    @Column(name = "\"CATEGORIA\"")
    private String category;
    
    @Column(name = "\"CODIGO\"")
    private String code;

    @Column(name = "\"DESCRIPCION\"")
    private String description;

    @Column(name = "\"VALOR_MINIMO\"")
    private String minValue;

    @Column(name = "\"VALOR_MAXIMO\"")
    private String maxvalue;

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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMinValue() {
        return minValue;
    }
    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxvalue() {
        return maxvalue;
    }

    public void setMaxvalue(String maxvalue) {
        this.maxvalue = maxvalue;
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


}
