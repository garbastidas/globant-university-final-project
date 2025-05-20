# University Final Project

The following program was designed and made on purpose as a requirement to conclude the second module, Java Basics, of the bootcamp Code Your Future: Testing Fundamentals and Automation.

---

## Author: Gustavo Ropero

### Introduction

This repository contains a [UML Class Diagram](/University Final Project.pdf) which tries to illustrate the best way to design the required program. Additionally, files contain the developed program divided into two packages: models and principal. The first stores the classes that compose all program structure, while the second one has the main class which controls the execution and menu.

### Packages

### 1. Models

- *Teacher*: The attributes are _name_ and _baseSalary_, but the salary depends on the teacher category, so it was decided to create an abstract method called _salary()_. In addition, a boolean attribute called _isFullTime_ was made to ease the initialization of different types of teachers.
- *FullTimeTeacher*: This class inherits from Teacher, but modifies _salary()_ according to the requirement, so a new attribute was added: _yearsExperience_.
- *PartTimeTeacher*: This class inherits from Teacher, but modifies _salary()_ according to the requirement, so a new attribute was added: _activeHours_.
- *Student*: Only contains three attributes: _name_, _age_, _idStudent_.
- *Class*: The attributes are four: _teacher_, _classroom_, _studentList_, and _name_. Besides, four methods were created to develop the requirements:
  - _getStudentList()_: prints student id next to student name.
  - _getStudent_List()_: it's the getter from the attribute _studentList_. The reason for its creation is to have previously created _getStudentList()_.
  - _addStudent(Student student)_: adds a student to _studentList_.
  - _printClassInfo()_: prints the basic data from the class.
- *University*: The purpose of this class is to initialize all the necessary prerequisites to execute the methods which fulfill the expected requirements. For that, the attributes are lists of teachers, students, and classes, and methods constitute the options of the "principal menu":
  - _constructor_: initializes the minimum requirements to create the university object according to the requirement.
  - _printStudents()_: prints all the students in the university.
  - _printTeachers()_: prints all the teachers in the university.
  - _printClasses()_: prints all the classes in the university. Also, asks if someone wants basic data of the class to trigger _submenuClass()_.
  - _submenuClass()_: calls the method _printClassInfo()_.
  - _newStudent()_: creates a new object _student_ (initializes Student class).
  - _newClass()_: creates a new object _class_ and begins a cycle to add students.
  - _searchStudent()_: searches all classes where a specific student is included.

### 2. Principal

- *Principal*: controls the print menu and each option to call the methods of _University_. On the other hand, it is responsible for finishing the execution.

