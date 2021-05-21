package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Employee;
import com.example.doanoopkitchenmanage.model.Ingredient;
import com.example.doanoopkitchenmanage.service.checklist.ChecklistService;
import com.example.doanoopkitchenmanage.service.employee.EmployeeService;
import com.example.doanoopkitchenmanage.service.ingredient.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ChecklistController {
    @Autowired
    private ChecklistService checklistService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private IngredientService ingredientService;


    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }

    @GetMapping("/home/checklist")
    public String index(Model model) {
        model.addAttribute("checklists", checklistService.findAll());
        return "checklist/list";
    }

    //-----CREATE NEW CHECKLIST
    @GetMapping("/home/checklist/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("checklist/create");
        modelAndView.addObject("checklist", new Checklist());
        return modelAndView;
    }

    @PostMapping("/home/checklist/save")
    public String save(Checklist checklist, RedirectAttributes redirectAttributes) {
        checklistService.save(checklist);
        redirectAttributes.addFlashAttribute("message", "Created checklist successfully!");
        return "redirect:/home/checklist";
    }
    //-----VIEW CHECKLIST
    @GetMapping("/home/checklist/{id}/view")
    public ModelAndView viewChecklist(@PathVariable("id") Long id) {
        Optional<Checklist> checklistOptional = checklistService.findById(id);
        if (!checklistOptional.isPresent())  {
            return new ModelAndView("/error.404");
        }
        Iterable<Ingredient> ingredients = ingredientService.findAllByChecklist(checklistOptional.get());
        ModelAndView modelAndView = new ModelAndView("/checklist/view");
        modelAndView.addObject("checklist", checklistOptional.get());
        modelAndView.addObject("ingredients", ingredients);
        return modelAndView;
    }
    //-----CREATE NEW INGREDIENT IN CHECKLIST
    @GetMapping("/home/ingredient/create")
    public ModelAndView createIngredient() {

        ModelAndView modelAndView = new ModelAndView("ingredient-for-day/create");
        modelAndView.addObject("ingredient",new Ingredient() );
        return modelAndView;
    }

    @PostMapping("/home/checklist/save-ingredient")
    public String save(Ingredient ingredient, RedirectAttributes redirectAttributes) {
        ingredientService.save(ingredient);
        redirectAttributes.addFlashAttribute("message", "Created checklist successfully!");
        return "redirect:/home/checklist";
    }
}
