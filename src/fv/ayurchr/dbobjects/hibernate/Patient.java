package fv.ayurchr.dbobjects.hibernate;

import java.sql.Date;

/**
 * Created by Ravish Patel.
 * fv.ayurchr.dbobjects.hibernate.User: ravish
 * Date: 1/5/11
 * Time: 11:09 AM
 */
public class Patient {
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private long Id;
    private Date DateOfBirth;
    private String Identification;
    private String Address_Street;
    private String Address_HouseNo;
    private String Address_Community;
    private String Address_City;
    private String Address_District;
    private String Address_State;
    private int Address_PinCode;
    private String PhoneNumber;
    private String PhoneNumber_Emergency;
    private String Address_Country;
    public static String ENTITY = "PATIENT";

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getIdentification() {
        return Identification;
    }

    public void setIdentification(String identification) {
        Identification = identification;
    }

    public String getAddress_Street() {
        return Address_Street;
    }

    public void setAddress_Street(String address_Street) {
        Address_Street = address_Street;
    }

    public String getAddress_HouseNo() {
        return Address_HouseNo;
    }

    public void setAddress_HouseNo(String address_HouseNo) {
        Address_HouseNo = address_HouseNo;
    }

    public String getAddress_Community() {
        return Address_Community;
    }

    public void setAddress_Community(String address_Community) {
        Address_Community = address_Community;
    }

    public String getAddress_City() {
        return Address_City;
    }

    public void setAddress_City(String address_City) {
        Address_City = address_City;
    }

    public String getAddress_District() {
        return Address_District;
    }

    public void setAddress_District(String address_District) {
        Address_District = address_District;
    }

    public String getAddress_State() {
        return Address_State;
    }

    public void setAddress_State(String address_State) {
        Address_State = address_State;
    }

    public int getAddress_PinCode() {
        return Address_PinCode;
    }

    public void setAddress_PinCode(int address_PinCode) {
        Address_PinCode = address_PinCode;
    }

    public String getAddress_Country() {
        return Address_Country;
    }

    public void setAddress_Country(String address_Country) {
        Address_Country = address_Country;
    }

    public void update() throws Exception {
        // fv.ayurchr.commons.fv.ayurchr.commons.HibernateSession.update(this);
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber_Emergency() {
        return PhoneNumber_Emergency;
    }

    public void setPhoneNumber_Emergency(String phoneNumber_Emergency) {
        PhoneNumber_Emergency = phoneNumber_Emergency;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    //@Override
    public String getAddress() {
        return (Address_HouseNo + "#" + Address_Community + ",\n"
                + Address_Street + ",\n" + Address_City + ", " + Address_District + ",\n"
                + Address_State + " - " + Address_PinCode);
    }
}
