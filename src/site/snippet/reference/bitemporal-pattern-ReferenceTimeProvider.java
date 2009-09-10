public interface ReferenceTimeProvider {

    /**
     * Returns the reference time, possibly null.
     */
    DateTime getReference();

    /**
     * Sets the reference time to the specified value.
     */
    void setReference(DateTime dateTime);

    /**
     * Clears the reference time. After clearing, getReference() should
     * return null to indicate the reference time is no longer being set.
     */
    void clearReference();

}
