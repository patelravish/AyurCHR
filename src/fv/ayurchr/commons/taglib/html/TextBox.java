package fv.ayurchr.commons.taglib.html;

import java.sql.Date;
import java.util.HashMap;

public class TextBox extends DOM {

    public TextBox(String p_Label, String p_VariableName) {
        super(p_Label, p_VariableName);
    }

    TextBox() {

    }

    public TextBox(HashMap<String, String> p_XMLMap) {

       initializeObject(p_XMLMap,false);
    
    }
    
    public TextBox(HashMap<String, String> p_XMLMap, boolean isPassword) {

        initializeObject(p_XMLMap,true);
    }

    private void initializeObject(HashMap<String, String> p_XMLMap, boolean isPassword)
    {
        setLabel(p_XMLMap.get("LABEL"));
        setVariableName(p_XMLMap.get("ID"));
        if (p_XMLMap.containsKey("REQUIRED")) {
            setRequired(Boolean.valueOf(p_XMLMap.get("REQUIRED")));
        }
        if (p_XMLMap.containsKey("WIDTH")) {
            setWidth(Integer.parseInt(p_XMLMap.get("WIDTH")));
        }
        if (p_XMLMap.containsKey("VALUE")) {
            setValue(p_XMLMap.get("VALUE"));
        }
        if (p_XMLMap.containsKey("INNERHTML")) {
            setInnerHTML(p_XMLMap.get("INNERHTML"));
        }
        if(isPassword)
        {
        	setPassword(true);
        }

        if (p_XMLMap.containsKey("VALUE")) {
            setValue(p_XMLMap.get("VALUE"));
        }
        if (p_XMLMap.containsKey("READONLY")) {
            setDisabled(Boolean.valueOf(p_XMLMap.get("READONLY")));
        }

    }

    public String toDom() {
        if ("DateTextBox".equals(DojoType) && "".equals(Value)) {
            Value = (new Date(System.currentTimeMillis())).toString();
        }
        return getLabelValue() +
                "<input type='" + (isPassword() ? "password" : "text") + "' id='" + VariableName + "' name='" + VariableName + "' value='" + Value + "' " +
                "dojoType='dijit.form." + DojoType + "' " + InnerHTML + " required='" + Required + "' style='width:" + Width + "px'" + (tabindex == -99 ? "" : "tabindex='" + tabindex + "'") + "  />";
    }


}
