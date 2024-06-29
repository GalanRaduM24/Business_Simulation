package BusinessSimulation.company;

import BusinessSimulation.Job;
import BusinessSimulation.Project;
import BusinessSimulation.person.Person;
import BusinessSimulation.util.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Departament {
    private String name;
    private List<Departament> subDepartments;
    private List<Project> projects;
    private List<Person> employees;
    private Person manager;
    public Departament(String name) {
        this.name = name;
        this.subDepartments = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setSubDepartment(String subName) {
        Departament subDepartament = new Departament(subName);
        subDepartments.add(subDepartament);
    }

    public List<Departament> getSubDepartments() {
        System.out.println(subDepartments);
        return subDepartments;
    }

    public Departament addEmployee(Company company, Person person, Job job) {
        System.out.println("Employee '" + person.getName() + "' added to department '" + name + " with job" + job.toString());
        employees.add(person);
        return this;
    }
    public void addManager(Person manager) {
        this.manager = manager;
        System.out.println("Manager '" + manager.getName() + "' added to department '" + name + "'.");
    }
    public static Departament getDepartmentByName(Company company, String departmentName) {
        for (Departament department : company.departmentsList) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }

    public void start(Project newProject) {
        projects.add(newProject);
        System.out.println("Project '" + newProject.getName() + "' started in department '" + getName() + "'.");
    }

    public void sell(Project theProject) {
        projects.remove(theProject);
        System.out.println("Project '" + theProject.getName() + "' sold in department '" + getName() + "'.");
    }

    public void finish(Project theProject) {
        if (projects.contains(theProject)) {
            System.out.println("Project '" + theProject.getName() + "' finished in department '" + getName() + "'.");
            theProject.isFinished();
        } else {
            System.out.println("Project '" + theProject.getName() + "' not found in department '" + getName() + "'.");
        }
    }

    public static Project getProjectByName(List<Project> projects, String projectName) {
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                return project;
            }
        }
        return null;
    }
}

