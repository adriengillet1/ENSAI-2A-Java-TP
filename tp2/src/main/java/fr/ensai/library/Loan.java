package fr.ensai.library;

import java.sql.Date;

public class Loan {
    
    // Attributes
    private Student borrower;
    private Item item;
    private Date stratDate;
    private Date returnDate; 

    public Loan(Student borrower, Item item, Date stratDate){
        this.borrower = borrower;
        this.item = item;
        this.stratDate = stratDate;
        this.returnDate = null;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String toString() {
        return "Item " + this.item.getTitle() + "borrowed by " + this.borrower.getName() + ".";
    }

    public String getItemName(){
        return this.item.getTitle();
    }
}
