
package bookclient;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for book complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="book_author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="book_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="book_price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="book_title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "bookAuthor",
    "bookId",
    "bookPrice",
    "bookTitle"
})
public class Book {

    @XmlElement(name = "book_author")
    protected String bookAuthor;
    @XmlElement(name = "book_id")
    protected String bookId;
    @XmlElement(name = "book_price")
    protected float bookPrice;
    @XmlElement(name = "book_title")
    protected String bookTitle;

    /**
     * Gets the value of the bookAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * Sets the value of the bookAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookAuthor(String value) {
        this.bookAuthor = value;
    }

    /**
     * Gets the value of the bookId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Sets the value of the bookId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookId(String value) {
        this.bookId = value;
    }

    /**
     * Gets the value of the bookPrice property.
     * 
     */
    public float getBookPrice() {
        return bookPrice;
    }

    /**
     * Sets the value of the bookPrice property.
     * 
     */
    public void setBookPrice(float value) {
        this.bookPrice = value;
    }

    /**
     * Gets the value of the bookTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Sets the value of the bookTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookTitle(String value) {
        this.bookTitle = value;
    }

}
