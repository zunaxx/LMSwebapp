package AppPackage.dao;

import AppPackage.entity.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceProperty;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CompanyDaoImpl implements CompanyDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company create(Company company) {
    entityManager.persist(company);
    return company;
    }
    @Override
    public void update(Company company) {
        entityManager.merge(company);
    }

    @Override
    public void deleteById(long id) {
        Company company = entityManager.find(Company.class,id);
        entityManager.remove(company);
    }

    @Override
    public List<Company> getAll() {
        List<Company> list = entityManager.createQuery("select c from Company c").getResultList();
        return list;
    }

    @Override
    public Company getById(long id) {
        return entityManager.find(Company.class,id);
    }


}
