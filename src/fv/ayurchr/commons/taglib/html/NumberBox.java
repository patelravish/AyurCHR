package fv.ayurchr.commons.taglib.html;

import java.util.HashMap;

public class NumberBox extends TextBox {

    public NumberBox(String p_Label, String p_VariableName) {
        super(p_Label, p_VariableName);
        setNumberDefaults();
    }

    private NumberBox() {

    }

    private void setNumberDefaults() {

        super.setDojoType("NumberTextBox");
    }

    public NumberBox(HashMap<String, String> p_XMLMap) {
        super(p_XMLMap);
        setNumberDefaults();
    }

    private double Min = -999999999;
    private double Max = 999999999;
    private int DecimalPlaces = 0;
    private double Value = 0;

    public double getNumValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
        super.Value = String.valueOf(value);
    }

    public double getMin() {
        return Min;
    }

    public void setMin(double min) {
        Min = min;
    }

    public double getMax() {
        return Max;
    }

    public void setMax(double max) {
        Max = max;
    }

    public int getDecimalPlaces() {
        return DecimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        DecimalPlaces = decimalPlaces;
    }

    public void setRange(double p_Min, double p_Max) {
        Min = p_Min;
        Max = p_Max;
    }

    @Override
    public String toDom() {
        setInnerHTML("constraints='{min:" + Min + ",max:" + Max + ",places:" + DecimalPlaces + "}' " + getInnerHTML());
        return super.toDom();
    }

}
