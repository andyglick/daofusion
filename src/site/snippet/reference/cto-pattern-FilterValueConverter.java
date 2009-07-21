public interface FilterValueConverter<T> {

    /**
     * Converts the given stringValue into
     * appropriate object representation.
     */
    T convert(String stringValue);

}
