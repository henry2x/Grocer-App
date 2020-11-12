package payroll;

import org.springframework.data.jpa.repository.JpaRepository;

interface ManagerRepository extends JpaRepository<Manager, Long> {

}