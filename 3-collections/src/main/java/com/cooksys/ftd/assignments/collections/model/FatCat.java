package com.cooksys.ftd.assignments.collections.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FatCat implements Capitalist {

	private String name; 
	private int salary ;
	private FatCat owner; 
	
    public FatCat(String name, int salary) {
        super();
    	
    }	

    public FatCat(String name, int salary, FatCat owner) {
        
    }

    /**
     * @return the name of the capitalist
     */
    @Override
    public String getName() {
    	return name;
    }

    /**
     * @return the salary of the capitalist, in dollars
     */
    @Override
    public int getSalary() {
    	return salary;
    }

    /**
     * @return true if this element has a parent, or false otherwise
     */
    @Override
    public boolean hasParent() {
    	
    }

    /**
     * @return the parent of this element, or null if this represents the top of a hierarchy
     */
    @Override
    public FatCat getParent() {
    	
    }

    public FatCat getOwner() {
        return owner;
    }

    public void setOwner(FatCat owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
       
    }

    @Override
    public int hashCode() {
       
}
