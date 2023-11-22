package AppPackage.service;

import AppPackage.dao.CompanyDao;
import AppPackage.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public Company create(Company company) {
        companyDao.create(company);
        return company;
    }

    @Override
    public void update(Company company) {
        companyDao.update(company);
    }

    @Override
    public void deleteById(long id) {
        companyDao.deleteById(id);
    }

    @Override
    public List<Company> getAll() {
        return companyDao.getAll();
    }

    @Override
    public Company getById(long id) {
        return companyDao.getById(id);
    }
}
