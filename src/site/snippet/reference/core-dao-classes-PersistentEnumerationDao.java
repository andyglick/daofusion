public interface PersistentEnumerationDao<T extends PersistentEnumeration>
    extends PersistentEntityDao<T, Long> {

    /**
     * Retrieves a persistent enumeration by its name.
     */
    <S extends T> S getByName(String name, Class<S> targetEntityClass);

    /**
     * Retrieves a list of persistent enumerations by their name values.
     */
    <S extends T> List<S> getByNames(Class<S> targetEntityClass, String... names);

}
