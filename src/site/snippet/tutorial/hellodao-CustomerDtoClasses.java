public class CustomerDto extends AbstractDto {

    // direct properties
    private String firstName;
    private String lastName;

    // nested properties
    private String contactEmail;
    private String contactPhone;

    // collection property
    private Integer totalOrders;

    // getters and setters go here

}

public abstract class AbstractDto implements IsSerializable {

    // ListGrid records should define a unique key,
    // in our case this will be the database id
    private String id;

    // getter and setter goes here

}
