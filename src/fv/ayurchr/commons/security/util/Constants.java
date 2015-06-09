package fv.ayurchr.commons.security.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    //public final static String LOGIN_PAGE = "Login.jsp";

	public static final String USER_TYPE_PATIENT = "patient";
	public static final String USER_DATE_FORMAT = "yyyy-MM-dd";
	public static final String INCIDENCE_DATE_FORMAT = "MM/dd/yyyy";
	public static final int INCIDENCE_ALLOW_EDIT_UPTO_HRS = 8;
	public static Map<Float, String> SINCE_VALUES_MAP = new HashMap<Float, String>();
	public static Map<String, String> MEDICATION_VALUES_MAP = new HashMap<String, String>();
	public static Map<String, String> TAKEATTIME_VALUES_MAP = new HashMap<String, String>();
	public static String USER_SESSION_OBJ = "UserSession";
	
	static
	{
		SINCE_VALUES_MAP.put(0F, "Today Afternoon");
		SINCE_VALUES_MAP.put(0.5F, "Today Morning");
		SINCE_VALUES_MAP.put(1F, "Yesterday");
		SINCE_VALUES_MAP.put(2F, "2 Days");
		SINCE_VALUES_MAP.put(4F, "3-5 Days");
		SINCE_VALUES_MAP.put(7F, "1 Week");
		SINCE_VALUES_MAP.put(11F, "1-2 Weeks");
		SINCE_VALUES_MAP.put(75F, "2-3 Months");
		
		MEDICATION_VALUES_MAP.put("1", "Test Medication");
		MEDICATION_VALUES_MAP.put("2", "Test_1 Medication");
		MEDICATION_VALUES_MAP.put("3", "Test_2 Medication");
		MEDICATION_VALUES_MAP.put("4", "Test_3 Medication");
		
		TAKEATTIME_VALUES_MAP.put("91", "Before Breakfast");
		TAKEATTIME_VALUES_MAP.put("92", "After Breakfast");
		TAKEATTIME_VALUES_MAP.put("93", "Before Lunch");
		TAKEATTIME_VALUES_MAP.put("94", "After Lunch");
		TAKEATTIME_VALUES_MAP.put("95", "Before Dinner");
		TAKEATTIME_VALUES_MAP.put("96", "After Dinner");
		TAKEATTIME_VALUES_MAP.put("01", "00:00 AM");
		TAKEATTIME_VALUES_MAP.put("02", "01:00 AM");
		TAKEATTIME_VALUES_MAP.put("03", "02:00 AM");
		TAKEATTIME_VALUES_MAP.put("04", "03:00 AM");
		TAKEATTIME_VALUES_MAP.put("05", "04:00 AM");
		TAKEATTIME_VALUES_MAP.put("06", "05:00 AM");
		TAKEATTIME_VALUES_MAP.put("07", "06:00 AM");
		TAKEATTIME_VALUES_MAP.put("08", "07:00 AM");
		TAKEATTIME_VALUES_MAP.put("09", "08:00 AM");
		TAKEATTIME_VALUES_MAP.put("10", "09:00 AM");
		TAKEATTIME_VALUES_MAP.put("11", "10:00 AM");
		TAKEATTIME_VALUES_MAP.put("12", "11:00 AM");
		TAKEATTIME_VALUES_MAP.put("13", "12:00 AM");
		TAKEATTIME_VALUES_MAP.put("14", "1:00 PM");
		TAKEATTIME_VALUES_MAP.put("15", "2:00 PM");
		TAKEATTIME_VALUES_MAP.put("16", "3:00 PM");
		TAKEATTIME_VALUES_MAP.put("17", "4:00 PM");
		TAKEATTIME_VALUES_MAP.put("18", "5:00 PM");
		TAKEATTIME_VALUES_MAP.put("19", "6:00 PM");
		TAKEATTIME_VALUES_MAP.put("20", "7:00 PM");
		TAKEATTIME_VALUES_MAP.put("21", "8:00 PM");
		TAKEATTIME_VALUES_MAP.put("22", "9:00 PM");
		TAKEATTIME_VALUES_MAP.put("23", "10:00 PM");
		TAKEATTIME_VALUES_MAP.put("24", "11:00 PM");
	}
}