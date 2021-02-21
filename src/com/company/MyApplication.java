package com.company;
//import a paths to the classes
import com.company.controllers.TopController;
import com.company.controllers.MiddleController;
import com.company.controllers.LowController;
import com.company.controllers.CostController;

//import a paths to the classes
import com.company.entities.Cost;
import com.company.repositories.interfaces.ILowRepository;
import com.company.repositories.interfaces.IMiddleRepository;
import com.company.repositories.interfaces.ITopRepository;
import com.company.repositories.interfaces.ICostRepository;


import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final TopController controller;
    private final MiddleController controller1;
    private final LowController controller2;
    private final Scanner scanner;
    private final CostController costRepo;

    /**
     * Overloaded constructor with default parameter values
     */
    public MyApplication(ITopRepository repo, IMiddleRepository repo1, ILowRepository repo2, ICostRepository repo3) {
        controller = new TopController(repo);
        controller1 = new MiddleController(repo1);
        controller2 = new LowController(repo2);
        costRepo = new CostController(repo3);
        scanner = new Scanner(System.in);
    }

    /**
     * Method start is used to start program execution
     */
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to IT Company");
            System.out.println("Total cost of the company: ");
            System.out.println(getTotalCost());
            System.out.println("Select a level of employees:");
            System.out.println("1. Top level executives");
            System.out.println("2. Middle level executives");
            System.out.println("3. Low level executives");
            System.out.println("0. Exit");
            System.out.println();

            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    toplevelmenu();
                } else if (option == 2) {
                    middlelevelmenu();
                } else if (option == 3) {
                    lowlevelmenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
        }
    }

    /**
     * Method getTotalCost that returns total cost of the company
     */
    private List<Cost> getTotalCost() {
        List<Cost> costs = costRepo.getAllCosts();
        return costs;
    }
    /**
     * Method toplevelmenu, which returns the top level menu
     */
    private void toplevelmenu() {
        while (true) {
            System.out.println("Welcome to Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Create employee");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTopsMenu();
                } else if (option == 2) {
                    getTopByIdMenu();
                } else if (option == 3) {
                    createTopMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    /**
     * Method middlelevelmenu, which returns the middle level menu
     */
    private void middlelevelmenu() {
        while (true) {
            System.out.println("Welcome to Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Create employee");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllMiddlesMenu();
                } else if (option == 2) {
                    getMiddlesByIdMenu();
                } else if (option == 3) {
                    createMiddleMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    /**
     * Method lowlevelmenu, which returns the low level menu
     */
    private void lowlevelmenu() {
        while (true) {
            System.out.println("Welcome to Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Create employee");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllLowsMenu();
                } else if (option == 2) {
                    getLowByIdMenu();
                } else if (option == 3) {
                    createLowMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    /**
     * Method, which returns all top level employees
     */
    public void getAllTopsMenu() {
        String response = controller.getAllTops();
        System.out.println(response);
    }

    /**
     * Method, which returns top level employee by id
     */
    public void getTopByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getTop(id);
        System.out.println(response);
    }
    /**
     * Method, which  create top level employee
     */
    public void createTopMenu() {
        System.out.println("Please enter employee's name");
        String name = scanner.next();
        System.out.println("Please enter employee's surname");
        String surname = scanner.next();
        System.out.println("Please enter employee's gender (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter employee's position");
        String position = scanner.next();


        String response = controller.createTop(name, surname, gender, position);
        System.out.println(response);
    }

    /**
     * Method, which returns all middle level employees
     */
    public void getAllMiddlesMenu() {
        String response = controller1.getAllMiddles();
        System.out.println(response);
    }
    /**
     * Method, which returns middle level employee by id
     */
    public void getMiddlesByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller1.getMiddle(id);
        System.out.println(response);
    }
    /**
     * Method, which  create middle level employee
     */
    public void createMiddleMenu() {
        System.out.println("Please enter employee's name");
        String name = scanner.next();
        System.out.println("Please enter employee's surname");
        String surname = scanner.next();
        System.out.println("Please enter employee's gender (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter employee's position");
        String position = scanner.next();


        String response = controller1.createMiddle(name, surname, gender, position);
        System.out.println(response);
    }
    /**
     * Method, which returns all low level employees
     */
    public void getAllLowsMenu() {
        String response = controller2.getAllLows();
        System.out.println(response);
    }
    /**
     * Method, which  low level employee by id
     */
    public void getLowByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller2.getLow(id);
        System.out.println(response);
    }
    /**
     * Method, which  create low level employee
     */
    public void createLowMenu() {
        System.out.println("Please enter employee's name");
        String name = scanner.next();
        System.out.println("Please enter employee's surname");
        String surname = scanner.next();
        System.out.println("Please enter employee's gender (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter employee's position");
        String position = scanner.next();

        String response = controller2.createLow(name, surname, gender, position);
        System.out.println(response);
    }
}