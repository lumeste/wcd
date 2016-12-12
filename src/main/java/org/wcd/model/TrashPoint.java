package org.wcd.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection="trashPoint")
@TypeAlias("TrashPoint")
public class TrashPoint {

    @Id
    private BigInteger id;
    private String name;
    private String trashAmount;
    private String trashType;
    private String formattedAddress;
    private Integer postalCode;
    private Float locationLatitude;
    private Float locationLongitude;

    public TrashPoint() {
    }

    public TrashPoint(BigInteger id, String name, String trashAmount, String trashType, String formattedAddress, Integer postalCode, Float locationLatitude, Float locationLongitude) {
        this.id = id;
        this.name = name;
        this.trashAmount = trashAmount;
        this.trashType = trashType;
        this.formattedAddress = formattedAddress;
        this.postalCode = postalCode;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrashAmount() {
        return trashAmount;
    }

    public void setTrashAmount(String trashAmount) {
        this.trashAmount = trashAmount;
    }

    public String getTrashType() {
        return trashType;
    }

    public void setTrashType(String trashType) {
        this.trashType = trashType;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Float getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Float locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public Float getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Float locationLongitude) {
        this.locationLongitude = locationLongitude;
    }







}

