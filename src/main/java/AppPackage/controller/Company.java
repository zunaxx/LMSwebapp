package AppPackage.controller;

import AppPackage.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class Company {

    private final CompanyService companyService;

    @Autowired
    public Company(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getAllCompany(Model model) {
        model.addAttribute("companies", companyService.getAll());
        return "company/index";
    }

    @GetMapping("/companyPage")
    public String getAllCompanyFull(@RequestParam("companyId") long companyId, Model model) {
        model.addAttribute("companies", companyService.getById(companyId));
        return "company/companyPage";
    }

    @GetMapping("/newCompany")
    public String newCompany(Model model) {
        model.addAttribute("company", new AppPackage.entity.Company());
        return "company/addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute AppPackage.entity.Company company, Model model) {
        companyService.create(company);
        model.addAttribute("companies", companyService.getAll());
        return "company/index";
    }

    @GetMapping("deleteCompanyById/{id}")
    public String deleteCompanyById(@PathVariable("id") long id, Model model) {
        companyService.deleteById(id);
        model.addAttribute("companies", companyService.getAll());
        return "company/index";
    }

    @GetMapping("/updateCompany/{id}")
    public String getCompanyById(Model model, @PathVariable("id") long id) {
        model.addAttribute("company1", companyService.getById(id));
        return "company/updateCompany";
    }

    @PostMapping("/{id}")
    public String updateCompany(@ModelAttribute AppPackage.entity.Company company, Model model) {
        companyService.update(company);
        model.addAttribute("companies", companyService.getAll());
        return "company/index";
    }

}
