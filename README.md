# University Final Project
The following program was designed and made on purpose as a requirement to conclude the second module, Java Basics, 
of the bootcamp Code Your Future: Testing Fundamentals and Automation.
____________________________________________________________________________________________
## Author: Gustavo Ropero
### Introduction
This repository contains an UML Class Diagram which tries to illustrate the best way to design the required program. Additionally,
files contains the developed program divided in two packages: models and principal. First stores the classes that compound all program structure,
while second one has the main class which controls the execution and menu.
### Packages
### 1. Models
- *Teacher*: The attributes were _name_ and _baseSalary_, but the salary depended on teacher category, so it was decided to create an abstract class called _salary()_.
  In adtion, it was made a boolean attribute called _isFullTime_ to ease the initialization of different type of teachers.
- *FullTimeTeacher*: This class inherited from Teacher, but modified _salary()_ according to the requirement, so a new attribute was added: _yearsExperience_.
- *PartTimeTeacher*: This class inherited from Teacher, but modified _salary()_ according to the requirement, so a new attribute was added: _activeHours_.
- *Student*: Only contains three attributes: _name_, _age_, _idStudent_.
- *Class*: The attributes are four: _teacher, _classroom_, _studentList_ and _name_. Besides, four methods were created to develop the requirements:
  - _getStudentList()_: prints student id next to student name
  - _getStudent_List()_: it's the getter from the attribute _studentList_. The reason due to its creation, must be to previously have created _getStudentList()_.
  - _addStudent(Student student)_: adds an student to _studentList_.
  - _printClassInfo()_: prints the basic data from the class.
- *University*: The porpuse of this class is initialize all the necessary prerrequisites to execute the methods which fullfil the expected requirements. For that,
  the attributes are lists of teacher, students and classes, and methods constitute the options of "principal menu":
  - _constructor_: initializes the minimum requirements to create the university object according to the requirement.
  - _printStudents()_: prints all the students in university.
  - _printTeachers()_: prints all the teachers in university.
  - _printClasses()_: prints all the classes in university. Also, asks if someone wants basic data of the class to throws _submenuClass()_.
  - _submenuClass()_: calls the method _printClassInfo()_.
  - _newStudent()_: creates a new object _student_ (initializes student class).
  - _newClass()_: creates a new object _class_ and begin a cycle to add students.
  - _searchStudent()_: searches all classes where a specific student is into.
### 2. Principal
- *Principal:* controls the print menu and each option to called the methods of _University_. On the other hand, it's the responsable from finish the execution.
