package com.example.expense_tracker_;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int _id;
    @Column()
    private String name;
    @Column()
    private double expense;
    @Column()
    private String note;
   @Column
   private String date;
   @Column
   private String url;

    public int get_id() {
        return _id;
    }
    @Override
    public String toString() {
        return "Expense [_id=" + _id + ", name=" + name + ", expense=" + expense + ", note=" + note + ", date=" + date
                + ", url=" + url + "]";
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getExpense() {
        return expense;
    }
    public void setExpense(double expense) {
        this.expense = expense;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
  
}
