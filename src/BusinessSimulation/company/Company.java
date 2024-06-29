package BusinessSimulation.company;

import BusinessSimulation.Job;
import BusinessSimulation.Project;
import BusinessSimulation.person.Person;

import java.io.IOException;
import java.util.*;

public class Company implements Comparator<Job> {
    public List<Departament> departmentsList;
    public HumanResorces humanResources;
    private Scanner scanner = new Scanner(System.in);

    public Company() {
        this.departmentsList = new ArrayList<>();
        this.humanResources = new HumanResorces();
    }

    public void createDepartment(){
        System.out.println("Add Departments:");
        String deptName = scanner.nextLine();
        Departament newDept = new Departament(deptName);
        departmentsList.add(newDept);
    }

    public void createDepartmentFromFile(String name) {
        Departament newDept = new Departament(name);
        departmentsList.add(newDept);
    }

    public List<Departament> getDepartmentsList() {
        System.out.println(departmentsList);
        return departmentsList;
    }

    public boolean doesDepartmentExist(String departmentName) {
        for (Departament department : departmentsList) {
            if (department.getName().equals(departmentName)) {
                return true;
            }
        }
        return false;
    }

    public void hireEmployee(boolean file, Person newPerson) throws IOException {
        humanResources.hire(file,this, newPerson);
    }

    public void dismissEmployee(Person person) {
        humanResources.dismiss(person);
    }

    public void startProject(Project newProject, Departament department) {
        department.start(newProject);
    }

    public void sellProject(Project theProject, Departament department) {
        department.sell(theProject);
    }

    public void finishProject(Project theProject, Departament department) {
        department.finish(theProject);
    }


    public List<Job> getAllJobs() {
        List<Job> allJobs = new ArrayList<>();

        for (Person person : HumanResorces.getPeople()) {
            if (person.getJobSalary() != null) {
                allJobs.add(person.getJobSalary());
            }
        }
        return allJobs;
    }

    @Override
    public int compare(Job job1, Job job2) {
        return Integer.compare(job2.getSalary(), job1.getSalary());
    }

    public void sortJobsBySalaryDescending() {
        List<Job> allJobs = getAllJobs();
        Collections.sort(allJobs, this);

        System.out.println("Sorted Jobs (descending order by salary): " + allJobs);
    }

}
