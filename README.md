# Address Book CLI

A standalone Command‑Line Interface for the Address Book application.  
Provides core contact management features—CRUD operations, JSON persistence, search and validation.

### Repository Structure

```
Address-Book-CLI/                     ← Top-level repository
├── README.md                         ← Overview, usage, and module guide
├── .gitignore                        ← Files and folders to ignore in Git
├── LICENSE
│── build.gradle                      ← Gradle build script for the CLI module
│── build/                            ← Gradle output: compiled classes (`.class`) and JARs (auto-generated)
│── src/
│   └── com/addressbook/
│       │── App.java                  ← Entry point and main menu loop (Menu, InputReader)
│       ├── Contact.java              ← Domain class representing contacts
│       ├── Service.java               ← Core logic: AddressBook, Command interface, Add/Edit/Delete commands
│       └── Utility.java              ← Serializer (JSON & vCard extractor), Validator
└── data/
    └── addressbook.json              ← Default JSON persistence file

```
<!-- ├── .github/                      ← GitHub configuration: CI/CD, issue & PR templates, project board
│   ├── workflows/ci.yml
│   ├── ISSUE_TEMPLATE/
│   └── PULL_REQUEST_TEMPLATE.md -->
### Project Overview

This project Address Book application implements:
  - Create, Read, Update, Delete (CRUD) of contacts
  - Stores data like name, address, phone numbers, and emails
  - JSON-based persistence (load on startup, save on exit)
  - Validation, duplicate detection, and basic search/filter capabilities

### Getting Started 

1. **Clone the repository**
   ```bash
   git clone https://github.com/PhantomBenz/Address-Book-CLI.git
   cd Address-Book-CLI/
   ```

2. **Build and Run**

   * **Gradle**:

     ```bash
     gradle build
     gradle run
     ```

3. **Usage**

   * On startup, existing contacts are loaded from `data/addressbook.json` (if present).
   * Follow the on-screen menu to add, list, search, edit, or delete contacts.
   * On exit, all changes are saved back to `data/addressbook.json`.

---

## Usage Examples

```
=== Address Book CLI ===

1) Add Contact
2) List All Contacts
3) Search Contacts
4) Edit Contact
5) Delete Contact
0) Exit
Enter choice: 
```

---

<!-- ### Contributing

See [CONTRIBUTING.md](.github/CONTRIBUTING.md) for guidelines on reporting issues, submitting pull requests, and coding conventions. -->


## License

This module is distributed under the [GNU License](LICENSE).

---

— Built by **The G's** | © 2025
