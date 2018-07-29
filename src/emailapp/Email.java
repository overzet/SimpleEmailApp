package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 10_000;
    private String email;
    private String alternateEmail;
    private String companySuffix = "intecbrussel.be";
    private int lengthPassword = 8;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
        //System.out.println("Email Created: " + this.email);

        this.password = setPassword(lengthPassword);
        //System.out.println("Your password is: " + this.password);
    }

    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n\t1 for Sales \n\t2 for Development \n\t3 for Accounting \n\t0 for none\nEnter a department: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sal";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acc";
        } else {
            return "";
        }
    }

    private String setPassword(int lengthPassword) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwXYZ1234567890?!#$%&";//een char set to choose from
        char[] password = new char[lengthPassword];                                                 //char array to fill
        for (int i = 0; i < lengthPassword; i++) {
            int randomNmber = (int) (Math.random() * passwordSet.length());                         //random number between 0 and 1 times set length
            password[i] = passwordSet.charAt(randomNmber);                                          //match random number with index from set and add it
        }                                                                                           //to password
        return new String(password);                                                                //return password
    }

    public void setmailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    @Override
    public String toString() {
        return "firstName= " + firstName + "\n" +
                "lastName= " + lastName + "\n" +
                "password= " + password + "\n" +
                "department= " + department + "\n" +
                "mailboxCapacity= " + mailboxCapacity + " mbyte\n" +
                "email= " + email + "\n";

    }
}
