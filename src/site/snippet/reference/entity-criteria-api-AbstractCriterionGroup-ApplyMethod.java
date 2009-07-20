public void apply(Criteria targetCriteria) {
    // obtain the list of managed PersistentEntityCriterion instances
    List<T> criterionList = getObjectList();

    // obtain the criterion visitor
    V visitor = getCriterionVisitor(targetCriteria);

    // visit all PersistentEntityCriterion instances
    // (targetCriteria is updated for each visited criterion)
    for (T criterion : criterionList) {
        criterion.accept(visitor);
    }

    applyPagingCriteria(targetCriteria);
}
