# LoginDashboardApp

LoginDashboardApp is an Android application designed to demonstrate proficiency in API integration, user interface design, and best practices in Android development. The app features a login screen, a dashboard displaying a list of entities retrieved from an API, and a details screen to provide more information on each entity.

## Features

- **Login Screen**: Users can log in with their first name and student ID.
- **Dashboard Screen**: Displays a list of entities retrieved from the server using a RecyclerView.
- **Details Screen**: Provides detailed information about a selected entity from the dashboard.
- **Dependency Injection**: Implements dependency injection using Hilt for a modular and testable architecture.
- **MVVM Architecture**: The app is organized using MVVM (Model-View-ViewModel) architecture for better separation of concerns and easier testing.

## Screens Overview

1. **Login Screen**: Allows users to authenticate with their first name and student ID. A successful login returns a keypass, which is used to fetch data for the dashboard.

2. **Dashboard Screen**: Displays a list of entities fetched from the server using the keypass obtained during login. Each entity is displayed in a RecyclerView.

3. **Details Screen**: Displays all available information about a selected entity, including its description.

## Technical Stack

- **Language**: Kotlin
- **Dependency Injection**: Hilt
- **Networking**: Retrofit with Gson converter
- **Architecture**: MVVM (Model-View-ViewModel)
- **Coroutines**: For asynchronous operations
- **ViewModel and LiveData**: To manage UI-related data
- **RecyclerView**: For displaying the list of entities

## Installation and Setup

### Prerequisites

- **Android Studio**: Make sure you have the latest version of Android Studio installed.
- **Gradle**: Gradle setup is handled automatically by Android Studio.

### Cloning the Repository

To get started, clone this repository using:

```sh
git clone <https://github.com/NEWT1111/LoginDashboardApp.git>
```

### Running the App

1. **Open the Project in Android Studio**: Navigate to the root folder and open the project in Android Studio.
2. **Sync Gradle**: Sync Gradle files by clicking `File > Sync Project with Gradle Files`.
3. **Run the App**: Connect an Android device or start an emulator and click on the `Run` button.

Note: The project currently has two build errors that prevent it from running successfully. These errors are related to Hilt dependency injection setup and can be resolved by ensuring all required Hilt annotations are applied correctly, and the project is built cleanly.

## Dependencies

The project utilizes the following dependencies:

- **Retrofit**: For API communication.
  ```groovy
  implementation "com.squareup.retrofit2:retrofit:2.9.0"
  implementation "com.squareup.retrofit2:converter-gson:2.9.0"
  ```

- **Hilt for Dependency Injection**:
  ```groovy
  implementation "com.google.dagger:hilt-android:2.44"
  kapt "com.google.dagger:hilt-compiler:2.44"
  ```

- **Lifecycle Components**: For ViewModel and LiveData.
  ```groovy
  implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
  implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
  ```

- **RecyclerView**: For displaying the list of entities.
  ```groovy
  implementation "androidx.recyclerview:recyclerview:1.2.1"
  ```

## Project Structure

- **`LoginActivity`**: Handles user authentication.
- **`DashboardActivity`**: Displays a list of entities in a RecyclerView.
- **`DetailsActivity`**: Shows detailed information for a selected entity.
- **ViewModel**: `LoginViewModel`, `DashboardViewModel` to manage business logic and expose LiveData to activities.
- **Repository**: `AuthRepository` for login operations, `DashboardRepository` for fetching dashboard data.

## Issues and Troubleshooting

### Current Issues

- **Build Errors**: There are currently two build errors related to Hilt dependency injection.
  - **Cause**: The errors likely stem from missing or incorrect `@HiltViewModel`, `@AndroidEntryPoint`, or incorrect configuration in `build.gradle`.
  - **Solution**: Ensure all ViewModel classes are properly annotated with `@HiltViewModel`, activities are annotated with `@AndroidEntryPoint`, and that the `@HiltAndroidApp` annotation is applied to the Application class.

- **Generated Hilt Components Not Found**: This is due to Hilt's inability to generate the necessary components. Invalidate caches and restart Android Studio, then perform a clean build.

### How to Fix the Errors

- **Clean and Rebuild**: Run `Build > Clean Project` followed by `Build > Rebuild Project`.
- **Invalidate Caches**: Click on `File > Invalidate Caches / Restart` to ensure that Android Studio regenerates all necessary files.

## Testing

- **Unit Tests**: The project includes setup for unit testing using JUnit and Mockito.
  - **LoginViewModel Unit Test**: To test the login functionality and assert that the login result is set correctly.

- **Instrumented Tests**: The project structure supports UI testing using Espresso. Tests should be added in the `androidTest` directory.

## Git Usage

The repository uses Git for version control with meaningful commit messages to describe changes. The history includes milestones such as:

- Initial project setup.
- Adding Hilt dependency injection.
- Implementing login functionality.
- Creating dashboard and details screens.

### Example Commit Messages

- `feat: Implement login screen UI and ViewModel`
- `chore: Add Hilt dependency and setup application class`
- `fix: Correct Hilt annotation errors in DashboardViewModel`


## Contributing

If you would like to contribute to this project, please fork the repository and create a pull request with your changes. All contributions are welcome!

