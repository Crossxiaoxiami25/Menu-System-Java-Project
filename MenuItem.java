/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 1
 * CSE214-01
 * Charles Chen
 */
public class MenuItem{
    private String name;
    private String description;
    private double price;
    /**
     * Create a new MenuItem object with blank parameters
     */
    public MenuItem(){
       
    }
    /**
     * Create a new MenuItem object with using given values
     * @param n 
     *      name of the order 
     * @param d
     *      order description
     */
    public MenuItem(String n, String d){
        name=n; description=d;
    }
    /**
     * Change the old order name to new order name
     * @param n
     *      new name
     */
    public void setName(String n){
        name=n;
    }
    /**
     * Change the old order description to new order description
     * @param d
     *      new description
     */
    public void setDescription(String d){
        description=d;
    }
    /**
     * Change the old order price to new order price
     * @param p
     *      new price
     * @throws Exception
     *      if the price is negative number
     */
    public void setPrice(double p)throws Exception{
        if(p<0)
            throw new Exception();
        else
            price=p;
    }
    /**
     * Receives the name of particular order
     * @return
     *      the name of a order as a String
     */
    public String getName(){
        return name;
    }
    /**
     * Receives the description of particular order
     * @return
     *      the description of a order as a String
     */
    public String getDescription(){
        return description;
    }
    /**
     * Receives the price of particular order
     * @return
     *      the price of a order as a double
     */
    public double getPrice(){
        return price;
    }
    /**
     * Copes all data from a particular MenuItem into a new MenuItem 
     * reference.Changing the original will not change the copy.
     * @return 
     *      a copy of a MenuItem Object
     */
    public MenuItem clone(){
        MenuItem copyMenuItem = new MenuItem();
        copyMenuItem.setName(name);
        copyMenuItem.setDescription(description);
        try {
            copyMenuItem.setPrice(price);
        } catch (Exception ex) {
        }
        return copyMenuItem;
    }
    /**
     * Compares a particular object with a MenuItem object
     * @param mi 
     *      the MenuItem object to be compared with the current MenuItem object
     * @return 
     *      true if two objects are equal, false otherwise
     */
    public boolean equals(MenuItem mi){
        if(mi.getName().equalsIgnoreCase(name)&&mi.getDescription().equalsIgnoreCase(description)&&mi.getPrice()==price)
            return true;
        else
            return false;
    }
    /**
     * Return a string of information about the MenuItem
     * @return 
     *      String of name,description,price
     */
    public String toString(){
        return String.format("%-30s%-50s%-10s", name,description,"$"+price);
    }
    
}
