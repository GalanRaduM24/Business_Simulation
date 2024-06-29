package BusinessSimulation;


import BusinessSimulation.person.Person;
import BusinessSimulation.util.Date;


public class Project {
    private String name;
    private Date deadLine;
    private Boolean finished;

    public Person person;

    public Project(String name, Date deadLine) {
        this.name = name;
        this.deadLine = deadLine;
        this.finished = false;
        this.person = null;
    }

    public String getName() {
        return name;
    }

    public boolean checkIfIsFinished(){
        Date currentDate = Date.currentDate();
        finished = currentDate.compareTo(deadLine) > 0 || currentDate.equals(deadLine);
        System.out.println("Project finished status:" + finished);
        return finished;
    }

    public boolean isFinished(){
        this.finished = true;
        return finished;
    }

    public void addProjectToPerson(Person person){
        System.out.println("Person added");
        person.worksOn(this);
    }

}
