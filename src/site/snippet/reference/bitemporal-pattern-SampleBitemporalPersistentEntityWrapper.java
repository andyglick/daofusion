@Entity
@Table(name = "bitemp_orders")
public class BitemporalOrder extends BitemporalWrapper<Order> {

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Order value;

    protected BitemporalOrder() {
        // default constructor required by Hibernate
    }

    public BitemporalOrder(Order value, Interval validityInterval) {
        super(value, validityInterval);
    }

    @Override
    public Order getValue() {
        return value;
    }

    @Override
    protected void setValue(Order value) {
        this.value = value;
    }

    public Bitemporal copyWith(Interval validityInterval) {
        // BitemporalWrapper implements the Bitemporal interface
        return new BitemporalOrder(value, validityInterval);
    }

}
