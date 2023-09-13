package com.example.expense_tracker_;
import java.util.List;


public interface ExpenseDao {
    public void insertRecord(Expense emp);
	public Expense findById(int id);
	public List<Expense> findAllRecords();
	public void updateRecord(int id,Expense exp);
	public void deleteRecord(int id);
}
