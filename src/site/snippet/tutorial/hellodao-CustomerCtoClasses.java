public class CustomerCtoConverter extends NestedPropertyCriteriaBasedConverter {

    public static final String GROUP_NAME = "customer";

    public CustomerCtoConverter() {
        // direct properties
        addStringLikeMapping(GROUP_NAME, CustomerDataSource._FIRST_NAME,
                AssociationPath.ROOT, Customer._FIRST_NAME);
        addStringLikeMapping(GROUP_NAME, CustomerDataSource._LAST_NAME,
                AssociationPath.ROOT, Customer._LAST_NAME);

        // collection property
        addCollectionSizeEqMapping(GROUP_NAME, CustomerDataSource._TOTAL_ORDERS,
                AssociationPath.ROOT, Customer._ORDERS);

        // nested properties
        addStringLikeMapping(GROUP_NAME, CustomerDataSource._CONTACT_EMAIL,
                Customer.CONTACT_DETAILS, ContactDetails._EMAIL);
        addStringLikeMapping(GROUP_NAME, CustomerDataSource._CONTACT_PHONE,
                Customer.CONTACT_DETAILS, ContactDetails._PHONE);
    }

    protected void addStringLikeMapping(String mappingGroupName, String propertyId,
            AssociationPath associationPath, String targetPropertyName) {
        addMapping(mappingGroupName, new FilterAndSortMapping<String>(
                propertyId, associationPath, targetPropertyName,
                FilterCriterionProviders.LIKE, FilterValueConverters.STRING));
    }

    protected void addCollectionSizeEqMapping(String mappingGroupName, String propertyId,
            AssociationPath associationPath, String targetPropertyName) {
        addMapping(mappingGroupName, new FilterAndSortMapping<Integer>(
                propertyId, associationPath, targetPropertyName,
                FilterCriterionProviders.COLLECTION_SIZE_EQ, FilterValueConverters.INTEGER));
    }

}

public final class FilterCriterionProviders {

    private FilterCriterionProviders() {
    }

    public static final FilterCriterionProvider LIKE = new SimpleFilterCriterionProvider(FilterDataStrategy.DIRECT, 1) {
        public Criterion getCriterion(String targetPropertyName, Object[] filterObjectValues, Object[] directValues) {
            return Restrictions.like(targetPropertyName, "%" + (String) directValues[0] + "%");
        }
    };

    public static final FilterCriterionProvider COLLECTION_SIZE_EQ = new SimpleFilterCriterionProvider(FilterDataStrategy.DIRECT, 1) {
        public Criterion getCriterion(String targetPropertyName, Object[] filterObjectValues, Object[] directValues) {
            return Restrictions.sizeEq(targetPropertyName, (Integer) directValues[0]);
        }
    };

}
