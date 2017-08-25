package com.cooksys.ftd.assignments.collections.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FatCat implements Capitalist {

	private String name = null;
	private int salary = 0;
	private FatCat owner = null;
	
    public FatCat(String name, int salary) {
        super();
    	this.name = name;
    	this.salary = salary;
    }	

    public FatCat(String name, int salary, FatCat owner) {
        this(name,salary);
        this.owner = owner;
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
    	if(owner != null){
    		return true;
    	} else{
    		return false;
    	}
    }

    /**
     * @return the parent of this element, or null if this represents the top of a hierarchy
     */
    @Override
    public FatCat getParent() {
    	return owner;
    }

    public FatCat getOwner() {
        return owner;
    }

    public void setOwner(FatCat owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FatCat fatCat = (FatCat) o;

        if (salary != fatCat.salary) return false;
        if (name != null ? !name.equals(fatCat.name) : fatCat.name != null) return false;
        return owner != null ? owner.equals(fatCat.owner) : fatCat.owner == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + salary;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
