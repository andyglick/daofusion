/**
 * Retrieves a persistent instance (generic version).
 */
<S extends T> S get(ID id, Class<S> targetEntityClass);

/**
 * Retrieves a persistent instance (convenience version).
 */
T get(ID id);
