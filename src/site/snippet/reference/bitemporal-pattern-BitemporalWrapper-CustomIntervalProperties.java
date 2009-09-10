@Columns(columns = { @Column(name = "validFrom"), @Column(name = "validTo") })
@Type(type = PersistentInterval.TYPE)
private Interval validityInterval;

@Columns(columns = { @Column(name = "recordFrom"), @Column(name = "recordTo") })
@Type(type = PersistentInterval.TYPE)
private Interval recordInterval;
