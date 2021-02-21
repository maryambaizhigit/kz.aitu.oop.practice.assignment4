package com.company.entities;

public class Cost {
    private int total;

    /**
     * Default constructor
     */
    public Cost(){
    }

    /**
     * Parameterized constructor
     * @param total
     */
    public Cost(int total){
      setTotal(total);
    }

    /**
     * Method, which returns total cost of the company
     * @return integer value
     */
    public int getTotal() {
        return total;
    }

    /**
     * Parameterized constructor
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Overridden method toString from Top class
     * @return String value
     */
    @Override
    public String toString(){
        return String.valueOf(total);
    }
}
