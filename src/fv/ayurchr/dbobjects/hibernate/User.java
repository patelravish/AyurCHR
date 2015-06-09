package fv.ayurchr.dbobjects.hibernate;

import java.util.Date;

import fv.ayurchr.commons.SV;
import fv.ayurchr.commons.security.util.EncryptionUtil;

/**
 * Created by Ravish Patel.
 * fv.ayurchr.dbobjects.hibernate.User: ravish
 * Date: 1/5/11
 * Time: 6:06 PM
 */


public class User {
    private String LoginId = "";
    private String FirstName = "";
    private String LastName = "";
    private String MiddleName = "";
    private String password = "";
    private long Id = 1;
    private Date DateOfBirth;
    private String Type = "";
    private long RoleId = -1;
    private Role Role;
    private String Identification;
    private String Address_Street;
    private String Address_HouseNo;
    private String Address_Community;
    private String Address_City;
    private String Address_District;
    private String Address_State;
    private long Address_PinCode = 0;
    private String PhoneNumber;
    private String PhoneNumber_Emergency;
    private String Address_Country;
    public static final String CENTITY = "CUSER";
    public static final String ENTITY = "USER";

    public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		if(null==loginId)
            LoginId = "Patient";
        LoginId = loginId;
	}

	public long getRoleId() {
        return RoleId;
    }

    public void setRoleId(long roleId) {
        RoleId = roleId;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

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

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws Exception{
        if(null!=password )
        if(password.length()==28 && password.indexOf('=')==27)
            this.password = password;
        else
		    this.password = EncryptionUtil.encryptString(password, SV.ENCRYPT_ALGORITHM);
	}

	public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
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

	public long getAddress_PinCode() {
		return Address_PinCode;
	}

	public void setAddress_PinCode(long address_PinCode) {
		Address_PinCode = address_PinCode;
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

	public String getAddress_Country() {
		return Address_Country;
	}

	public void setAddress_Country(String address_Country) {
		Address_Country = address_Country;
	}

	public void update() throws Exception {
        //fv.ayurchr.commons.fv.ayurchr.commons.HibernateSession.update(this);
    }

    @Override
    public String toString() {
        return "fv.ayurchr.dbobjects.hibernate.User{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Id=" + Id +
                ", Type='" + Type + '\'' +
                ", RoleId=" + RoleId +
                ", fv.ayurchr.dbobjects.hibernate.Role=" + Role +
                '}';
    }
}
