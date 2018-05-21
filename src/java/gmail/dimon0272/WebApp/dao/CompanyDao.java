package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company, Long> {
    Company getCompaniesById(Long id);
}
