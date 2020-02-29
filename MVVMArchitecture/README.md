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

4. LiveData class 
- LiveData class is a lifecycle library class that listens to updates or changes in data
- This class makes updating UI or other components that rely on the data to be updated easily by letting them observe the changes in data and be notified automatically upon those changes
- simply wrap the data type of selectAll() method in DAO class with LiveData<>

5. RoomDatabase
- This is a layer on top of the actual database that will perform database operations in the background
- *volatile: declares the data write in the main memory for thread synchronization. All reads and writes through the main memory.
- *singleton: only one instance of the class will ever be instantiated throughout the whole program

6. Repository class
- Repository class abstracts access to data sources. It is not a part of Architecture Component libraries but provide clean API that connects the UI (View) and the backend data sources (Model), separating the two so that they do not directly access each other 

7. ViewModel
- ViewModel is a bridge between the Repository class and the UI
- Being part of lifecycle linrary, ViewModel is lifecycle aware and allows us to save UI data and states in order to recreate them upon configuration changes like screen rotation
- separates UI data from the UI components like Activities and Fragments so the UI only needs to think about displaying the data and not about the data itself. This is even enhanced with the use of LiveData class which updates the data easily.

8. RecyclerView
For myself: Time to review RecyclerView and make sure I can make one without referencing
