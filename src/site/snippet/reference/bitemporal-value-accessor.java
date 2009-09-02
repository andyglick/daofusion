public class LongValueAccessor implements ValueAccessor<Long, BitemporalLong> {
	public Long extractValue(BitemporalLong bitemporalLong) {
		return bitemporalLong.getValue();
	}

	public BitemporalLong wrapValue(Long value, Interval validityInterval) {
		return new BitemporalLong(value, validityInterval);
	}
}

