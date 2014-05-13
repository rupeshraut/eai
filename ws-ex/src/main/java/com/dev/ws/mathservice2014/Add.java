
package com.dev.ws.mathservice2014;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="valOne" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valTwo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "valOne",
    "valTwo"
})
@XmlRootElement(name = "add")
public class Add {

    protected int valOne;
    protected int valTwo;

    /**
     * Gets the value of the valOne property.
     * 
     */
    public int getValOne() {
        return valOne;
    }

    /**
     * Sets the value of the valOne property.
     * 
     */
    public void setValOne(int value) {
        this.valOne = value;
    }

    /**
     * Gets the value of the valTwo property.
     * 
     */
    public int getValTwo() {
        return valTwo;
    }

    /**
     * Sets the value of the valTwo property.
     * 
     */
    public void setValTwo(int value) {
        this.valTwo = value;
    }

}
