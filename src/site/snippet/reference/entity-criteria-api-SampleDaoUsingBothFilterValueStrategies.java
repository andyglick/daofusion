public class QueryDefinition<T extends Persistable<?>> {

    private Integer firstResult;
    private Integer maxResults;

    private T filterObject;
    private boolean filterEnabled;

    private boolean sortEnabled;
    private AssociationPath sortAssociationPath;
    private String sortTargetPropertyName;
    private boolean sortAscending;

    // getters and setters go here

}

public interface OrderDao extends PersistentEntityDao<Order, Long> {

    List<Order> getOrders(QueryDefinition<Order> query,
            Integer minOrderItemCount, final String customerNameFilter);

}

public class OrderDaoImpl extends EntityManagerAwareEntityDao<Order, Long> implements OrderDao {

    public Class<Order> getEntityClass() {
        return Order.class;
    }

    public List<Order> getOrders(final QueryDefinition<Order> query,
            Integer minOrderItemCount, final String customerNameFilter) {

        // initialize a NestedPropertyCriteria instance

        NestedPropertyCriteria criteria = new NestedPropertyCriteria();

        criteria.setFirstResult(query.getFirstResult());
        criteria.setMaxResults(query.getMaxResults());

        criteria.setFilterObject(query.getFilterObject());

        AssociationPath customerPath = new AssociationPath(new AssociationPathElement("customer"));


        // 1. filter object approach

        // "creationDate" is a direct property in relation to Order entity
        criteria.add(new FilterCriterion(AssociationPath.ROOT, "creationDate", "creationDate", true,
                new SimpleFilterCriterionProvider(FilterDataStrategy.FILTER_OBJECT, 1) {

                    public Criterion getCriterion(String targetPropertyName,
                            Object[] filterObjectValues, Object[] directValues) {
                        // filterObjectValues[0] comes from filterObject.getCreationDate()
                        return Restrictions.eq(targetPropertyName, filterObjectValues[0]);
                    }

                    @Override
                    public boolean enabled(Object[] filterObjectValues, Object[] directValues) {
                        return super.enabled(filterObjectValues, directValues)
                            && query.isFilterEnabled();
                        }

            }));

        // (Customer) "email" is a nested property in relation to Order entity
        criteria.add(new FilterCriterion(customerPath, "email", "customer.email", true,
                new SimpleFilterCriterionProvider(FilterDataStrategy.FILTER_OBJECT, 1) {

                    public Criterion getCriterion(String targetPropertyName,
                            Object[] filterObjectValues, Object[] directValues) {
                        // filterObjectValues[0] comes from filterObject.getCustomer().getEmail()
                        return Restrictions.like(targetPropertyName, filterObjectValues[0]);
                    }

                    @Override
                    public boolean enabled(Object[] filterObjectValues, Object[] directValues) {
                        return super.enabled(filterObjectValues, directValues)
                            && query.isFilterEnabled();
                    }

        }));


        // 2. direct value approach

        // "orderItems" is a direct property in relation to Order entity
        criteria.add(new FilterCriterion(AssociationPath.ROOT, "orderItems", minOrderItemCount, false,
                new SimpleFilterCriterionProvider(FilterDataStrategy.DIRECT, 1) {

                    public Criterion getCriterion(String targetPropertyName,
                            Object[] filterObjectValues, Object[] directValues) {
                        // directValues[0] is minOrderItemCount
                        return Restrictions.sizeGe(targetPropertyName, (Integer) directValues[0]);
                    }

                    @Override
                    public boolean enabled(Object[] filterObjectValues, Object[] directValues) {
                        return super.enabled(filterObjectValues, directValues)
                            && query.isFilterEnabled();
                    }

        }));


        // 3. bypassing filter value strategies altogether

        // (Customer) "name" is a nested property in relation to Order entity
        criteria.add(new FilterCriterion(customerPath, "name",
                new SimpleFilterCriterionProvider() {

                    public Criterion getCriterion(String targetPropertyName,
                            Object[] filterObjectValues, Object[] directValues) {
                        // customerNameFilter is the method parameter itself
                        return Restrictions.like(targetPropertyName, customerNameFilter);
                    }

                    @Override
                    public boolean enabled(Object[] filterObjectValues, Object[] directValues) {
                        return (customerNameFilter != null) && query.isFilterEnabled();
                    }

        }));


        if (query.isSortEnabled()) {
            criteria.add(new SortCriterion(
                query.getSortAssociationPath(),
                query.getSortTargetPropertyName(),
                query.isSortAscending()));
        }

        return query(criteria);
    }

}
