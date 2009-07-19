public void apply(Criteria targetCriteria) {
    List<T> criterionList = getObjectList();

    V visitor = getCriterionVisitor(targetCriteria);

    for (T criterion : criterionList) {
        criterion.accept(visitor);
    }

    applyPagingCriteria(targetCriteria);
}
