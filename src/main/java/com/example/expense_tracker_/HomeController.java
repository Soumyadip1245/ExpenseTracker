package com.example.expense_tracker_;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private ExpenseController expenseController;
    @RequestMapping("/")
    public String home(Model model) {
        List<Expense> expenses = expenseController.getAll();
        model.addAttribute("expensedata", expenses);
        return "landing";
    }
     @RequestMapping("/createExpense")
    public String createExpense(@ModelAttribute Expense expense) {
        expenseController.createExpense(expense);
        return "redirect:/";
    }
    @RequestMapping("/deleteExpenses/{id}")
    public String deleteExpense(@PathVariable("id") int id){
        expenseController.deletebyId(id);
        return "redirect:/";
    }
    @RequestMapping("/editExpense/{id}")
    public String editExpensePage(Model model, @PathVariable("id") int id) {
        Expense ex = expenseController.findId(id);
        System.out.println("Data"+ex.toString());
        model.addAttribute("expense", ex);
        return "editing";
    }
    @RequestMapping("/getId")
    public String getExpense(Model model, @RequestParam("id") int id){
        System.out.println(id);
       Expense expense =  expenseController.findId(id);
       model.addAttribute("data",expense);
       return "editing";

    }
    @RequestMapping("/updateExpense/{id}")
    public String editExpense(@PathVariable("id") int id, @ModelAttribute Expense expense){
        expenseController.updateExpense(expense, id);
        return "redirect:/";
    }
}
