@Entity
@Table(name = "customers",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"firstName", "lastName"})})
public class Customer extends OidBasedMutablePersistentEntity {

    public static final String _FIRST_NAME = "firstName";
    public static final String _LAST_NAME = "lastName";
    public static final String _ORDERS = "orders";
    public static final String _CONTACT_DETAILS = "contactDetails";

    public static final AssociationPath CONTACT_DETAILS = new AssociationPath(
            new AssociationPathElement(_CONTACT_DETAILS));

    @Column(nullable = false, length = 16)
    private String firstName;

    @Column(nullable = false, length = 16)
    private String lastName;

    @OneToMany(mappedBy = "customer")
    @Cascade(value = {CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<Order> orders = new ArrayList<Order>();

    @OneToOne(optional = false)
    @Cascade(value = {CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private ContactDetails contactDetails;

    protected List<Order> getOrders() {
        return orders;
    }

    protected void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCustomer(null);
    }

    public List<Order> getUnmodifiableOrderList() {
        return Collections.unmodifiableList(orders);
    }

    // rest of the getters and setters go here

}
