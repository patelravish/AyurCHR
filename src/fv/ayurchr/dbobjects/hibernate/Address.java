package fv.ayurchr.dbobjects.hibernate;


import java.sql.Timestamp;

public class Address {
    private long Id = -1;
    private String Address = "";
    private String Street = "";
    private String Area = "";
    private String City = "";
    private String State = "";
    private int AreaCode = -1;
    private Timestamp UpdateDate = null;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public Timestamp getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        UpdateDate = updateDate;
    }

    public static final String CENTITY = "CADDRESS";
    public static final String ENTITY = "ADDRESS";
}