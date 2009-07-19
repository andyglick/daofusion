public interface NestedPropertyCriterionVisitor {

    void visit(FilterCriterion criterion);

    void visit(SortCriterion criterion);

}
