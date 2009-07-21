PersistentEntityCriteria countCriteria = converter.convert(
        new CriteriaTransferObjectCountWrapper(transferObject).wrap(),
        myMappingGroup);

int totalRecords = myDao.count(countCriteria);
