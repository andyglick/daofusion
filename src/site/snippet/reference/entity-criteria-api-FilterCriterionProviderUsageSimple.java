public static final FilterCriterionProvider LIKE_USING_FILTER_OBJECT = new SimpleFilterCriterionProvider(
        FilterDataStrategy.FILTER_OBJECT, 1) {

    public Criterion getCriterion(String targetPropertyName,
        Object[] filterObjectValues, Object[] directValues) {
        return Restrictions.like(targetPropertyName, filterObjectValues[0]);
    }

};

public static final FilterCriterionProvider BETWEEN_USING_DIRECT_VALUES = new SimpleFilterCriterionProvider(
        FilterDataStrategy.DIRECT, 2) {

    public Criterion getCriterion(String targetPropertyName,
        Object[] filterObjectValues, Object[] directValues) {
        return Restrictions.between(targetPropertyName, directValues[0], directValues[1]);
    }

};
