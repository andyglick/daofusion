BitemporalProperty<Long, BitemporalLong> numOfChildren  = new BitemporalProperty<Long, BitemporalLong>(numberOfChildren, new LongValueAccessor());

// set transaction time to system time
TimeUtils.setReference(new DateTime());

// set value to 5 -> at current time we know person has now 5 children
numOfChildren.set(5L);

// set value to 10 -> at current time we know person has 5 children starting at date 12.4.2010.
numOfChildre.set(10L, TimeUtils.from(new DateTime("12.4.2010"));

