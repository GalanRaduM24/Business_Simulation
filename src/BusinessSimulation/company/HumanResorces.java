package BusinessSimulation.company;

import BusinessSimulation.person.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HumanResorces{
    static List<Person> people;

    public HumanResorces() {
        this.people = new ArrayList<>();
    }

    public void hire(boolean file, Company company, Person newPerson) throws IOException {
        if (file) {
            System.out.println("Person hired");
            people.add(newPerson);
            newPerson.assigneJobFromFile(company,newPerson.getName(),  null);
        }else {
            System.out.println("Person hired");
            people.add(newPerson);
            newPerson.assigneJob(company, null);
        }
    }

    public void dismiss(Person person) {
        if (people.contains(person)) {
            people.remove(person);
            System.out.println("Person dismissed");
        } else {
            System.out.println("Person not found in the list");
        }
    }

    public static List<Person> getPeople(){
        System.out.println("List of people: " + people);
        return people;
    }

    public static Person getPersonByName(String personName) {
        for (Person person : people) {
            if (person.getName().equals(personName)) {
                return person;
            }
        }
        return null;
    }
}
