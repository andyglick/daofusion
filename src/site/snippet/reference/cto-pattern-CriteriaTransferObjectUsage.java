public class CtoAwareDataGrid extends DefaultDataGrid {

    private final CriteriaTransferObject cto = new CriteriaTransferObject();

    public void onChangeValue(FilterWidget widget) {
        String propertyId = widget.getPropertyId();
        String value = widget.getValue();
        cto.get(propertyId).setFilterValue(value);
    }

}
