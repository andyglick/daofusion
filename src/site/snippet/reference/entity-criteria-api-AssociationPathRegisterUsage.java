AssociationPathRegister register = new AssociationPathRegister(targetCriteria);

AssociationPath associationPath = new AssociationPath(
    new AssociationPathElement("projectManager", NestedPropertyJoinType.LEFT_JOIN),
    new AssociationPathElement("contactInfo") // default join type is INNER_JOIN
);

// resulting criteria is cached within the register for subsequent calls
Criteria criteria = register.get(associationPath);
