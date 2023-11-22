package AppPackage.dao;

import AppPackage.entity.Company;

import java.util.List;

public interface CompanyDao {
    Company create(Company company);
    void update(Company company);
    void deleteById(long id);
    List<Company> getAll();
    Company getById(long id);
}
