package BusinessSimulation;

import BusinessSimulation.company.Departament;
import BusinessSimulation.person.Person;
import BusinessSimulation.util.Date;

public class Job{
    protected int salary;
    protected Date startDate;

    public Job(int salary, Date startDate) {

        this.salary = salary;
        this.startDate = startDate;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "salary=" + salary +
                ", startDate=" + startDate +
                '}';
    }
}
