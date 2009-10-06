public interface CustomerDao extends PersistentEntityDao<Customer, Long> {

    // add some business related methods here
    // (don't forget to integration-test them too)

}

public class CustomerDaoImpl extends EntityManagerAwareEntityDao<Customer, Long>
        implements CustomerDao {

    // instances are created via DaoManager
    CustomerDaoImpl() {
        super();
    }

    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

}
