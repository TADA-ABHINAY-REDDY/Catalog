# Catalog
#This project is the demonstration for the given problem statment.
Secret for Testcase 1: 3
Secret for Testcase 2: 79836264049851

# Shamir's Secret Sharing Project

This project implements a simplified version of **Shamir's Secret Sharing** algorithm to solve for the constant term \( c \) of a polynomial using a set of encoded roots provided in JSON format.

---

## **Project Structure**

The project follows a modular structure:

```
ShamirSecretSharing/
├── data/                   # Test case JSON files
│   ├── testcase1.json      # Test case 1
│   ├── testcase2.json      # Test case 2
├── lib/                    # External library dependencies
│   ├── json.jar            # org.json library for JSON parsing
├── src/                    # Source code
│   ├── ShamirSecretSharing.java  # Main Java program
├── bin/                    # Compiled Java classes
├── README.md               # Project documentation
```

---

## **How It Works**

The program solves for the constant term \( c \) of a polynomial using the following steps:

### **1. Read Test Cases from JSON Files**
- The input JSON files (e.g., `testcase1.json` and `testcase2.json`) contain:
  - The number of roots provided (`n`).
  - The minimum number of roots required (`k`).
  - Encoded roots in the form of `base` and `value`.
- Example format:

```json
{
  "keys": {
    "n": 4,
    "k": 3
  },
  "1": {
    "base": "10",
    "value": "4"
  },
  "2": {
    "base": "2",
    "value": "111"
  }
}
```

### **2. Decode Y-Values**
- Each root is provided as a key-value pair where:
  - The key represents the \( x \)-coordinate.
  - The value is encoded in a specific base (e.g., binary, decimal, hexadecimal).
- The program decodes the \( y \)-values into integers using the specified base.

### **3. Solve for the Constant Term \( c \)**
- Using Lagrange interpolation or another method, the program computes the polynomial coefficients.
- The constant term \( c \) (the secret) is extracted from the polynomial.

---

## **Setup Instructions**

Follow these steps to set up and run the project:

### **1. Prerequisites**
- Java Development Kit (JDK) version 8 or higher.
- A code editor or IDE (e.g., Visual Studio Code, IntelliJ IDEA, or Eclipse).
- `json.jar` library file included in the `lib/` folder.

### **2. Compile the Program**
1. Navigate to the project directory:
   ```bash
   cd ShamirSecretSharing
   ```
2. Compile the source code with the `json.jar` dependency:
   ```bash
   javac -cp lib/json.jar -d bin src/ShamirSecretSharing.java
   ```

### **3. Run the Program**
Run the program using the compiled files and the `json.jar` dependency:
```bash
java -cp "bin;lib/json.jar" ShamirSecretSharing
```

---

## **Input and Output**

### **Input**
- The program reads test case JSON files from the `data/` folder.
- Each JSON file specifies the roots and their encoded values.

### **Output**
- The constant term \( c \) of the polynomial is printed to the console for each test case.

Example Output:
```
Test Case 1: The secret (c) is 42
Test Case 2: The secret (c) is 123
```

---

## **Challenges and Assumptions**

1. **Constraints:**
   - The coefficients of the polynomial are positive integers.
   - The number of roots provided (\( n \)) is always greater than or equal to \( k \).

2. **Edge Cases:**
   - Input JSON files must be correctly formatted and present in the `data/` directory.
   - If fewer than \( k \) roots are provided, the program cannot solve the polynomial.

---

## **Technical Details**

### **Dependencies**
- `org.json` library for JSON parsing (`json.jar` is included in the `lib/` folder).
- Java's `BigInteger` for handling large numbers.

### **Algorithms Used**
- **Lagrange Interpolation:** Solves for the coefficients of the polynomial using the given \( (x, y) \)-pairs.
- Base conversion to decode \( y \)-values from various bases (e.g., binary, hexadecimal).

---

## **Future Improvements**

1. **Error Handling:**
   - Add validation for malformed or missing JSON files.
   - Handle cases where \( n < k \) to gracefully terminate the program.

3. **Enhanced Flexibility:**
   - Allow users to specify test case file paths via command-line arguments.
   - Use modern build tools like Maven or Gradle for dependency management.

---

## **Contact**
For questions or feedback, feel free to reach out to abhinayreddytada@gmail.com.

---

**Happy Coding!**


