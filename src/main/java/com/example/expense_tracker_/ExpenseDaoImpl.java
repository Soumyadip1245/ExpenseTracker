package com.example.expense_tracker_;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class ExpenseDaoImpl implements ExpenseDao{
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertRecord(Expense emp) {
        entityManager.persist(emp);
    }
    @Override
    public List<Expense> findAllRecords() {
        TypedQuery<Expense> typedQuery = entityManager.createQuery("from Expense", Expense.class);
        return typedQuery.getResultList();
    }

    @Override
    public Expense findById(int id) {
        Expense exp = entityManager.find(Expense.class, id);
        return exp;
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        Expense expenseToDelete = entityManager.find(Expense.class, id);
        if (expenseToDelete != null) {
            entityManager.remove(expenseToDelete);
        }
    }
    @Override
    @Transactional
    public void updateRecord(int id,Expense updatedExp) {
        Expense exp = entityManager.find(Expense.class, id);
        exp.setDate(updatedExp.getDate());
        exp.setExpense((updatedExp.getExpense()));
        exp.setName(updatedExp.getName());
        exp.setNote(updatedExp.getNote());
        exp.setUrl(updatedExp.getUrl());
        entityManager.merge(exp);

    }
    
}
