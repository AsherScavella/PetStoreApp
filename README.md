# **🐾 PetStoreApp**
A simple Java console program used to manage and track pet store inventory.

---

## **Table of Contents**

- [Authors](#-authors)
- [Project Overview](#-project-overview)
- [Project Structure](#-project-structure)
- [Input Validation Rules](#-input-validation-rules)
- [Concepts Demonstrated](#-concepts-demonstrated)
- [Example Run/Testing](#-example-runtesting)

---

## **👥 Authors**

- **Asher Scavella**

🔗 **Repository:**  
https://github.com/AsherScavella/PetStoreApp

---

## **📌 Project Overview**

This project is a Java Pet Store management application that allows a user to manage and track pet inventory. The program keeps track of different types of pets and stores their information such as name, date of birth, and description.

The application is built using object-oriented programming, where different classes work together to manage the system. The PetStoreApp class runs the program and controls the menu system. The Pet class represents the base type of all pets, while Bird and Fish are derived classes with their own unique attributes.

The goal of this project is to practice using Java concepts such as classes, objects, inheritance, ArrayLists, methods, and exception handling while building a program that organizes and manages inventory data.

This program allows the user to add pets, delete pets, display inventory, and save/load data from a file, making it easier to manage a pet store system.

---

## **🏗 Project Structure**

### **Pet.java**

The Pet class represents a general pet and serves as the base class.

Each pet has:

- An auto-generated ID  
- A name  
- A date of birth  
- A description  

The Pet class also provides methods to display pet information and format output.

---

### **Bird.java**

The Bird class extends the Pet class and represents a bird.

Each bird has:

- Ability to fly (true/false)  
- Nest type (BURROW, CUP, DOME)  

The Bird class inherits from Pet and adds additional attributes specific to birds.

---

### **Fish.java**

The Fish class extends the Pet class and represents a fish.

Each fish has:

- Migratory status (true/false)  
- Water type (BOTH, FRESH, SALT)  

The Fish class inherits from Pet and adds attributes specific to fish.

---

### **PetStoreApp.java**

The PetStoreApp class is the main program that runs the system.

This class controls the flow of the program and interacts with the user through a menu system.

The PetStoreApp class can:

- Add pets (Pet, Bird, Fish)  
- Delete pets by ID  
- Display inventory  
- Save inventory to a file  
- Load inventory from a file  

This class uses an ArrayList to store Pet objects and manages all operations.

---

### **Input.java**

The Input class is used to handle user input and validation.

This class ensures:

- Strings are not empty  
- Numbers are valid  
- Dates follow the correct format  

---

## **🛡 Input Validation Rules**

- Name cannot be blank  
- Date must be in MM-DD-YYYY format  
- Menu choices must be within range  
- Pet type must be valid (1–3)  
- Delete ID must exist  

---

## **💡 Concepts Demonstrated**

- Object-Oriented Programming  
- Inheritance (Pet → Bird, Fish)  
- Polymorphism (method overriding)  
- Encapsulation  
- ArrayLists  
- Enums (NestType, WaterType)  
- File I/O (BufferedReader / BufferedWriter)  
- Exception Handling  
- Input Validation  
- Menu-driven program design  

---

## **🧪 Example Run/Testing**

## Results

## 🖼️ Program Output


### Add Pet
![image alt](https://github.com/AsherScavella/PetStoreApp/blob/a1b46278f89f98c4dcd406c044abeac6ae3fa393/Addpet2.png)

### Add Pet Example 2
![Add Pet 2](assets/add_pet2.png)

### Delete Pet
![image alt](https://github.com/AsherScavella/PetStoreApp/blob/91531af74512117f1f962ecac8da6be78007e5b1/DeletePetID.png)

### Add Fish
![image alt](https://github.com/AsherScavella/PetStoreApp/blob/ee54f5a21c172b578bd7e943fed8b2069c4bb0d9/Fish.png)


### Invalid Date Handling
![image alt]

### Add Bird
![image alt](https://github.com/AsherScavella/PetStoreApp/blob/698be6dbb842869edf3aa94b1eaf7ac0e22407ef/testBird.png)

### Save Inventory
![image alt](https://github.com/AsherScavella/PetStoreApp/blob/381c37147eb9ad84207e7e8f59eb9d0e8b06fbf4/savingdata.png)

### Load Inventory
![image alt]




