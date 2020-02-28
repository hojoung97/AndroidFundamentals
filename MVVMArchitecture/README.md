# Model View ViewModel Architecture (MVVM)

1. Update Gradle file for 
- Room components
- Lifecycle components

2. Create Entity class: Entity is a class that will represent the data itself
- I will use example data from jsonplaceholder.typicode.com https://jsonplaceholder.typicode.com/posts
- Annotate the enitity class in order to work with Room database (ex. PrimaryKey, ColumnInfo)

3. Create DAO (Data Access Object)
- DAO allows us to communicate with the database by implementing queries (database operations) as methods
- With the above bullet point, DAO is implemented as an abstract class or interface
- I have added query methods such as insert, delete and select
