package fv.ayurchr.commons.taglib.html;

import fv.ayurchr.commons.HibernateSession;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


public class ComboBox extends DOM {

    private String EntityName;
    private Class ClassName;
    private String FilterValueName;
    private String DisplayValue;
    private String FilterName;
    private String FilterValue;

    private static StringBuffer startTag = new StringBuffer("<option ");
    private static StringBuffer startSelectedTag = new StringBuffer("<option selected ");
    private static StringBuffer endTag = new StringBuffer("</option>");


    public ComboBox(String p_Label, String p_VariableName) {
        super(p_Label, p_VariableName);
        super.setDojoType("FilteringSelect");
    }

    public ComboBox(HashMap<String, String> p_XMLMap) throws Exception {

        super.setDojoType("FilteringSelect");

        setLabel(p_XMLMap.get("LABEL"));
        setVariableName(p_XMLMap.get("ID"));
        if (p_XMLMap.containsKey("REQUIRED")) {
            setRequired(Boolean.valueOf(p_XMLMap.get("REQUIRED")));
        }
        if (p_XMLMap.containsKey("CLASS")) {
            setClassName(Class.forName(p_XMLMap.get("CLASS")));
        }
        if (p_XMLMap.containsKey("ENTITY")) {
            setEntityName(p_XMLMap.get("ENTITY"));
        }
        if (p_XMLMap.containsKey("FILTER_VALUE")) {
            setFilterValueName(p_XMLMap.get("FILTER_VALUE"));
        }
        if (p_XMLMap.containsKey("DISPLAY_VALUE")) {
            setDisplayValue(p_XMLMap.get("DISPLAY_VALUE"));
        }
        if (p_XMLMap.containsKey("VALUE")) {
            setValue(p_XMLMap.get("VALUE"));
        }
        if (p_XMLMap.containsKey("READONLY")) {
            setDisabled(Boolean.valueOf(p_XMLMap.get("READONLY")));
        }

    }

    private ComboBox() {

    }

    public String toDom() throws Exception {
    	String ComboValues = "";
    	if(EntityName != null) {
    		ComboValues = getComboValues(EntityName, ClassName, FilterValueName, Value, DisplayValue, FilterName, FilterValue).toString();
    	}
        return getLabelValue()
                + "<select dojoType='dijit.form.FilteringSelect' style='width:" + Width + ";' required=" + Required
                + " Readonly=" + Disabled + " id='" + VariableName + "' name='" + VariableName + "' " + InnerHTML + ">"
                + ComboValues
                + "</select>";
    }
//return jspPrint();

    private StringBuffer getComboValues(String p_EntityName, Class p_ClassName, String p_ValueName, String p_Value,
                                        String p_DisplayValue, String p_FilterName, String p_FilterValue) throws Exception {
        StringBuffer combo = new StringBuffer();

        fv.ayurchr.commons.HibernateSession hs = new HibernateSession();
        List l;
        if (null == p_FilterName)
            l = hs.getList(p_EntityName, -1);
        else
            l = hs.getList(p_EntityName, p_FilterName, p_FilterValue);
        String currentValue;
        String currentDisplayValue;
        Method valueMethod = p_ClassName.getMethod("get" + p_ValueName);
        Method displayMethod = p_ClassName.getMethod("get" + p_DisplayValue);
        Object currentObject;
        int MaxLen = 0;
        int CurrLen = 0;
        if (null != l && l.size() > 0)
            for (int i = 0; i < l.size(); i++) {
                currentObject = l.get(i);
                currentValue = String.valueOf(valueMethod.invoke(currentObject));
                currentDisplayValue = String.valueOf(displayMethod.invoke(currentObject));
                if (currentValue.equals(p_Value))
                    combo.append(startSelectedTag);
                else
                    combo.append(startTag);
                combo.append(" value='").append(currentValue).append("'>");
                CurrLen = currentDisplayValue.length();
                MaxLen = MaxLen > CurrLen ? MaxLen : CurrLen;
                combo.append(currentDisplayValue).append(endTag);
            }
        Width = (MaxLen * 11) + 10;

        return combo;

    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }

    public Class getClassName() {
        return ClassName;
    }

    public void setClassName(Class aClass) {
        ClassName = aClass;
    }

    public String getFilterValueName() {
        return FilterValueName;
    }

    public void setFilterValueName(String filterValueName) {
        FilterValueName = filterValueName;
    }

    public String getDisplayValue() {
        return DisplayValue;
    }

    public void setDisplayValue(String displayValue) {
        DisplayValue = displayValue;
    }

    public String getFilterName() {
        return FilterName;
    }

    public void setFilterName(String filterName) {
        FilterName = filterName;
    }

    public String getFilterValue() {
        return FilterValue;
    }

    public void setFilterValue(String filterValue) {
        FilterValue = filterValue;
    }
}
