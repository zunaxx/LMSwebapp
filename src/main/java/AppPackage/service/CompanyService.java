package AppPackage.service;

import AppPackage.entity.Company;

import java.util.List;

public interface CompanyService {
    Company create(Company company);
    void update(Company company);
    void deleteById(long id);
    List<Company> getAll();
    Company getById(long id);
}
