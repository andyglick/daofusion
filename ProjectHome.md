[![](http://opensource.anasoft.com/daofusion-site/images/top-logo.gif)](http://opensource.anasoft.com/daofusion-site/)<img src='http://opensource.anasoft.com/daofusion-site/images/top-right.gif' /> <sup>Click on the logo to visit official project site.</sup>

_DAO Fusion_ is a lightweight yet comprehensive and extensible Java based [Data Access Object](http://java.sun.com/blueprints/corej2eepatterns/Patterns/DataAccessObject.html) (DAO) pattern implementation built on top of [Java Persistence API](http://java.sun.com/javaee/technologies/persistence.jsp) (JPA) and [Hibernate](http://www.hibernate.org/).

<img src='http://opensource.anasoft.com/daofusion-site/images/dataaccess.png' />

## Features ##

You could think of DAO Fusion as a solid foundation for your own DAO layers, doing most of the usual heavy lifting for you and providing support for common DAO-related tasks and patterns, such as:
  * [Persistent entity model](http://opensource.anasoft.com/daofusion-site/reference/entity-model.html)
> > Model your business domain using a standard persistent entity model with out-of-the-box default persistent entity implementations.
  * [Core DAO classes](http://opensource.anasoft.com/daofusion-site/reference/core-dao-classes.html)
> > Build your DAO layer by extending standard persistent entity DAO interfaces / abstract implementations which already provide most of the usual DAO functionality.
  * [Persistent entity criteria API](http://opensource.anasoft.com/daofusion-site/reference/entity-criteria-api.html)
> > Construct persistent entity criteria with advanced filtering, sorting and paging capabilities and pass them to DAO methods to query for desired results.
  * [Criteria transfer object pattern](http://opensource.anasoft.com/daofusion-site/reference/cto-pattern.html)
> > Use the criteria transfer object (CTO) pattern to construct client-side versions of persistent entity criteria instances and pass them through the chosen communication mechanism to the remote server-side component, employing a CTO converter for seamless CTO-to-criteria transformation.
  * [Bitemporal pattern](http://opensource.anasoft.com/daofusion-site/reference/bitemporal-pattern.html)
> > Add temporal aspects to your business domain, tracking persistent entities in two distinct timelines denoting the validity of facts and your knowledge of such facts throughout the time.

## Integration tests ##

In addition to all of that, DAO Fusion provides an out-of-the-box [integration test support](http://opensource.anasoft.com/daofusion-site/reference/integration-tests.html) based on [JUnit](http://www.junit.org/) and [Spring](http://static.springframework.org/spring/docs/2.5.x/reference/index.html)'s [TestContext framework](http://static.springframework.org/spring/docs/2.5.x/reference/testing.html#testcontext-framework).

<img src='http://opensource.anasoft.com/daofusion-site/images/dbsupport.png' />

Integration tests interact with the chosen database instance and make sure that all standard DAO implementations are properly and thoroughly tested using a non-trivial sample domain model. Note that DAO Fusion is integration-tested against many popular databases, including [MySQL](http://www.mysql.com/), [PostgreSQL](http://www.postgresql.org/), [DB2](http://www.ibm.com/db2), [Oracle 10g](http://www.oracle.com/technology/products/database/oracle10g/index.html) and [MS SQL Server 2000](http://en.wikipedia.org/wiki/Microsoft_SQL_Server).

## Getting started ##

Visit our [official project site](http://opensource.anasoft.com/daofusion-site/) to learn more about DAO Fusion.