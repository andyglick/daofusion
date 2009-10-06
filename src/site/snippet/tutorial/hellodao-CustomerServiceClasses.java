@RemoteServiceRelativePath(HelloDAO.RPC_SERVICE_RELATIVE_PATH)
public interface CustomerService extends GridService<CustomerDto> {

    // add some business related methods here
    // (don't forget to test them too)

}

public interface GridService<DTO extends IsSerializable> extends RemoteService {

    ResultSet<DTO> fetch(CriteriaTransferObject cto) throws ServiceException;

    DTO add(DTO dto) throws ServiceException;

    DTO update(DTO dto) throws ServiceException;

    void remove(DTO dto) throws ServiceException;

}

public class ResultSet<DTO extends IsSerializable> implements IsSerializable {

    private List<DTO> resultList;
    private Integer totalRecords;

    // for serialization purposes
    protected ResultSet() {
    }

    public ResultSet(List<DTO> resultList, Integer totalRecords) {
        this.resultList = resultList;
        this.totalRecords = totalRecords;
    }

    public List<DTO> getResultList() {
        return resultList;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

}
