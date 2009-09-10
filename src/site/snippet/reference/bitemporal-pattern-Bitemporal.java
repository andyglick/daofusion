public interface Bitemporal {

    /**
     * Returns the interval in which this bitemporal object is valid.
     */
    public Interval getValidityInterval();

    /**
     * Returns the interval in which this bitemporal object is known.
     */
    public Interval getRecordInterval();

    /**
     * End the recording interval of this bitemporal object, indicating that it
     * has been superseded by a new object, or is deemed as no longer relevant
     * (i.e. because it was faulty knowledge) and should be "forgotten".
     */
    public void end();

    /**
     * Create and return a new bitemporal object representing the same value as
     * this object, but with specified validity. The recording interval of the
     * returned object will always be from now on.
     */
    public Bitemporal copyWith(Interval validityInterval);

}
