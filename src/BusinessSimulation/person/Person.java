package BusinessSimulation.person;


import BusinessSimulation.Job;
import BusinessSimulation.Project;
import BusinessSimulation.company.Company;
import BusinessSimulation.company.Departament;
import BusinessSimulation.company.HumanResorces;
import BusinessSimulation.util.Date;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private String name;
    private Date birthdate;
    private int registryNumber;
    private List<Departament> departaments;
    private List<Project> projects;
    private boolean isManager;
    private List<Departament> managerDept;
    public Scanner scanner = new Scanner(System.in);
    public Job jobSalary;

    public Person(String name, Date birthdate, int registryNumber) {
        this.name = name;
        this.birthdate = birthdate;
        this.registryNumber = registryNumber;
        this.departaments = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.managerDept = new ArrayList<>();
        this.isManager = false;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public int getRegistryNumber() {
        return registryNumber;
    }

    public Job getJobSalary() {
        return jobSalary;
    }

    public void assigneJob(Company company, Job job){
        System.out.println("Is Person manager?");
        System.out.println("Respond with YES or NO");
        String task = scanner.nextLine();
        if ("NO".equals(task)) {
            System.out.println("Enter Salary");
            int salary = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Person StartDate (format YYYY MM DD):");
            Date startDate = new Date(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
            job = new Job(salary, startDate);
            this.jobSalary = job;
            System.out.println("Enter Department Name;");
            String departName = scanner.nextLine();
            Departament employeeDept = Departament.getDepartmentByName(company, departName);
            employeeDept.addEmployee(company, this, job);
            departaments.add(employeeDept);
        } else if ("YES".equals(task)) {
            System.out.println("Enter Salary");
            int salary = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Person StartDate (format YYYY MM DD):");
            Date startDate = new Date(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
            job = new Job(salary, startDate);
            this.jobSalary = job;
            System.out.println("Enter Department Name;");
            String departName = scanner.nextLine();
            Departament managerDept = Departament.getDepartmentByName(company, departName);
            managerDept.addManager(this);
            this.isManager = true;
        }
    }
    public void assigneJobFromFile(Company company,String targetName, Job job) throws IOException {
        String filePath = "F:\\project java\\facultate anul 2\\tema semestru 1\\ex 2\\src\\BusinessSimulation\\employees.txt";
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        int numberOfEmployees = Integer.parseInt(lines.get(0));

        for (int i = 1; i <= numberOfEmployees; i++) {
            String[] employeeData = lines.get(i).split(", ");
            String name = employeeData[0];

            if (name.equals(targetName)) {
                if("true".equals(employeeData[5])){
                    int salary = Integer.parseInt(employeeData[6]);
                    Date startDate = new Date(Integer.parseInt(employeeData[7]), Integer.parseInt(employeeData[8]), Integer.parseInt(employeeData[9]));
                    job = new Job(salary, startDate);
                    this.jobSalary = job;
                    String departName = employeeData[10];
                    Departament managerDept = Departament.getDepartmentByName(company, departName);
                    managerDept.addManager(this);
                    this.isManager = true;
        } else if ("false".equals(employeeData[5])) {
                    int salary = Integer.parseInt(employeeData[6]);
                    Date startDate = new Date(Integer.parseInt(employeeData[7]), Integer.parseInt(employeeData[8]), Integer.parseInt(employeeData[9]));
                    job = new Job(salary, startDate);
                    this.jobSalary = job;
                    String departName = employeeData[10];
                    Departament employeeDept = Departament.getDepartmentByName(company, departName);
                    employeeDept.addEmployee(company, this, job);
                    break;
                }
            }
        }
    }

    public boolean isManager() {
        return isManager;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void worksOn(Project project) {
        projects.add(project);
        System.out.println("Project '" + project.getName() + "' added to " + getName() + "'s profile.");
    }

}
