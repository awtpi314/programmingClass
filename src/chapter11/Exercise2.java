package chapter11;

import java.util.Date;

public class Exercise2 {
    public static void main(String[] args) {
        Person jamesSmith = new Person("James Smith", "123 Main St., Norwalk, VA",
                "800-234-5551", "jamsmith@google.com");
        Student sallyWallace = new Student("Sally Wallace", "456 William Rd., Roanoke, VA",
                "800-456-4567", "saw@google.com", Student.CLASSES.sophomore);
        // -------NOTE: This Date constructor is deprecated, but I don't know how to construct one otherwise------------
        Employee williamHarlowe = new Employee("William Harlowe", "222 Minor Blvd., Discord, WA",
                "800-111-555", "billlow@google.com", "6A", 24000, new Date(2003, 1, 2));
        Faculty harryHenderson = new Faculty("Harry Henderson", "333 Major Blvd. Accord, PA", "800-432-5432",
                "hairyhender@google.com", "5B", 34000, new Date(2004, 2, 3), "8:00am-11:00am", "1A");
        Staff henryJohnson = new Staff("Henry Johnson", "123 Billikid St. Tombstone, AZ", "800-555-1212",
                "henjon@google.com", "4C", 55000, new Date(2010, 10, 10), "Senior Navigator");

        System.out.println(jamesSmith.toString());
        System.out.println(sallyWallace.toString());
        System.out.println(williamHarlowe.toString());
        System.out.println(harryHenderson.toString());
        System.out.println(henryJohnson.toString());
    }
}

class Person {
    private final String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String n, String a, String phN, String emA) {
        name = n;
        address = a;
        phoneNumber = phN;
        emailAddress = emA;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + name + "; " + address + "; " + phoneNumber + "; " + emailAddress;
    }
}

class Student extends Person {
    private CLASSES currentClass;

    public Student(String n, String a, String phN, String emA, CLASSES c) {
        super(n, a, phN, emA);

        currentClass = c;
    }

    public CLASSES getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(CLASSES currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + currentClass.toString();
    }

    public enum CLASSES {
        freshman(0), sophomore(1), junior(2), senior(3);
        private final String[] classes = {"freshman", "sophomore", "junior", "senior"};
        private final int classInt;

        CLASSES(int i) {
            classInt = i;
        }

        public String toString() {
            return classes[classInt];
        }
    }
}

class Employee extends Person {
    private final Date dateHired;
    private String office;
    private int salary;

    public Employee(String n, String a, String phN, String emA, String o, int s, Date dH) {
        super(n, a, phN, emA);
        office = o;
        salary = s;
        dateHired = dH;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateHired() {
        return dateHired;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + office + "; " + salary + "; " + dateHired.toString();
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String n, String a, String phN, String emA, String o, int s, Date dH, String oH, String r) {
        super(n, a, phN, emA, o, s, dH);
        officeHours = oH;
        rank = r;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + officeHours + "; " + rank;
    }
}

class Staff extends Employee {
    private String title;

    public Staff(String n, String a, String phN, String emA, String o, int s, Date dH, String t) {
        super(n, a, phN, emA, o, s, dH);
        title = t;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + title;
    }
}