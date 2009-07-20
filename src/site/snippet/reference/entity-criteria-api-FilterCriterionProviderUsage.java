public static final FilterCriterionProvider LIKE_USING_FILTER_OBJECT = new FilterCriterionProvider() {

    public Criterion getCriterion(String targetPropertyName,
        Object[] filterObjectValues, Object[] directValues) {
        return Restrictions.like(targetPropertyName, filterObjectValues[0]);
    }

    public boolean enabled(Object[] filterObjectValues, Object[] directValues) {
        return (filterObjectValues.length == 1) && (filterObjectValues[0] != null);
    }

};

public static final FilterCriterionProvider BETWEEN_USING_DIRECT_VALUES = new FilterCriterionProvider() {

    public Criterion getCriterion(String targetPropertyName,
        Object[] filterObjectValues, Object[] directValues) {
        return Restrictions.between(targetPropertyName, directValues[0], directValues[1]);
    }

    public boolean enabled(Object[] filterObjectValues, Object[] directValues) {
        return (directValues.length == 2) && (directValues[0] != null) && (directValues[1] != null);
    }

};
