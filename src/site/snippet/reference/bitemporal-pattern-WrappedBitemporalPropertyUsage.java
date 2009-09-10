Customer customer; // create or retrieve Customer via PersistentEntityDao

// set the reference time ("now") to 1-Jan-2010
TimeUtils.setReference(TimeUtils.day(1, 1, 2010));

// first Order will be valid from now on (1-Jan-2010 .. end_of_time)
customer.getOrders().set(firstOrder);

// second Order supersedes the first one:
// - first order valid in [1-Jan-2010 .. 10-Feb-2010]
// - second order valid in [10-Feb-2010 .. end_of_time]
customer.getOrders().set(secondOrder, TimeUtils.from(TimeUtils.day(10, 2, 2010)));
