package Abstracts.view;

import Abstracts.Family;
import Abstracts.Human;
import Abstracts.Humans.Man;
import Abstracts.Humans.Women;
import Dao.FamilyController;

import java.util.Scanner;

public class ConsoleView {
    FamilyController controller = new FamilyController();
    private String commandString = "Available Commands: \n" +
            "- 1. Fill with test data\n" +
            "- 2. Display the entire list of families\n" +
            "- 3. Display a list of families where the number of people is greater than the specified number\n" +
            "- 4. Display a list of families where the number of people is less than the specified number\n" +
            "- 5. Calculate the number of families where the number of members is equal to the specified number\n" +
            "- 6. Create a new family\n" +
            "- 7. Delete a family\n" +
            "- 8. Edit a family by its index in the general list\n" +
            "- 9. Remove all children over the specified age\n" +
            "- 10. Save file\n" +
            "- 11. Load file\n" +
            "[exit] for exit";

    private void commands() {
        System.out.println(commandString);

    }
    public boolean run(){
        commands();
        System.out.println("enter command");
        Scanner sc = new Scanner(System.in);
        String cm =sc.nextLine();
        if (cm.equalsIgnoreCase("exit"))
            return false;
        switch (cm){
            case "1": {
                fillTestData();
                break;
            }
            case "2":{
                controller.displayAllFamilies();
                break;
            }
            case "3":{
                System.out.print("Enter the number: ");
                int input = sc.nextInt();
                System.out.println(controller.getFamiliesBiggerThan(input));
                break;
            }
            case "4":{
                System.out.print("Enter the number: ");
                int input = sc.nextInt();
                System.out.println(controller.getFamiliesLessThan(input));
                break;
            }
            case "5":{
                System.out.print("Enter the number: ");
                int input = sc.nextInt();
                System.out.println(controller.countFamiliesWithMemberNumber(input).size());
                break;
            }
            case "6":{
                createFamilyFromInput();
                break;
            }
            case "7":{
                System.out.print("Enter index of family: ");
                int input = sc.nextInt();
                controller.deleteFamilyByIndex(input);
                break;
            }
            case "8":{
                updateFamily();
                break;
            }
            case "9":{
                System.out.print("Enter age of children: ");
                int input = sc.nextInt();
                controller.deleteAllChildrenOlderThen(input);
                break;
            }
            case "10":{
                controller.saveFile();
                break;
            }
            case "11":{
                controller.loadFile();
                break;
            }
            default:
                System.out.println("Wrong command");


        }
        return true;
    }

    private Family createFamilyFromInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter mother's name: ");
        String mName = sc.nextLine();
        System.out.print("Enter mother's surname: ");
        String mSurname = sc.nextLine();
        System.out.print("Enter mother's birth year : ");
        String mBirthYear = sc.nextLine();
        System.out.print("Enter mother's birth month : ");
        String mBirthMonth = sc.nextLine();
        System.out.print("Enter mother's birthday : ");
        String mBirthDay = sc.nextLine();
        String mBirthDate = mBirthDay + "/" + mBirthMonth + "/" + mBirthYear;
        System.out.print("Enter mother's iq : ");
        int mIq = sc.nextInt();
        Women mother = new Women(mName, mSurname, mBirthDate, mIq);

        sc = new Scanner(System.in);
        System.out.print("Enter father's name: ");
        String fName = sc.nextLine();
        System.out.print("Enter father's surname: ");
        String fSurname = sc.nextLine();
        System.out.print("Enter father's birth year : ");
        String fBirthYear = sc.nextLine();
        System.out.print("Enter father's birth month : ");
        String fBirthMonth = sc.nextLine();
        System.out.print("Enter father's birthday : ");
        String fBirthDay = sc.nextLine();
        String fBirthDate = fBirthDay + "/" + fBirthMonth + "/" + fBirthYear;
        System.out.print("Enter father's iq : ");
        int fIq = sc.nextInt();
        Man father = new Man(fName, fSurname, fBirthDate, fIq);

        Family f = controller.createNewFamily(mother, father);
        return f;
    }
    public void fillTestData(){
        Man father1= new Man("Alex", "Messi", 1998L);
        Women mother1 = new Women("Kate", "Messi", 1996L);

        Man father2 = new Man("Mark", "Ronaldo", 1999L);
        Women mother2 = new Women("Anya", "Ronaldo",  1998L);

        Family newFamily1 = controller.createNewFamily(mother1, father1);
        Family newFamily2 = controller.createNewFamily(mother2, father2);
    }

    private void updateFamily(){
        Scanner sc = new Scanner(System.in);
        String commandStr = "- 1. Give birth to a baby\n" +
                "- 2. Adopt a child\n" +
                "- 3. Back to main menu.\n";
        System.out.println(commandStr);
        String cmnd = sc.nextLine();
        int id = sc.nextInt();
        switch (cmnd){
            case "1":{
                giveBirth(id);
                break;
            }
            case "2":{
                adoptChild(id);
                break;
            }
            case "3":{
                run();
            }
            default:{
                break;
            }
        }
    }
    private void giveBirth(int id){
        controller.bornChild( controller.getFamilyByIndex(id),"Masculine");
    }
    private void adoptChild(int id){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter child's gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter child's name: ");
        String name = sc.nextLine();
        System.out.print("Enter child's surname: ");
        String surname = sc.nextLine();
        System.out.print("Enter child's birthdate (dd/mm/yyyy): ");
        String birthDate = sc.nextLine();
        System.out.print("Enter child's IQ: ");
        int iq = sc.nextInt();
        Human childAdopt = new Human(name, surname, birthDate, iq);
        controller.adoptChild(controller.getFamilyByIndex(id), childAdopt);

    }

}
