public final class CtoFilterCriterionProviders {

    // NestedPropertyCriteriaBasedConverter uses direct filter value approach under the hood
    private static final FilterDataStrategy STRATEGY = FilterDataStrategy.DIRECT;

    public static final FilterCriterionProvider LIKE = new SimpleFilterCriterionProvider(STRATEGY, 1) {
        public Criterion getCriterion(String targetPropertyName,
                Object[] filterObjectValues, Object[] directValues) {
            return Restrictions.like(targetPropertyName, directValues[0]);
        }
    };

    public static final FilterCriterionProvider EQ = new SimpleFilterCriterionProvider(STRATEGY, 1) {
        public Criterion getCriterion(String targetPropertyName,
                Object[] filterObjectValues, Object[] directValues) {
            return Restrictions.eq(targetPropertyName, directValues[0]);
        }
    };

    public static final FilterCriterionProvider BETWEEN = new SimpleFilterCriterionProvider(STRATEGY, 2) {
        public Criterion getCriterion(String targetPropertyName,
                Object[] filterObjectValues, Object[] directValues) {
            return Restrictions.between(targetPropertyName, directValues[0], directValues[1]);
        }
    };

}

public class SampleConverter extends NestedPropertyCriteriaBasedConverter {

    public static final String MAPPING_GROUP_CUSTOMER = "customer";

    // Customer - name
    public static final String CUSTOMER_NAME_ID = "name";
    public static final AssociationPath CUSTOMER_NAME_APATH = AssociationPath.ROOT;
    public static final String CUSTOMER_NAME_TARGET = "name";

    // Customer - userProfile - favoriteNumber
    public static final String CUSTOMER_FAVNO_ID = "favNo";
    public static final AssociationPath CUSTOMER_FAVNO_APATH = new AssociationPath(
            new AssociationPathElement("userProfile"));
    public static final String CUSTOMER_FAVNO_TARGET = "favoriteNumber";

    // Customer - accountCreated
    public static final String CUSTOMER_JOINDATE_ID = "joinDate";
    public static final AssociationPath CUSTOMER_JOINDATE_APATH = AssociationPath.ROOT;
    public static final String CUSTOMER_JOINDATE_TARGET = "accountCreated";

    public static final DateConverter DATE_CONVERTER = new DateConverter("yyyy.MM.dd HH:mm");

    public void initMappings() {
        addStringMapping(MAPPING_GROUP_CUSTOMER, CUSTOMER_NAME_ID,
                CUSTOMER_NAME_APATH, CUSTOMER_NAME_TARGET);

        addIntegerMapping(MAPPING_GROUP_CUSTOMER, CUSTOMER_FAVNO_ID,
                CUSTOMER_FAVNO_APATH, CUSTOMER_FAVNO_TARGET);

        addDateMapping(MAPPING_GROUP_CUSTOMER, CUSTOMER_JOINDATE_ID,
                CUSTOMER_JOINDATE_APATH, CUSTOMER_JOINDATE_TARGET);
    }

    private void addStringMapping(String mappingGroupName, String propertyId,
            AssociationPath associationPath, String targetPropertyName) {
        addMapping(mappingGroupName, new FilterAndSortMapping<String>(
                propertyId, associationPath, targetPropertyName,
                CtoFilterCriterionProviders.LIKE, FilterValueConverters.STRING));
    }

    private void addIntegerMapping(String mappingGroupName, String propertyId,
            AssociationPath associationPath, String targetPropertyName) {
        addMapping(mappingGroupName, new FilterAndSortMapping<Integer>(
                propertyId, associationPath, targetPropertyName,
                CtoFilterCriterionProviders.EQ, FilterValueConverters.INTEGER));
    }

    private void addDateMapping(String mappingGroupName, String propertyId,
            AssociationPath associationPath, String targetPropertyName) {
        addMapping(mappingGroupName, new FilterAndSortMapping<Date>(
                propertyId, associationPath, targetPropertyName,
                CtoFilterCriterionProviders.BETWEEN, DATE_CONVERTER));
    }

}
