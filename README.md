# Enterprise Business & HR Simulation System

[![Java](https://img.shields.io/badge/Java-JDK%2011+-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Paradigm](https://img.shields.io/badge/Paradigm-Object--Oriented%20Programming-blue.svg)]()
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

An object-oriented enterprise management simulator developed in Java. The application simulates the internal operations of a corporate organization—including hierarchical department structuring, employee lifecycle management (recruiting, assignments, dismissals), project management with deadlines, and compensation analysis.

---

## Key Features

- **Hierarchical Organizational Modeling**:
  - Create parent departments and nested sub-departments.
  - Track department-specific project allocations and team member rosters.
- **Comprehensive Employee & HR Lifecycle**:
  - **Recruitment & Dismissal**: Dynamic hiring workflows with personal identity validation and registry numbers.
  - **Job Contracts & Compensation**: Associate positions with salary tiers, employment dates, and rank.
  - **Salary Analytics**: Sort, inspect, and rank all organizational roles by compensation in descending order.
- **Project Portfolio Management**:
  - Initiate projects mapped to specific business units with target deadlines.
  - Assign staff to active initiatives, track completion states, or simulate project divestment/sales.
- **Batch Seeding via Flat-File Ingestion**:
  - Auto-populate companies with complex organizational structures directly from formatted data files (`employees.txt`).

---

## Domain Architecture

```text
┌──────────────────────────────────────────────────────────────────────────┐
│                                 Company                                  │
│  • Structure: createDepartment(), startProject()                         │
│  • HR Lifecycle: hireEmployee(), dismissEmployee()                       │
└──────────────────┬────────────────────────────────────┬──────────────────┘
                   │ manages                            │ manages
                   ▼                                    ▼
┌──────────────────────────────────────┐   ┌───────────────────────────────┐
│              Departament             │   │        Human Resources        │
│  • Nested Sub-departments            │   │  • Employee Roster Directory  │
│  • Assigned Projects & Staff         │   │  • Search by Name             │
└──────────────────┬───────────────────┘   └──────────────┬────────────────┘
                   │ assigned to                          │ employs
                   ▼                                      ▼
┌──────────────────────────────────────┐   ┌───────────────────────────────┐
│               Project                │   │            Person             │
│  • Name & Target Deadlines           │   │  • Profile & Registry Number  │
│  • Completion State Tracking         │◄──┤  • Job Contract & Salary Tier │
└──────────────────────────────────────┘   └───────────────────────────────┘
```

---

## Project Structure

```text
src/
└── BusinessSimulation/
    ├── company/
    │   ├── Company.java          # Root organization orchestrator
    │   ├── Departament.java      # Department & sub-department hierarchy
    │   └── HumanResorces.java    # HR directory and employee management
    ├── person/
    │   └── Person.java           # Employee profile, attributes, and project links
    ├── util/
    │   └── Date.java             # Custom date parsing, formatting, and comparison
    ├── Job.java                  # Role, salary level, and tenure
    ├── Project.java              # Initiative definition, scope, and milestone state
    ├── Main.java                 # Interactive CLI loop & batch file parser
    └── employees.txt             # Initial seed dataset for bulk imports
```

---

## File Ingestion Format (`employees.txt`)

The system supports bootstrapping an entire corporate structure at startup from `employees.txt`:

```text
<number_of_employees>
<name>, <birth_year> <birth_month> <birth_day>, <registry_number>, <is_manager>, <salary>, <start_year> <start_month> <start_day>, <department_name>, <project_name>, <deadline_year> <deadline_month> <deadline_day>
```

**Example Data:**
```text
4
Radu, 2000, 4, 20, 1, true, 200, 2020, 5, 16, IT, ProjectAlpha, 2024, 9, 7
Marius, 2005, 2, 21, 2, false, 300, 2021, 12, 22, PR, PRCampaign, 2024, 11, 30
Andrei, 2001, 7, 30, 3, true, 400, 2022, 6, 13, SM, SocialGrowth, 2025, 8, 7
Ana, 2003, 1, 9, 4, false, 300, 2023, 12, 7, SM, SocialGrowth, 2024, 12, 8
```

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher.

### Compilation & Running

1. **Clone the repository**:
   ```bash
   git clone https://github.com/GalanRaduM24/Business_Simulation.git
   cd Business_Simulation
   ```

2. **Compile the Java sources**:
   ```bash
   javac -d out src/BusinessSimulation/*.java src/BusinessSimulation/*/*.java
   ```

3. **Run the application**:
   ```bash
   # Copy employees.txt to working directory if needed
   cp src/BusinessSimulation/employees.txt .
   java -cp out BusinessSimulation.Main
   ```

4. **CLI Interaction**: Follow the on-screen prompts or enter `END TASK` to exit the application loop.