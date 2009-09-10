@Entity
@Table(name = "orders")
public class Order extends OidBasedMutablePersistentEntity {

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Embedded
    private Address shippingAddress;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Customer customer;

    protected Order() {
        // default constructor required by Hibernate
    }

    // Address and Customer should be "user-immutable" as well
    public Order(Date creationDate, Address shippingAddress, Customer customer) {
        this.shippingAddress = shippingAddress;
        this.customer = customer;
        setCreationDate(creationDate);
    }

    public Date getCreationDate() {
        // return a defensive copy of the mutable Date class
        return new Date(creationDate.getTime());
    }

    protected void setCreationDate(Date creationDate) {
        // create a defensive copy of the mutable Date class
        this.creationDate = new Date(creationDate.getTime());
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    protected void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    protected void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
