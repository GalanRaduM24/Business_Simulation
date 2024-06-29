# Business Simulation System

## Overview 
This project is a business simulation system where you can manage a company with various departments, projects, and employees. The system provides functionalities for creating departments, hiring and dismissing employees, starting and finishing projects, and more.

## Project Stucture
The project is organized into several packages and classes, each handling different aspects of the system:

1. BusinessSimulation: Contains the main entry point of the application and other essential classes like `Job` and `Project`.

- `Main`: The entry point of the application where the main menu and user interactions are handled.
- `Job`: Represents a job position within the company, including salary and start date.
- `Project`: Represents a project within the company, including the project name, deadline, and completion status.

2. BusinessSimulation.company: Contains classes related to the company structure and departments.

- `Company`: Represents the company, managing departments and employees.
- `Departament`: Represents a department within the company, handling employees, projects, and sub-departments.
- `HumanResorces`: Manages employee-related operations like hiring and dismissing employees.

3.BusinessSimulation.person: Contains classes related to the employees of the company.

- `Person`: Represents an individual employee, including personal details and job assignments.

4. BusinessSimulation.util: Contains utility classes, such as `Date`, which is used for handling date-related operations in the system.

## User Interaction
When you run the application, you'll interact with it through a console-based menu. Here are the available options:

- **Create Departments:** Add new departments to the company.
- **Hire Employee:** Hire a new employee by entering their details.
- **Dismiss Employee:** Dismiss an existing employee by entering their name.
- **Start a New Project:** Initiate a new project within a specified department.
- **Sell a Project:** Remove a project from a department and mark it as sold.
- **Finish a Project:** Mark a project as completed.
- **Check Departments List:** Display the list of all departments.
- **Check Person List:** Display the list of all employees.
- **Check Person Details:** Display details of a specific employee.
- **Create SubDepartment:** Add a new sub-department within an existing department.
- **Check if Project is Finished:** Verify if a project has been completed.
- **See Salary:** Display and sort all jobs by salary in descending order.

Example: Reading Employees from File
The system can initialize employees from an external file. The file format should be as follows:

```
<number_of_employees>
<name>, <birth_year> <birth_month> <birth_day>, <registry_number>, <is_manager>, <salary>, <start_year> <start_month> <start_day>, <department_name>, <project_name>, <project_deadline_year> <project_deadline_month> <project_deadline_day>
```

Example content for employees.txt:
```
4
Radu, 2000, 4, 20, 1, true, 200, 2020, 5, 16, IT, ProjectMare, 2022, 9, 7
Marius, 2005, 2, 21, 2, false, 300, 2021, 12, 22, PR, PRproject, 2023, 11, 31
Andrei, 2001, 7, 30, 3, true, 400, 2022, 6, 13, SM, ProjectSocial, 2023, 8, 7
Ana, 2010, 1, 9, 4, false, 300, 2023, 12, 7, SM, ProjectSocial, 2023, 12, 8
```

## How to Run the Program

- Setup: Ensure you have Java installed on your system.
- Compile the Code: Compile the Java code using your preferred IDE or the command line.
- Run the Program: Execute the Main class to start the application.