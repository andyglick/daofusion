public interface PersistentEntityCriteria {

    /**
     * Applies query constraints defined by the persistent
     * entity criteria implementation to the targetCriteria.
     */
    void apply(Criteria targetCriteria);

}
