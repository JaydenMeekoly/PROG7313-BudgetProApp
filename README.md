PROG7131 POE part2 

Group Members:
Jayden Meekoly - st10306957
Joshua John Pillai - st10272691
Kyle James Pillay - st10226298
Brad Francis - st10337861

BudgetProApp

BudgetProApp is an Android application designed to help users manage their expenses effectively. It allows users to add, view, and track their expenses, providing a simple and intuitive interface for personal finance management.

Features

*   Add Expenses: Easily add new expenses with details such as title, amount, date, note, and category.
*   View Expenses: View a list of all expenses, sorted by date in descending order.
*   Data Persistence: Utilizes Room Persistence Library to store expense data locally on the device.
*   Clean Architecture: Follows a clean architecture pattern, separating concerns into UI, data, and domain layers.
* Login: The user can login to the application.

Tech Stack

   Kotlin: The primary programming language.
   Android Jetpack:
    *   Room: For local data persistence.
    *   LiveData: For reactive data updates.
    *   View Binding: For simplified view access.
*   Coroutines: For asynchronous operations.
*   RecyclerView: For displaying lists of expenses.
*   AppCompat: For backward compatibility.
* Gradle: For building the application.

Architecture

The application follows a clean architecture pattern:

*   UI Layer: Activities and Adapters handle user interface and interactions.
*   Data Layer:
    *   Repository: `ExpenseRepository` provides a clean API for data access.
    *   DAO: `ExpenseDao` defines database operations.
    *   Database: `AppDatabase` manages the Room database.
    *   Entities: `Expense` defines the data structure.
  Login: The user can login to the application.

Getting Started

1.  Clone the repository:
(Replace `your-username` with your GitHub username.)
2.  Open in Android Studio: Open the project in Android Studio.
3.  Build and Run: Build and run the application on an emulator or physical device.

Dependencies

The project uses the following dependencies:

*   androidx.databinding:viewbinding:8.8.1
*   androidx.core:core-ktx:1.12.0
*   androidx.core:core:1.12.0
*   androidx.annotation:annotation-experimental:1.3.0
*   androidx.lifecycle:lifecycle-runtime:2.6.2
*   androidx.versionedparcelable:versionedparcelable:1.1.1
*   androidx.appcompat:appcompat:1.6.1
*   androidx.activity:activity:1.8.0
*   androidx.lifecycle:lifecycle-viewmodel:2.6.2
*   androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.2
*   androidx.lifecycle:lifecycle-livedata-core:2.6.2
*   androidx.savedstate:savedstate:1.2.1
*   androidx.appcompat:appcompat-resources:1.6.1
*   androidx.vectordrawable:vectordrawable:1.1.0
*   androidx.vectordrawable:vectordrawable-animated:1.1.0
*   androidx.interpolator:interpolator:1.0.0
*   androidx.cursoradapter:cursoradapter:1.0.0
*   androidx.drawerlayout:drawerlayout:1.1.1
*   androidx.customview:customview:1.1.0
*   androidx.fragment:fragment:1.3.6
*   androidx.viewpager:viewpager:1.0.0
*   androidx.loader:loader:1.0.0
*   androidx.lifecycle:lifecycle-livedata:2.6.2
*   androidx.arch.core:core-runtime:2.2.0
*   androidx.cardview:cardview:1.0.0
