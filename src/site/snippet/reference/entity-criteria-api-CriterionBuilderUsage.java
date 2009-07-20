FilterCriterion filterCriterion = new FilterCriterionBuilder(
        associationPath, targetPropertyName, LIKE_USING_FILTER_OBJECT)
    .filterObjectValuePaths("projectManager.contactInfo.email")
    .build();
