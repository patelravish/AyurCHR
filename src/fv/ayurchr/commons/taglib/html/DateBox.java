package fv.ayurchr.commons.taglib.html;

import java.sql.Date;
import java.util.HashMap;

public class DateBox extends TextBox {
    public DateBox(String p_Label, String p_VariableName) {
        super(p_Label, p_VariableName);
    }
 
    private DateBox() {

    }

    private void setDateBoxDefaults() {
        setDojoType("DateTextBox");
        super.setWidth(140);
    }

    public DateBox(HashMap<String, String> p_XMLMap) {
        super(p_XMLMap);
        setDateBoxDefaults();
    }

    public void setValue(Date p_Date) {
        super.setValue(p_Date.toString());
    }


}
