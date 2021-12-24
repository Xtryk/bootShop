package com.codecademy.boots.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import com.codecademy.boots.enums.BootType;

@Entity
@Table(name = "BOOTS")
public class Boot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="TYPE")
    private BootType type;

    @Column(name="SIZE")
    private Float size;

    @Column(name="QUANTITY")
    private Integer quantity;

    @Column(name="MATERIAL")
    private String material;

    @Enumerated(EnumType.String)
}
    public Integer getId(){
        return this.id
    }
    public void setId(Integer idd){
        this.id = idd;
        System.out.println("Done! Id has been set to: " + this.id);
    }
    public BootType getType(){
        return this.type;
    }
    public void setType(BootType newtype){
        this.type = newtype;
    }
    public float getSize(){
        return this.size;
    }
    public void setSize(Float newSize){
        this.size = newSize;
    }
    public Integer getQuantity(){
        return this.quantity;
    }
    public void setQuantity(Integer newQuantity){
        this.quantity = newQuantity;
    }
    public String getMaterial(){
        return this.material;
    }
    public void setMaterial(String newMaterial){
        this.material = newMaterial;
        System.out.println("Done! Material has been set to: " + this.material);
    }