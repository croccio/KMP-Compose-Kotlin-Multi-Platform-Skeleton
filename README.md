# Kotlin Multiplatform (KMP) Project Skeleton 🚀

This repository provides a **foundational structure** for a Kotlin Multiplatform (KMP) project using **Compose**, supporting **Android, iOS, desktop, and web** applications. It includes essential features such as **navigation, dependency injection, and other necessary components** to streamline full app development.

⚠️ **Work in Progress**: This project is still evolving, and some parts may change over time.

💡 **Contributions Welcome!** If you have improvements or fixes, feel free to open a **Pull Request (PR)**—your contributions are greatly appreciated

☑️ **TODO**
- [x] [Buildable projects for Android, iOS, desktop, web](#buildable-projects-for-android-ios-desktop-web)
- [ ] Dependency injection
- [ ] Navigation
- [ ] Navigation with Parameter
- [ ] Architecture
- [ ] Rest client
- [ ] Tests
- [ ] Convert DI to separated library
- [ ] Convert Navigation to separated library
- [ ] Convert Rest Client to separated library
- [ ] ...

### Buildable projects for Android, iOS, desktop, web
The project is based on KMP - Compose framework, so we use kotlin for the business logic and compose to build the UI.
As you can see in the project structure we have on module called _composeApp_ with five submodule:
- **commonMain**: contains the common code (business logic and UI) for all platforms
- **androidMain**: contains the Android project that use the common code
- **desktopMain**: contains the Desktop project then use the common code
- **iosMain**: contains the code that is built as a library to use by the _iosApp_
- **wasmJsMain**: contains the code that is built as a library used by the _web app_

