# 🏦 Banking Service - Technical Test Implementation

A robust and clean implementation of a core banking system featuring deposit, withdrawal, and transaction statement operations.

## 📋 Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Architecture](#architecture)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Design Decisions](#design-decisions)
- [Project Planning](#project-planning)

## 🎯 Overview

This project implements a simplified banking account system that demonstrates:
- **Clean code practices** with separation of concerns
- **Proper exception handling** for invalid operations
- **Immutable transaction records** for data integrity
- **Interface-based design** following SOLID principles

### Project Specification

The implementation follows a technical test specification requiring:

**Given** a client makes a deposit of 1000 on 10-01-2012  
**And** a deposit of 2000 on 13-01-2012  
**And** a withdrawal of 500 on 14-01-2012  
**When** they print their bank statement  
**Then** they would see:

```
Date       | Amount  | Balance
--------------------------------
14/01/2012 |   -500 |   2500
13/01/2012 |   2000 |   3000
10/01/2012 |   1000 |   1000
```

## 🛠️ Requirements

- **Java**: 8 or higher (uses `LocalDate` and functional features)
- **Build Tool**: Maven

## 🏗️ Architecture

### Project Structure

```
src/main/java/com/banking/
├── entity/
│   └── Transaction.java          # Immutable transaction record
├── service/
│   ├── AccountService.java       # Public interface (contract)
│   └── Account.java               # Implementation with business logic
└── Main.java                      # Demo application
```

### Design Pattern

The project follows a **layered architecture**:

```
┌─────────────────────────────────┐
│   Presentation Layer (Main)     │
├─────────────────────────────────┤
│   Service Layer (Account)       │
├─────────────────────────────────┤
│   Entity Layer (Transaction)    │
└─────────────────────────────────┘
```

## ✨ Features

### Core Operations

- ✅ **Deposit**: Add funds to the account with automatic date tracking
- ✅ **Withdraw**: Remove funds with balance validation
- ✅ **Print Statement**: Display transactions in reverse chronological order

### Exception Handling

The system validates all operations and throws `IllegalArgumentException` for:

| Validation | Error Message |
|------------|---------------|
| Amount ≤ 0 | "Amount must be positive" |
| Null date | "Date cannot be null" |
| Insufficient balance | "Insufficient balance" |
| Date before last transaction | "Transaction date cannot be before last operation date" |

### Data Integrity

- **Immutable Transactions**: Once created, transaction records cannot be modified
- **Balance Tracking**: Automatic balance calculation after each operation
- **Chronological Validation**: Ensures transactions are recorded in time order

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/HamzaChehlaoui/Banking-Service.git
cd BankingTest1
```

### Build the Project

```bash
mvn clean compile
```

### Run the Application

```bash
mvn exec:java -Dexec.mainClass="com.banking.Main"
```

## 💻 Usage

### Basic Example

```java
import com.banking.service.Account;
import java.time.LocalDate;

// Create an account
Account account = new Account();

// Perform operations
account.deposit(1000, LocalDate.of(2012, 1, 10));
account.deposit(2000, LocalDate.of(2012, 1, 13));
account.withdraw(500, LocalDate.of(2012, 1, 14));

// Print statement
account.printStatement();
```

### Using Interface (Recommended for Production)

```java
import com.banking.service.AccountService;
import com.banking.service.Account;

AccountService account = new Account();

// Use public interface methods (auto-dates with LocalDate.now())
account.deposit(1000);
account.withdraw(500);
account.printStatement();
```

## 🎨 Design Decisions

### 1. Interface Segregation

```java
public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
```

The public interface defines **only essential operations** without exposing implementation details.

### 2. Method Overloading for Testability

```java
// Public API - uses current date
public void deposit(int amount) {
    deposit(amount, LocalDate.now());
}

// Package-private - allows testing with specific dates
void deposit(int amount, LocalDate date) {
    // Implementation
}
```

This approach:
- ✅ Maintains clean public interface
- ✅ Enables testing with historical dates
- ✅ Follows Open/Closed Principle

### 3. Immutable Entities

```java
public class Transaction {
    private final LocalDate date;
    private final int amount;
    private final int balanceAfterOperation;
    // No setters - immutable by design
}
```

**Benefits**:
- Thread-safety
- Predictable state
- Prevents accidental modifications

### 4. Reverse Chronological Display

Transactions are displayed newest-first for better user experience:

```java
for(int i = transactions.size() - 1; i >= 0; i--) {
    // Display transaction
}
```

### 5. Date Format

Uses `dd/MM/yyyy` format as per specification:

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
```

## 📊 Project Planning

### GitHub Projects Board

The development process and task management for this project can be tracked on GitHub Projects:

🔗 **[View Project Planning Board](Yhttps://github.com/users/HamzaChehlaoui/projects/9/views/1)**

The planning board includes:
- ✅ Task breakdown and organization
- ✅ Development workflow tracking
- ✅ Feature implementation progress
- ✅ Issue management

### Demo & Verification

Run `Main.java` to see the acceptance test scenario in action:

```bash
mvn exec:java -Dexec.mainClass="com.banking.Main"
```

**Expected Output**:
```
Date       | Amount  | Balance
--------------------------------
14/01/2012 |   -500 |   2500
13/01/2012 |   2000 |   3000
10/01/2012 |   1000 |   1000
```

The implementation includes comprehensive validation for:
- ✅ Positive amounts only
- ✅ Non-null dates
- ✅ Sufficient balance for withdrawals
- ✅ Chronological date ordering

## 📝 Technical Constraints

As per specification:
- ✅ Uses `int` for amounts (simplified for testing; production would use `BigDecimal`)
- ✅ Uses `ArrayList` for in-memory storage (no persistence layer)
- ✅ Public interface remains unchanged

## 🤝 Contributing

This is a technical test implementation. For improvements or suggestions:

1. Fork the repository
2. Make your changes with clear commit messages
3. Open a pull request

## 📄 License

This project is created as a technical test implementation.

## 👤 Author

**Hamza Chehlaoui**

---

**Note**: This implementation prioritizes **clean code**, **proper validation**, and **maintainability** while strictly adhering to the technical requirements.
