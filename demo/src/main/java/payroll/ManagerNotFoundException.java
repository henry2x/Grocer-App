package payroll;

class ManagerNotFoundException extends RuntimeException {

	ManagerNotFoundException(Long id) {
        super("Could not find Manager " + id);
    }
}