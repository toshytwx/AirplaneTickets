package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.Airport;
import gmail.dimon0272.WebApp.model.Company;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class CompanyServiceImpl implements CompanyService {
    private Query query;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company getCompanyById(Long companyId) {
        query = entityManager.createQuery("SELECT a FROM Company a WHERE a.id = :companyId", Company.class);
        query.setParameter("companyId", companyId);
        return (Company) query.getSingleResult();
    }
}
