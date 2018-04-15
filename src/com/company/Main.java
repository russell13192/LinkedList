package com.company;

public class Main {

    public static void main(String[] args) {
	    List<Person> list = new LinkedList<Person>();

	    Person person = new Person(10, "Adam");
        list.insert(person);
        list.insert(new Person(22, "Joe"));
        list.insert(new Person(1, "Kevin"));
        list.insert(new Person(45, "Michael"));

        System.out.println(list.size());

        list.remove(person);
        list.traverseList();
    }
}
