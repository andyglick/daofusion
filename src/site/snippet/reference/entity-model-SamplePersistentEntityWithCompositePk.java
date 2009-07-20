@MappedSuperclass
@Entity(optimisticLock = OptimisticLockType.VERSION)
public abstract class CompositeKeyBasedMutablePersistentEntity<ID extends Serializable> implements Persistable<ID> {

    @EmbeddedId
    private ID id;

    @Version
    private Integer version;

    // hashCode / equals method implementation is based on the composite
    // primary key (ID), which should be set by the entity constructor
    // (default no-argument constructor must NOT be public)

    public CompositeKeyBasedMutablePersistentEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    protected void setId(ID id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    protected void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CompositeKeyBasedMutablePersistentEntity)) {
            return false;
        }

        final CompositeKeyBasedMutablePersistentEntity<?> other = (CompositeKeyBasedMutablePersistentEntity<?>) obj;

        return (id == null) ? false : id.equals(other.id);
    }

}

@Embeddable
public class CustomerPk implements Serializable {

    @Column(length = 64)
    private String name;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    // default no-argument constructor required by Hibernate
    protected CustomerPk() {
        this(null, null);
    }

    public CustomerPk(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    // getters and setters go here

    // hashCode / equals method implementation based
    // on "name" and "dateOfBirth" goes here

}

@Entity
@Table(name = "customers")
public class Customer extends CompositeKeyBasedMutablePersistentEntity<CustomerPk> {

    @Column(nullable = false)
    private String contactEmail;

    // default no-argument constructor required by Hibernate
    protected Customer() {
        this(null);
    }

    public Customer(CustomerPk id) {
        super(id);
    }

    // getters and setters go here

}
