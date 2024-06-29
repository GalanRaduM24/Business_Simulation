package BusinessSimulation;

import BusinessSimulation.company.Company;
import BusinessSimulation.company.Departament;
import BusinessSimulation.company.HumanResorces;
import BusinessSimulation.person.Person;
import BusinessSimulation.util.Date;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Company company = new Company();
    static boolean file;

    public static void main(String[] args) throws IOException, ParseException {
        // Load initial employees from file
        readEmployeesFromFile(company);
        file = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome, you can stop by writing END TASK");
        String task = " ";

        while (!"END TASK".equals(task)){
            // Interactive menu for user input
            System.out.println("Would you like to create departments (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)){
                company.createDepartment();
            }

            System.out.println("Would you like to Hire employee (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)){
                System.out.println("Hiring Person:");
                System.out.println("Enter Person Name");
                String name = scanner.nextLine();
                System.out.println("Enter Person BirthDate (format YYYY MM DD):");
                Date birthDate = new Date(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
                System.out.println("Enter Person RegistryNumber");
                int registryNumber = Integer.parseInt(scanner.nextLine());
                Person employee = new Person(name, birthDate, registryNumber);
                company.hireEmployee(file, employee);
            }

            System.out.println("Would you like to Dismiss employee (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)){
                System.out.println("Enter Person Name");
                company.dismissEmployee(HumanResorces.getPersonByName(scanner.nextLine()));
            }

            System.out.println("Would you like to Start a new Project (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                System.out.println("Select Projects Department:");
                Departament projectDept = Departament.getDepartmentByName(company, scanner.nextLine());
                System.out.println("Enter Project Name;");
                String projectName = scanner.nextLine();
                System.out.println("Enter deadLine YYYY MM DD:");
                Date deadLine = new Date(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
                Project newProject = new Project(projectName, deadLine);
                company.startProject(newProject, projectDept);
                System.out.println("Add Person to Project:");
                String personName = scanner.nextLine();
                newProject.addProjectToPerson(company.humanResources.getPersonByName(personName));
                company.humanResources.getPersonByName(personName).getProjects();
            }

            System.out.println("Would you like to Sell a Project (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                System.out.println("Select Projects Department:");
                Departament projectDept = Departament.getDepartmentByName(company, scanner.nextLine());
                System.out.println("Select Projects Name:");
                Project project = Departament.getProjectByName(projectDept.getProjects(), scanner.nextLine());
                company.sellProject(project, projectDept);
            }

            System.out.println("Would you like to Finish a Project (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                System.out.println("Select Projects Department:");
                Departament projectDept = Departament.getDepartmentByName(company, scanner.nextLine());
                System.out.println("Select Projects Name:");
                Project project = Departament.getProjectByName(projectDept.getProjects(), scanner.nextLine());
                company.finishProject(project, projectDept);
            }


            System.out.println("Would you like to Check DepartmentsList (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                company.getDepartmentsList();
            }

            System.out.println("Would you like to Check Person List (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                HumanResorces.getPeople();
            }

            System.out.println("Would you like to Check Person Details (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                System.out.println("Enter Person Name:");
                String personName = scanner.nextLine();
                Person person = company.humanResources.getPersonByName(personName);
                if (person != null) {
                    System.out.println("Name: " + person.getName());
                    System.out.println("Birthdate: " + person.getBirthdate());
                    System.out.println("Registry Number: " + person.getRegistryNumber());
                    System.out.println("Projects: " + person.getProjects());
                    System.out.println("Is Manager: " + person.isManager());
                } else {
                    System.out.println("Person not found.");
                }
            }

            System.out.println("Would you like to create SubDepartment (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                System.out.println("Enter Department Name:");
                Departament departament = Departament.getDepartmentByName(company, scanner.nextLine());
                System.out.println("Enter Sub Department Name");
                departament.setSubDepartment(scanner.nextLine());
                departament.getSubDepartments();
            }

            System.out.println("Would you like to check if ProjectIsFinished (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                System.out.println("Enter Department Name:");
                Departament departament = Departament.getDepartmentByName(company, scanner.nextLine());
                System.out.println("Enter ProjectName");
                Project project = Departament.getProjectByName(departament.getProjects(), scanner.nextLine());
                project.checkIfIsFinished();
            }

            System.out.println("Would you like to see Salary (answer YES or pressKey):");
            task = scanner.nextLine();
            if ("END TASK".equals(task))break;
            else
            if ("YES".equals(task)) {
                company.sortJobsBySalaryDescending();
            }
        }
    }

    // Method to read initial employees data from a file
    private static void readEmployeesFromFile(Company company) throws IOException, ParseException {
        file = true;
        String filePath = "src/BusinessSimulation/employees.txt";

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        int numberOfEmployees = Integer.parseInt(lines.get(0));
        System.out.println("In the file are:" + numberOfEmployees + "employees");

        for (int i = 1; i <= numberOfEmployees; i++) {
            String[] employeeData = lines.get(i).split(", ");
            String name = employeeData[0];
            Date birthDate = new Date(Integer.parseInt(employeeData[1]), Integer.parseInt(employeeData[2]), Integer.parseInt(employeeData[3]));
            int registryNumber = Integer.parseInt(employeeData[4]);
            boolean isManager = Boolean.parseBoolean(employeeData[5]);
            int salary = Integer.parseInt(employeeData[6]);
            Date startDate = new Date(Integer.parseInt(employeeData[7]), Integer.parseInt(employeeData[8]), Integer.parseInt(employeeData[9]));
            String departmentName = employeeData[10];
            String projectName = employeeData[11];
            Date deadLine = new Date(Integer.parseInt(employeeData[12]), Integer.parseInt(employeeData[13]), Integer.parseInt(employeeData[14]));
            System.out.print(
                    name + " " +
                            birthDate + " " +
                            registryNumber + " " +
                            isManager + " " +
                            departmentName + " " +
                            projectName);

            Person employee = new Person(name, birthDate, registryNumber);
            Job job = new Job(salary, startDate);
            Project project = new Project(projectName, deadLine);
            if (company.doesDepartmentExist(employeeData[10])) {
                Departament existing = Departament.getDepartmentByName(company, employeeData[10]);
                company.startProject(project, existing);
                if (isManager) {
                    existing.addManager(employee);
                } else {
                    existing.addEmployee(company, employee, job);
                }
            } else {
                company.createDepartmentFromFile(employeeData[10]);
                Departament existing = Departament.getDepartmentByName(company, employeeData[10]);
                company.startProject(project, existing);
                if (isManager) {
                    existing.addManager(employee);
                } else
                    existing.addEmployee(company, employee, job);
            }
            company.hireEmployee(file, employee);


        }
    }
}