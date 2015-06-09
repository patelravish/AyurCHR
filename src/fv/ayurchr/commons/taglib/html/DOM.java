package fv.ayurchr.commons.taglib.html;

/**
 * Created by IntelliJ IDEA.
 * fv.ayurchr.dbobjects.hibernate.User: formatvirus
 * Date: 29/5/11
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
class DOM {
    String Label = "";
    String VariableName = "";
    String InnerHTML = "";
    String Value = "";
    boolean Required = false;
    boolean Disabled = false;
    int Width = 200;
    int Height = 200;
    boolean Hidden = false;
    String DojoType = "ValidationTextBox";
    int tabindex = -99;
    boolean isPassword = false;

    public DOM(String p_Label, String p_VariableName) {
        Label = p_Label;
        VariableName = p_VariableName;
    }

    public DOM() {

    }


    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getVariableName() {
        return VariableName;
    }

    public void setVariableName(String variableName) {
        VariableName = variableName;
    }

    public String getInnerHTML() {
        return InnerHTML;
    }

    public void setInnerHTML(String innerHTML) {
        InnerHTML = innerHTML;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public boolean isRequired() {
        return Required;
    }

    public void setRequired(boolean required) {
        Required = required;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    String getDojoType() {
        return DojoType;
    }

    void setDojoType(String dojoType) {
        DojoType = dojoType;
    }

    void setHidden(boolean hidden) {
        Hidden = hidden;
    }

    public boolean isHidden() {
        return Hidden;
    }

    protected String getLabelValue() {
        if ("".equals(Label)) {
            setRequired(false);
            setHidden(true);
            setInnerHTML(InnerHTML + " style='display:none;");
            return "";
        } else
            return "<div style='width:300px;'><label for='" + VariableName + "' >" + Label + ": </label></div>";
    }

    public int getTabindex() {
        return tabindex;
    }

    public void setTabindex(int tabindex) {
        this.tabindex = tabindex;
    }

	public boolean isPassword() {
		return isPassword;
	}

	public void setPassword(boolean isPassword) {
		this.isPassword = isPassword;
	}

    public boolean isDisabled() {
        return Disabled;
    }

    public void setDisabled(boolean disabled) {
        Disabled = disabled;
    }
}
