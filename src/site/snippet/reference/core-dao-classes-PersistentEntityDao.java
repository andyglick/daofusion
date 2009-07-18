public interface PersistentEntityDao<T extends Persistable<ID>, ID extends Serializable> {

    /**
     * Returns the implicit persistent entity class the DAO works with.
     */
    Class<T> getEntityClass();

    /**
     * Retrieves a persistent instance.
     */
    <S extends T> S get(ID id, Class<S> targetEntityClass);

    /**
     * Retrieves all persistent instances.
     */
    <S extends T> List<S> getAll(Class<S> targetEntityClass);

    /**
     * Persists a transient instance or updates a detached instance.
     */
    <S extends T> S saveOrUpdate(S entity);

    /**
     * Deletes a persistent instance.
     */
    void delete(T entity);

    /**
     * Deletes a persistent instance.
     */
    <S extends T> void delete(ID id, Class<S> targetEntityClass);

    /**
     * Deletes all persistent instances.
     */
    <S extends T> int deleteAll(Class<S> targetEntityClass);

    /**
     * Refreshes a persistent or a detached instance by synchronizing
     * its state with the database.
     */
    void refresh(T entity);

    /**
     * Retrieves a list of persistent instances.
     */
    <S extends T> List<S> query(PersistentEntityCriteria entityCriteria,
            Class<S> targetEntityClass);

    /**
     * Returns a single persistent instance (if available).
     */
    <S extends T> S uniqueResult(PersistentEntityCriteria entityCriteria,
            boolean returnNullOnMultipleResults, Class<S> targetEntityClass);

    /**
     * Returns the total number of instances persisted within the database.
     */
    <S extends T> int count(PersistentEntityCriteria entityCriteria,
            Class<S> targetEntityClass);

    /**
     * Returns the total number of all instances persisted within the database.
    */
    <S extends T> int countAll(Class<S> targetEntityClass);

}
