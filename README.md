# Java Chat Application (Server-Client)

This repository contains a simple **Java-based Chat Application** demonstrating basic socket programming and multithreading.

🚧 **Note:** Client is currently under development.

---

## ✅ Features (Server)

- Dynamic port binding using `ServerSocket(0)` (OS assigns a free port)
- Accepts a single client connection
- Multithreaded:
  - One thread for reading messages from client
  - One thread for writing messages to client
- Graceful chat termination using `"exit"`

---

## 📁 Project Structure

- Server.java // Fully functional multithreaded server
- Client.java // (Coming Soon)
- README.md // Project documentation


---

## 🚀 How to Run the Server

1. **Compile the server code**:
   javac Server.java
2. **Run the server**:
   java Server

## 🧰 Technologies Used
- Java SE 8+
- Socket Programming (ServerSocket, Socket)
- Multithreading (Thread, Runnable)
- Input/Output streams

## 🔧 Planned Features
- Client-side implementation with matching protocol
- Support for multiple clients (future)
- Message formatting and logging
- Basic UI/UX for terminal or GUI interaction
