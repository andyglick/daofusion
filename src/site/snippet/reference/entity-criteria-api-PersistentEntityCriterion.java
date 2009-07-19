public interface PersistentEntityCriterion<V> {

    /**
     * Accepts the given visitor to visit this criterion.
     */
    void accept(V visitor);

}
