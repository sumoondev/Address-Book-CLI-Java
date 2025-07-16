# Address Book CLI

A standalone Command‑Line Interface for the Address Book application.  
Provides core contact management features—CRUD operations, JSON persistence, search, validation, and vCard import/export.

---

## Table of Contents

- [Features](#features)  
- [Prerequisites](#prerequisites)  
- [Getting Started](#getting-started)  
  - [Clone & Build](#clone--build)  
  - [Run the CLI](#run-the-cli)  
- [Usage Examples](#usage-examples)  
- [Configuration](#configuration)  
- [Project Layout](#project-layout)  
- [Testing](#testing)  
- [License](#license)

---

## Features

- **Create, Read, Update, Delete** contacts  
- Store **multiple** phone numbers & email addresses per contact  
- Assign **tags** (e.g. “family”, “work”) and a **GitHub URL**  
- **Search** by name, phone, email, or tag (case‑insensitive)  
- **JSON persistence**: automatically load/save from `data/addressbook.json`  
- **vCard (.vcf) import & export** via the Command Pattern  
- **Validation** of phone numbers, email syntax, and URL format  
- **Undo/Redo** support (last 10 operations)

---

## Prerequisites

- Java 11 or higher  
- [Gradle](https://gradle.org/) (if you prefer the wrapper, see below)  
- (Optional) `git` for source control  

---

## Getting Started

### Clone & Build

```bash
# Clone the top-level repo, then enter the CLI module
git clone https://github.com/PhantomBenz/Address-Book.git
cd Address-Book/address-book-cli/

# Build with Gradle wrapper (recommended)
./gradlew build
````

If you have Gradle installed globally, you can instead run:

```bash
gradle clean build
```

---

### Run the CLI

```bash
# Using Gradle wrapper
./gradlew run

# Or run the JAR directly:
java -jar build/libs/address-book-cli.jar
```

On startup, the app will:

1. Load existing contacts from `data/addressbook.json` (if it exists).
2. Present the main menu.

---

## Usage Examples

```
=== Address Book CLI ===

1) Add Contact
2) List All Contacts
3) Search Contacts
4) Edit Contact
5) Delete Contact
6) Import vCard (.vcf)
7) Export Contact to vCard
8) Undo Last Action
9) Redo Last Action
0) Exit
Enter choice: 
```

* **Add Contact**: follow prompts to enter name, phones, emails, address, GitHub URL, tags, birthday.
* **Search**: enter a keyword to match against name, phone, email, or tags.
* **vCard Import**: supply path to a `.vcf` file; all contacts contained will be merged.
* **vCard Export**: select a contact by ID, then provide output file path.
* **Undo/Redo**: step backward or forward through your last 10 operations.

---

## Configuration

You can adjust:

* **Data file location**

  * Default: `address-book-cli/data/addressbook.json`
  * To override, set the environment variable `AB_DATA_FILE`, e.g.

    ```bash
    export AB_DATA_FILE=~/mycontacts.json
    ./gradlew run
    ```

* **Max undo history**

  * Default: 10 operations
  * Override via system property:

    ```bash
    ./gradlew run --args='-Dab.undo.limit=20'
    ```

---

## Project Layout

```
address-book-cli/
├── README.md                   
├── build.gradle                
├── build/                              ← (`.class`, JARs)
├── data/
│   └── addressbook.json                ← JSON persistence file
└── src/
    ├── com/addressbook/
    │       ├── main/App.java           ← Entry point & menu loop
    │       ├── model/Contact.java      ← Contact domain class
    │       ├── service/Service.java    ← AddressBook, Command interface & implementations
    │       └── util/Utility.java       ← JSON & vCard (de)serialization, validators
    └── test/
        └── com/addressbook/            ← test files
```

---

## Testing

Run unit tests 

<!-- A coverage report is available at `build/reports/jacoco/test/html/index.html`. -->

---

## License

This module is distributed under the [GNU License](../LICENSE).
See the top‑level `LICENSE` file for details.