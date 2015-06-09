package fv.ayurchr.commons;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * User: RavishPatel
 * Date: 12/17/11
 * Time: 9:04 PM
 */
public class XMLUtilities {

    public static ArrayList<HashMap> getFieldList(String FormXMLPath) {
        ArrayList<HashMap> FieldList = new ArrayList<HashMap>();
        Document document = null;
        try {
            File url = new File(FormXMLPath);
            SAXReader reader = new SAXReader();
            document = reader.read(url);
            Element root = document.getRootElement();
            Element Fields = null;
            // iterate through child elements of root
            for (Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                if ("FORM_FIELDS".equals(element.getName())) {
                    Fields = element;
                    break;
                }
            }
            String Name;
            String Value;
            Element foo;
            String FieldType;
            HashMap<String, String> FieldAttributes;

            // iterate through child elements of root with element name "foo"
            for (Iterator i = Fields.elementIterator("FIELD"); i.hasNext(); ) {
                foo = (Element) i.next();
                FieldAttributes = new HashMap<String, String>();
                for (Iterator values = foo.elementIterator(); values.hasNext(); ) {
                    Element evalues = (Element) values.next();
                    FieldAttributes.put(evalues.getName(), evalues.getText());
                }
                FieldList.add(FieldAttributes);
            }


        } catch (Exception e_Ex) {
            e_Ex.printStackTrace();
        }
        return FieldList;
    }
}
