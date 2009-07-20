public interface FilterValueObjectProvider {

    /**
     * Returns a typed object representation of the given
     * string-based filter value.
     */
    Object getObject(String stringValue);

}
