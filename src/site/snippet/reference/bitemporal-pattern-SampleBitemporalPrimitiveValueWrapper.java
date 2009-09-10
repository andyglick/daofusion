@Entity
@Table(name = "bitemp_longs")
public class BitemporalLong extends BitemporalWrapper<Long> {

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Long value;

    protected BitemporalLong() {
        // default constructor required by Hibernate
    }

    public BitemporalLong(Long value, Interval validityInterval) {
        super(value, validityInterval);
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    protected void setValue(Long value) {
        this.value = value;
    }

    public Bitemporal copyWith(Interval validityInterval) {
        return new BitemporalLong(value, validityInterval);
    }

}
