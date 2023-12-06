package ma.ensa.test.driven.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ma.ensa.test.driven.project.service.*;

@Controller
public class TaxController {

    @Autowired
    private TaxService service;

    @GetMapping("/tax")
    public String index(Model model) {
        if(!model.containsAttribute("income"))
            model.addAttribute("income", 0D);
        if(!model.containsAttribute("children"))
            model.addAttribute("children", 2);
        return "/TaxCalculation/index";
    }

    @PostMapping("/process-calculate-tax")
    public String process(@RequestParam(value = "income", required = false) Double income, @RequestParam(value = "children", required = false) Integer children, RedirectAttributes attributes) {
        if(income == null || children == null) {
            attributes.addFlashAttribute("errorMessage", "Veuillez remplir tous les champs du formulaire");
        }
        Double tax = service.calculateTax(income);
        Double reduction = service.calculateReduction(children);
        if(tax == null) {
            attributes.addFlashAttribute("errorMessageIncome", "Rejet du revenu");
        } else {
            attributes.addFlashAttribute("successMessageTax", String.format("Taux d'imposition de %.2f%%", tax));
        }
        if(reduction == null) {
            attributes.addFlashAttribute("errorMessageChildren", "Rejet du nombre d'enfants");
        } else {
            attributes.addFlashAttribute("successMessageReduction", String.format("Taux de réduction de %.2f%%", reduction));
        }
        attributes.addFlashAttribute("income", income);
        attributes.addFlashAttribute("children", children);
        return "redirect:/tax";
    }
}
