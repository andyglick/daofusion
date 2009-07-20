public interface NestedPropertyCriterionVisitor {

    // updates the target Criteria according to FilterCriterion
    void visit(FilterCriterion criterion);

    // updates the target Criteria according to SortCriterion
    void visit(SortCriterion criterion);

}
