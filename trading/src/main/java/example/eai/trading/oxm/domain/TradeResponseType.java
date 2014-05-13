//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.28 at 09:07:21 PM EDT 
//


package example.eai.trading.oxm.domain;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Trade Response Type
 * 
 * <p>Java class for TradeResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TradeResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="symbol" type="{http://www.dev.com/oxm/domain}SymbolType"/>
 *         &lt;element name="buySellIndicator" type="{http://www.dev.com/oxm/domain}buySellIndicatorTypeEnum"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quotePrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element ref="{http://www.dev.com/oxm/domain}timestamp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeResponseType", propOrder = {
    "symbol",
    "buySellIndicator",
    "quantity",
    "quotePrice",
    "price",
    "timestamp"
})
public class TradeResponseType {

    @XmlElement(required = true)
    protected String symbol;
    @XmlElement(required = true)
    protected BuySellIndicatorTypeEnum buySellIndicator;
    protected int quantity;
    protected double quotePrice;
    protected double price;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar timestamp;

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the buySellIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link BuySellIndicatorTypeEnum }
     *     
     */
    public BuySellIndicatorTypeEnum getBuySellIndicator() {
        return buySellIndicator;
    }

    /**
     * Sets the value of the buySellIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuySellIndicatorTypeEnum }
     *     
     */
    public void setBuySellIndicator(BuySellIndicatorTypeEnum value) {
        this.buySellIndicator = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the quotePrice property.
     * 
     */
    public double getQuotePrice() {
        return quotePrice;
    }

    /**
     * Sets the value of the quotePrice property.
     * 
     */
    public void setQuotePrice(double value) {
        this.quotePrice = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(Calendar value) {
        this.timestamp = value;
    }

}
