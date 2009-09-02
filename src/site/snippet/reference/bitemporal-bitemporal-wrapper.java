import com.anasoft.os.daofusion.bitemporal.BitemporalWrapper;

private static class BitemporalLong extends BitemporalWrapper<Long> {
	private Long value;

	public BitemporalLong(Long value, Interval validityInterval) {
	    super(value, validityInterval);
	}

	@Override
	public Bitemporal copyWith(Interval validityInterval) {
	    return new BitemporalLong(value, validityInterval);
	}

	@Override
	public Long getValue() {
	    return value;
	}

	@Override
	protected void setValue(Long value) {
	    this.value = value;
	}
}

