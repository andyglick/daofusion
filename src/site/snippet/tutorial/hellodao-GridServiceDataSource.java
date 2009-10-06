/**
 * Generic GWT RPC data source that supports common grid-like operations via GridService.
 */
public abstract class GridServiceDataSource<DTO extends IsSerializable, SERVICE extends GridServiceAsync<DTO>>
        extends GwtRpcDataSource {

    private final SERVICE service;

    public GridServiceDataSource(SERVICE service, DataSourceField... fields) {
        this.service = service;

        for (DataSourceField f : fields)
            addField(f);

        // record cache is dropped whenever grid criteria changes
        setCriteriaPolicy(CriteriaPolicy.DROPONCHANGE);
    }

    // executeFetch, executeAdd, executeUpdate and executeRemove implementations go here

    protected abstract DTO newDtoInstance();

    protected abstract void copyValues(ListGridRecord from, DTO to);

    protected abstract void copyValues(DTO from, ListGridRecord to);

}
