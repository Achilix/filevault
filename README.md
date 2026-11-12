# FileVault

FileVault is a Java Swing desktop application for organizing and managing files. It uses FlatLaf for a modern dark interface.

## Features

- Dashboard overview
- File browsing and management
- File categories
- Duplicate-file view
- Backup tools
- Application settings

## Requirements

- Java Development Kit (JDK) 17 or newer
- Apache Maven 3.8 or newer

Verify the installed tools with:

```powershell
java -version
mvn -version
```

## Run

From the project root, compile and start the application:

```powershell
mvn compile org.codehaus.mojo:exec-maven-plugin:3.5.0:java "-Dexec.mainClass=com.filevault.Main"
```

The quotes around the `-D` property are important when running Maven from PowerShell.

## Build

Compile the project without starting the application:

```powershell
mvn compile
```

Clean generated build output:

```powershell
mvn clean
```

## Project Structure

```text
src/
  main/
    java/com/filevault/
      Main.java          Application entry point
      MainFrame.java     Main application window
      *Panel.java        Dashboard and feature panels
  test/
    java/                Test sources
pom.xml                 Maven configuration
```

## License

This project does not currently declare a license.
