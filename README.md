## Address Book

A modular Java-based Address Book application designed to start with a powerful Command-Line Interface (CLI) and extend later into a GUI (JavaFX or Swing).

### Repository Structure

```
Address-Book/                        ← Top-level repository
├── README.md                        ← Overview, usage, and module guide
├── .gitignore                       ← Files and folders to ignore in Git
│
├── address-book-cli/                ← CLI module: core functionality and persistence
│   ├── README.md                    ← CLI-specific instructions and usage examples
│   ├── build.gradle                 ← Gradle build script for the CLI module
│   ├── build/                       ← Gradle output: compiled classes (`.class`) and JARs (auto-generated)
│   └── src/
│       └── com/addressbook/
│           ├── main/
│           │   └── App.java         ← Entry point and main menu loop (Menu, InputReader)
│           ├── model/
│           │   └── Contact.java     ← Domain class representing contacts
│           ├── service/
│           │   └── Service.java     ← Core logic: AddressBook, Command interface, Add/Edit/Delete commands
│           ├── util/
│           │   └── Utility.java     ← Serializer (JSON & vCard extractor), Validator
│           └── data/
│               └── addressbook.json ← Default JSON persistence file
│
└── address-book-gui/                ← Future GUI module: JavaFX or Swing implementation
    ├── README.md                    ← GUI-specific planning and setup notes
    └── build.gradle                 ← Gradle build script for the GUI module
```

### Project Overview

This project splits the Address Book application into two modules:

- **CLI Module** (`address-book-cli`) implements:
  - Create, Read, Update, Delete (CRUD) of contacts
  - Multiple phone numbers, emails, tags, and GitHub profile links per contact
  - JSON-based persistence (load on startup, save on exit)
  - Validation, duplicate detection, and basic search/filter capabilities
  - Undo/Redo support via Command Pattern

- **GUI Module** (`address-book-gui`) (coming soon) will provide:
  - A graphical interface (JavaFX or Swing)
  - Interactive forms for contact management
  - Enhanced sorting, filtering, and visualization features

### Getting Started (CLI)

1. **Clone the repository**
   ```bash
   git clone https://github.com/PhantomBenz/Address-Book.git
   cd Address-Book/address-book-cli
   ```

2. **Build and Run**

   * **Gradle**:

     ```bash
     ./gradlew build
     ./gradlew run --args=''
     ```

3. **Usage**

   * On startup, existing contacts are loaded from `data/addressbook.json` (if present).
   * Follow the on-screen menu to add, list, search, edit, or delete contacts.
   * On exit, all changes are saved back to `data/addressbook.json`.
<!-- ├── .github/                      ← GitHub configuration: CI/CD, issue & PR templates, project board
│   ├── workflows/ci.yml
│   ├── ISSUE_TEMPLATE/
│   └── PULL_REQUEST_TEMPLATE.md -->
<!-- 
### Contributing

See [CONTRIBUTING.md](.github/CONTRIBUTING.md) for guidelines on reporting issues, submitting pull requests, and coding conventions.

### Roadmap

* **v0.1**: Core CLI features + JSON persistence
* **v0.2**: Validation, tagging, undo/redo
* **v0.3**: Import/export (CSV/vCard), grouping
* **v1.0**: GUI module release -->

---

— Built by **The G's** | © 2025
