package fv.ayurchr.commons.taglib.html;

import fv.ayurchr.commons.HibernateSession;
import fv.ayurchr.commons.SV;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FORM {
    private JspWriter jsp = null;
    private boolean includeTextBox = true;
    private boolean includeDateBox = true;
    private boolean includeNumBox = true;
    public static String TextBox = "ValidationTextBox";
    public static String DateBox = "DateTextBox";
    public static String NumBox = "NumberTextBox";
    public static String FILTERSELECT = "FilteringSelect";
    //public static String fv.ayurchr.commons.taglib.html.ComboBox = "fv.ayurchr.commons.taglib.html.ComboBox";
    private boolean includeComboBox = true;
    public static String isSubmitted = "1";
    public static String CLASS = "NOCLASS";
    public static String ATTRIBUTES = "NOCLASS";

    public FORM(JspWriter out) {
        jsp = out;
    }


    private boolean jspPrintln(String JspPrint) throws IOException {
        return jspPrint(JspPrint);
    }

    private boolean jspPrint(String JspPrint) throws IOException {
        try {
            jsp.print(JspPrint);
            System.out.println(JspPrint);

        } catch (IOException e_Ex) {
            e_Ex.printStackTrace();
            e_Ex.printStackTrace();
            if (SV.isDev)
                throw new IOException(e_Ex.getMessage());
            return false;
        }
        return true;
    }

    private boolean jspPrintInclude(String p_FormElement) throws IOException {
        if (includeTextBox && p_FormElement == TextBox) {
            jspPrint(FormIncludeTag(TextBox));
            includeTextBox = false;
        }

        if (includeDateBox && p_FormElement == DateBox) {
            jspPrint(FormIncludeTag(DateBox));
            includeDateBox = false;
        }
        if (includeNumBox && p_FormElement == NumBox) {
            jspPrint(FormIncludeTag(NumBox));
            includeNumBox = false;
        }
        if (includeComboBox && p_FormElement == FILTERSELECT) {
            jspPrint(FormIncludeTag(FILTERSELECT));
            includeComboBox = false;
        }
        return true;
    }

    private String FormIncludeTag(String p_FormTag) {
        return "<script type=\"text/javascript\"> dojo.require('dijit.form." + p_FormTag + "');</script>";
    }


    public boolean print(TextBox p_TextBox) throws IOException {
        jspPrintInclude(TextBox);
        return jspPrintln(p_TextBox.toDom());
    }


    public boolean print(DateBox p_DateBox) throws IOException {
        jspPrintInclude(DateBox);
        return jspPrintln(p_DateBox.toDom());
    }


    public boolean print(NumberBox p_NumBox) throws IOException {
        jspPrintInclude(NumBox);
        return jspPrintln(p_NumBox.toDom());
    }


    public boolean print(ComboBox p_ComboBox) throws Exception {
        jspPrintInclude(FILTERSELECT);
        return jspPrintln(p_ComboBox.toDom());
    }

    public boolean print(ArrayList<HashMap> p_FieldList) throws Exception {
        for (int i = 0; i < p_FieldList.size(); i++) {
            if ("TEXTBOX".equals(p_FieldList.get(i).get("TYPE")))
                print(new TextBox(p_FieldList.get(i)));
            if ("DATEBOX".equals(p_FieldList.get(i).get("TYPE")))
                print(new DateBox(p_FieldList.get(i)));
            if ("COMBOBOX".equals(p_FieldList.get(i).get("TYPE")))
                print(new ComboBox(p_FieldList.get(i)));
            if ("PASSWORD".equals(p_FieldList.get(i).get("TYPE")))
                print(new TextBox(p_FieldList.get(i), true));
        }
        return true;
    }


    public static Object getFormValue(long p_id, String p_Entity) throws Exception {
        if (p_id > 0) {
            HibernateSession hs = null;
            try {
                hs = new fv.ayurchr.commons.HibernateSession();
                return hs.getEntity(p_Entity, p_id);
            } catch (Exception e_Ex) {
                e_Ex.printStackTrace();
            }
        }
        return null;
    }
}