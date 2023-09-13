package com.example.expense_tracker_;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class ExpenseController {
    @Autowired
    private ExpenseDao empDao;


    @PostMapping("/create")
    public void createExpense(@RequestBody Expense e) {
        empDao.insertRecord(e);
    }

    @PutMapping("/update/{id}")
    public void updateExpense(@RequestBody Expense e, @PathVariable("id") int id) {
        empDao.updateRecord(id, e);
    }

    @GetMapping("/getAll")
    public List<Expense> getAll() {
        List<Expense> list = empDao.findAllRecords();
        return list;
    }

    @PostMapping("/findId/{id}")
    public Expense findId(@PathVariable("id") int id) {
        Expense e = empDao.findById(id);
        return e;
    }

    @DeleteMapping("/delete/{id}")
    public void deletebyId(@PathVariable("id") int id) {
        empDao.deleteRecord(id);
    }
}
