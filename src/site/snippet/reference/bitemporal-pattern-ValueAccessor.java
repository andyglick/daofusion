public interface ValueAccessor<V, T extends Bitemporal> extends Serializable {

    /**
     * Extract the value from the given Bitemporal object.
     */
    V extractValue(T bitemporalObject);

    /**
     * Create a Bitemporal object wrapping given value,
     * valid for the specified interval.
     */
    T wrapValue(V value, Interval validityInterval);

}
