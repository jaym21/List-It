# List-It
List It is an android app in Kotlin, which helps the user to note the things they want to remember to do.

![main_page](https://user-images.githubusercontent.com/48640844/103473518-7ad7fe00-4dbf-11eb-823e-1af6308e2a13.png)

This app is made to understand the implementation of Android Architecture Components.
- This app uses Room Database which has entity which defines the schema of database and DAO(Data Access Object) which is used to communicate with database and maps SQL queries to functions
- Repository is a simple class which is used to provide cleaner API to ViewModel to communicate with DAO.
- ViewModel is used as communication between UI and Repository.It acts as observer on LiveData and only updates the UI when data is actually changed.
- This app uses LiveData, which is basically a data holder class which can be observed.It always contains the latest version of data and notifys the observer about data changes.

![Android Architecture Components](https://user-images.githubusercontent.com/48640844/103457142-875a4900-4d22-11eb-8a79-f9b328f806ee.png)


