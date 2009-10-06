/**
 * OpenEntityManagerInViewFilter sets an open Hibernate EntityManager
 * instance to this class for each thread associated with the request.
 */
public final class EntityManagerHolder {

    private static final ThreadLocal<HibernateEntityManager> emPerThread = new ThreadLocal<HibernateEntityManager>();

    private EntityManagerHolder() {
    }

    public static HibernateEntityManager get() {
        return emPerThread.get();
    }

    public static void set(HibernateEntityManager em) {
        emPerThread.set(em);
    }

}

public abstract class EntityManagerAwareEnumerationDao<T extends PersistentEnumeration>
        extends AbstractHibernateEnumerationDao<T> {

    @Override
    protected HibernateEntityManager getHibernateEntityManager() {
        // use the thread-local EntityManager instance
        return EntityManagerHolder.get();
    }

}
