package com.MakerSharks.MakerSharks.Controller;

import com.MakerSharks.MakerSharks.Entity.Supplier;
import com.MakerSharks.MakerSharks.Service.supplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
//@RequestMapping("/api/supplier")
public class HomeController {

    @Autowired
    private supplierService supplierServ;

    @GetMapping("/register")
    public String register(Model model) {
        // Add attributes if needed
        List<String> countryNames = Arrays.asList(
                "United States", "Canada", "United Kingdom", "Germany", "France",
                "Italy", "Spain", "Australia", "Japan", "China", "India", "Brazil"
        );
        List<String> natureOfBusinessOptions = Arrays.asList("small_scale", "medium_scale", "large_scale");
        List<String> manufacturingProcessesOptions = Arrays.asList("moulding", "3d_printing", "casting", "coating");

        model.addAttribute("countryNames", countryNames);
        model.addAttribute("natureOfBusinessOptions", natureOfBusinessOptions);
        model.addAttribute("manufacturingProcessesOptions", manufacturingProcessesOptions);
        model.addAttribute("supplier", new Supplier()); // Add an empty Supplier object for the form

        return "register"; // The name of the Thymeleaf template for the register page
    }

    @GetMapping("/")
    public String index(Model model) {
        List<String> countryNames = Arrays.asList(
                "United States", "Canada", "United Kingdom", "Germany", "France",
                "Italy", "Spain", "Australia", "Japan", "China", "India", "Brazil"
        );
        List<String> natureOfBusinessOptions = Arrays.asList("small_scale", "medium_scale", "large_scale");
        List<String> manufacturingProcessesOptions = Arrays.asList("moulding", "3d_printing", "casting", "coating");

        model.addAttribute("countryNames", countryNames);
        model.addAttribute("natureOfBusinessOptions", natureOfBusinessOptions);
        model.addAttribute("manufacturingProcessesOptions", manufacturingProcessesOptions);
        model.addAttribute("supplier", new Supplier()); // Add an empty Supplier object for the form

        return "index";
    }

    @PostMapping("/createsupply")
    public String createSupplier(@ModelAttribute Supplier supplier) {
        Supplier s = supplierServ.createSupplier(supplier);
        if (s != null) {
            System.out.println("Data saved into database");
        } else {
            System.out.println("Something went wrong");
        }
        return "redirect:/register";
    }

    @PostMapping("/filterSuppliers")
    public String filterSuppliers(@ModelAttribute("supplier") Supplier supplier, RedirectAttributes redirectAttributes) {
        List<Supplier> filteredSuppliers = supplierServ.filterSuppliers(
                supplier.getLocation(),
                supplier.getNature_of_business(),
                supplier.getManufacturing_processes()
        );
        redirectAttributes.addFlashAttribute("filteredSuppliers", filteredSuppliers);
        return "redirect:/"; // Redirect to the index page
    }
}
