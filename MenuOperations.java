/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 1
 * CSE214-01
 * Charles Chen
 */

import java.util.Scanner;

public class MenuOperations {

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Menu order = new Menu();
        String sInput = "";
        String newLineChar;
        int totalOrder = 1;
        double price = 0;
        int position;
        boolean exceptionPass, exceptionPass1;
        System.out.println("Main menu:\n");
        System.out.println("A) Add Item");
        System.out.println("G) Get Item");
        System.out.println("R) Remove Item");
        System.out.println("P) Print All Items");
        System.out.println("S) Size");
        System.out.println("D) Update description");
        System.out.println("C) Update price");
        System.out.println("O) Add to order");
        System.out.println("I) Remove from order");
        System.out.println("V) View order");
        System.out.println("Q) Quit");
        System.out.println("");

        while (!sInput.equalsIgnoreCase("Q")) {
            exceptionPass = false;
            exceptionPass1 = false;
            System.out.print("Select an operation: ");
            sInput = input.next();
            newLineChar = input.nextLine();
            System.out.println("");

            if (sInput.equalsIgnoreCase("A")) {
                System.out.print("Enter the name: ");
                String name = input.nextLine();
                System.out.println("");
                System.out.print("Enter the describtion: ");
                String description = input.nextLine();
                System.out.println("");
                MenuItem addItem = new MenuItem(name, description);
                while (!exceptionPass1) {
                    try {
                        System.out.print("Enter the price: ");
                        price = input.nextDouble();
                        System.out.println("");
                        addItem.setPrice(price);
                        exceptionPass1 = true;
                    } catch (Exception ex) {
                        System.out.println("Price can not be nagetive!");
                        System.out.println("");
                    }
                }
                while (!exceptionPass) {
                    try {
                        System.out.print("Enter the position: ");
                        position = input.nextInt();
                        System.out.println("");
                        menu.addItem(addItem, position);
                        System.out.println("Added " + "\"" + name + ": " + description + "\" for $" + price + " at position " + position + "\n");
                        exceptionPass = true;
                    } catch (IllegalArgumentException ie) {
                        System.out.println("Position out of range!");
                        System.out.println("");
                    } catch (FullListException fe) {
                        System.out.println("This menu is full!");
                    }
                }
            } else if (sInput.equalsIgnoreCase("G")) {
                while (!exceptionPass) {
                    try {
                        System.out.print("Enter the position: ");
                        position = input.nextInt();
                        System.out.println("");
                        menu.getItem(position);
                        System.out.println("#   " + String.format("%-30s%-50s%-10s", "name", "description", "price"));
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(position + ".  " + menu.getItem(position).toString());
                        System.out.println("");
                        exceptionPass = true;
                    } catch (IllegalArgumentException ie) {
                        System.out.println("Position out of range!");
                        System.out.println("");
                    }
                }
            } else if (sInput.equalsIgnoreCase("R")) {
                while (!exceptionPass) {
                    try {
                        System.out.print("Enter the position: ");
                        position = input.nextInt();
                        System.out.println("");
                        String name = menu.getItem(position).getName();
                        menu.removeItem(position);
                        System.out.println("Removed \"" + name + "\"");
                        System.out.println("");
                        exceptionPass = true;
                    } catch (IllegalArgumentException ie) {
                        System.out.println("Position out of range!");
                        System.out.println("");
                    }
                }
            } else if (sInput.equalsIgnoreCase("P")) {
                System.out.println("#   " + String.format("%-30s%-50s%-10s", "name", "description", "price"));
                System.out.println("----------------------------------------------------------------------------------------------");
                menu.printAllItem();
                System.out.println("");
            } else if (sInput.equalsIgnoreCase("S")) {
                System.out.println(menu.size());
                System.out.println("");
            } else if (sInput.equalsIgnoreCase("D")) {
                while (!exceptionPass) {
                    try {
                        System.out.print("Enter the position: ");
                        position = input.nextInt();
                        System.out.println("");
                        menu.getItem(position);
                        newLineChar = input.nextLine();
                        System.out.print("Enter the new description: ");
                        String newDescription = input.nextLine();
                        System.out.println("");
                        menu.getItem(position).setDescription(newDescription);
                        System.out.println("New description set.");
                        System.out.println("");
                        exceptionPass = true;
                    } catch (IllegalArgumentException ie) {
                        System.out.println("Position out of range!");
                        System.out.println("");
                    }
                }
            } else if (sInput.equalsIgnoreCase("C")) {
                System.out.print("Enter the name of item: ");
                String nameOfItem = input.nextLine();
                System.out.println("");
                System.out.print("Enter the new price: ");
                double newPrice = input.nextDouble();
                System.out.println("");
                newLineChar = input.nextLine();
                while (!exceptionPass) {
                    try {
                        menu.getItemByName(nameOfItem).setPrice(newPrice);
                        exceptionPass = true;
                    } catch (IllegalArgumentException ie) {
                        System.out.println("This item is not in the menu!");
                        System.out.println("");
                        System.out.print("Enter the name of item: ");
                        nameOfItem = input.nextLine();
                        System.out.println("");
                    } catch (Exception e) {
                        System.out.println("Price can not be nagetive!");
                        System.out.println("");
                        System.out.print("Enter the new price: ");
                        newPrice = input.nextDouble();
                        System.out.println("");
                    }
                }
            } else if (sInput.equalsIgnoreCase("O")) {
                while (!exceptionPass) {
                    try {
                        System.out.print("Enter the position: ");
                        position = input.nextInt();
                        System.out.println("");
                        order.addItem(menu.getItem(position), totalOrder++);
                        exceptionPass = true;
                    } catch (IllegalArgumentException ie) {
                        System.out.println("Position out of range!");
                        System.out.println("");
                    } catch (FullListException fe) {
                    }
                }
            } else if (sInput.equalsIgnoreCase("I")) {
                while (!exceptionPass) {
                    try {
                        System.out.print("Enter the position: ");
                        position = input.nextInt();
                        System.out.println("");
                        String name = order.getItem(position).getName();
                        order.removeItem(position);
                        System.out.println("Removed \"" + name + "\" from order");
                        System.out.println("");
                        exceptionPass = true;
                    } catch (IllegalArgumentException ie) {
                        System.out.println("Position out of range!");
                        System.out.println("");
                    }
                }
                totalOrder--;
            } else if (sInput.equalsIgnoreCase("V")) {
                System.out.println("#   " + String.format("%-30s%-50s%-10s", "name", "description", "price"));
                System.out.println("----------------------------------------------------------------------------------------------");
                order.printAllItem();
                System.out.println("");
            }
        }
    }

}
