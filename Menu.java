/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 1
 * CSE214-01
 * Charles Chen
 */
public class Menu implements Cloneable{
    private final int max_Items = 50;
    private MenuItem [] menuArray;
    private int currentArraySize=0;
    /**
     * Create a MeniItem object with a 50 size its array
     */
    public Menu(){
        menuArray = new MenuItem[max_Items];
    }
    /**
     * Copes all data from a particular Menu into a new Menu 
     * reference.Changing the original will not change the copy.
     * @return 
     *      a copy of a Menu Object
     */
    public Object clone(){
        Menu copyMenu = new Menu();
        for(int i=1; i<=size();i++){
            try {
                copyMenu.addItem(this.getItem(i).clone(), i);
            } catch (IllegalArgumentException ex) {
            } catch (FullListException ex) {
            }
        }
        return copyMenu;
    }
    /**
     * Compares a particular object with a Menu object
     * @param obj 
     *      the Menu object to be compared with the current Menu object
     * @return 
     *      true if two objects are equal, false otherwise
     */
    public boolean equals(Object obj){
        if(obj instanceof Menu){
            Menu menu = (Menu)obj;
            if(menu.size()==size()){
                for(int i=0;i<size();i++){
                    try {
                        if(!getItem(i).equals(menu.getItem(i))){
                            return false;
                        }
                    } catch (IllegalArgumentException ex) {
                    }
                }
            }
            else
                return false;     
        }
        return true;
    }
    /**
     * Return current array size
     * @return
     *      number of Item in the array
     */
    public int size(){   
        return currentArraySize;
    }
    /**
     * Add Item to Menu
     * @param item 
     *      MenuItem object to be add
     * @param position 
     *      the position to be added
     * @throws IllegalArgumentException
     *      if the position out of the range
     * @throws FullListException 
     *      if the array is full
     */
    public void addItem(MenuItem item,int position) throws IllegalArgumentException,FullListException{
        if(position>size()+1||position<1)
            throw new IllegalArgumentException("");
        else if(size()==max_Items)
            throw new FullListException("");
        else{
            MenuItem temp1=menuArray[position-1];
            menuArray[position-1]=item;
            currentArraySize++;
            for(int i=position; i<=size()+1;i++){
                MenuItem temp2=menuArray[i];
                menuArray[i]=temp1;
                temp1=temp2;
            }    
        }
    }
    /**
     * Remove the item from Menu
     * @param position 
     *      the position to be removed
     * @throws IllegalArgumentException
     *      if the position out of the range
     */
    public void removeItem(int position) throws IllegalArgumentException{
        if(position>size()||position<1)
            throw new IllegalArgumentException("");
        else{
            for(int i=position; i<=size();i++){
                menuArray[i-1]=menuArray[i];
            }
            currentArraySize--;
        }
    }
    /**
     * Get item form Menu
     * @param position 
     *      position to be got the item
     * @return 
     *      the particular item
     * @throws IllegalArgumentException
     *      if the position out of the range
     */
    public MenuItem getItem(int position) throws IllegalArgumentException{
        if(position>size()||position<1)
            throw new IllegalArgumentException("");
        else
            return menuArray[position-1];
    }
    /**
     * Get item by name
     * @param name 
     *      the name to be found in Menu
     * @return
     *      the particular item
     * @throws IllegalArgumentException
     *      if the position out of the range
     */
    public MenuItem getItemByName(String name) throws IllegalArgumentException{
        for(int i=0;i<size();i++){
            if(name.equalsIgnoreCase(menuArray[i].getName())){
                return menuArray[i];
            }
        }
        throw new IllegalArgumentException("");
        
    }
    /*
    *print all the items' information
    */
    public void printAllItem(){
        for(int i=0; i<size();i++){
            System.out.println(i+1 + ".  " + menuArray[i].toString());
        }
    }      
}
