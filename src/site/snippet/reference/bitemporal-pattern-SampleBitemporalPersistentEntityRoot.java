@Entity
@Table(name = "customers")
public class Customer extends OidBasedMutablePersistentEntity {

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(value = { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
    @JoinColumn(name="customer")
    private Collection<BitemporalOrder> orders = new LinkedList<BitemporalOrder>();

    // use this method for accessing bitemporal trace of Order values
    public WrappedBitemporalProperty<Order, BitemporalOrder> getOrders() {
        return new WrappedBitemporalProperty<Order, BitemporalOrder>(orders,
                new WrappedValueAccessor<Order, BitemporalOrder>() {

            public BitemporalOrder wrapValue(Order value, Interval validityInterval) {
                return new BitemporalOrder(value, validityInterval);
            }

        });
    }

}
