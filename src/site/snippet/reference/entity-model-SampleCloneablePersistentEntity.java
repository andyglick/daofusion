@Entity
@Table(name = "orders")
public class Order extends OidBasedMutablePersistentEntity implements Cloneable {

    @Column
    private String description;

    @Column(nullable = false)
    private Boolean complete;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Embedded
    private Address shippingAddress;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Customer customer;

    // getters and setters go here

    @Override
    protected Object clone() {
        try {
            // performs a shallow (bit-by-bit) copy of this object,
            // taking care of primitive fields and immutable objects
            Order clone = Order.class.cast(super.clone());

            // mutable objects need to be deep-copied (cloned)
            clone.creationDate = Date.class.cast(this.creationDate.clone());
            clone.shippingAddress = Address.class.cast(this.shippingAddress.clone());
            clone.customer = Customer.class.cast(this.customer.clone());

            return clone;
        } catch (CloneNotSupportedException e) {
            // shouldn't happen if all mutable objects are cloneable
            throw new Error(e);
        }
    }

}
