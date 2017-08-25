package com.cooksys.ftd.assignments.collections;

import com.cooksys.ftd.assignments.collections.hierarchy.Hierarchy;
import com.cooksys.ftd.assignments.collections.model.Capitalist;
import com.cooksys.ftd.assignments.collections.model.FatCat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.Map.Entry;

public class MegaCorp implements Hierarchy<Capitalist, FatCat> {
	
	private Set<Capitalist> hSet = new HashSet<Capitalist>();
	
	private Map<FatCat, Set<Capitalist>> hierarchy = new HashMap<FatCat, Set<Capitalist>>();

    /**
     * Adds a given element to the hierarchy.
     * <p>
     * If the given element is already present in the hierarchy,
     * do not add it and return false
     * <p>
     * If the given element has a parent and the parent is not part of the hierarchy,
     * add the parent and then add the given element
     * <p>
     * If the given element has no parent but is a Parent itself,
     * add it to the hierarchy
     * <p>
     * If the given element has no parent and is not a Parent itself,
     * do not add it and return false
     *
     * @param capitalist the element to add to the hierarchy
     * @return true if the element was added successfully, false otherwise
     */
    @Override
    public boolean add(Capitalist capitalist) {

		Set<Capitalist> catelistSet = new HashSet<Capitalist>();
		catelistSet.add(capitalist);

    	hierarchy.put(capitalist.getParent(),catelistSet);

    	boolean status = false;
    	
    	/*if(hierarchy.containsKey(capitalist.getParent())){
			catelistSet = hierarchy.get(capitalist.getParent());
			if (catelistSet.contains(capitalist)) {
				status = false;
				return status;
			}
    	}
    	/*
    	if(capitalist.hasParent()){
    		FatCat cat = capitalist.getParent();
    		if(hSet.contains(cat)){
    			hSet.add(cat);
    			hSet.add(capitalist);
    			status = true;
    		}
    	}else {
			hSet.add(capitalist);
			status = true;
    	}
    	*/
    	
    	return status;
    	
    }

    /**
     * @param capitalist the element to search for
     * @return true if the element has been added to the hierarchy, false otherwise
     */
    @Override
    public boolean has(Capitalist capitalist) {
    	
    	return hierarchy.containsKey(capitalist);
    }

    /**
     * @return all elements in the hierarchy,
     * or an empty set if no elements have been added to the hierarchy
     */
    @Override
    public Set<Capitalist> getElements() {
    	
    	Set<Capitalist> elements = new HashSet<Capitalist>();
    	for (Entry<FatCat, Set<Capitalist>> entry : hierarchy.entrySet()) {
    		elements.addAll(entry.getValue());
    	}
    	return elements;
        
    }

    /**
     * @return all parent elements in the hierarchy,
     * or an empty set if no parents have been added to the hierarchy
     */
    @Override
    public Set<FatCat> getParents() {
    	
    	Set<FatCat> parents = new HashSet<FatCat>();
    	for (Entry<FatCat, Set<Capitalist>> entry : hierarchy.entrySet()) {
    		parents.add(entry.getKey());
    	}
    	return parents;
    }

    /**
     * @param fatCat the parent whose children need to be returned
     * @return all elements in the hierarchy that have the given parent as a direct parent,
     * or an empty set if the parent is not present in the hierarchy or if there are no children
     * for the given parent
     */
    @Override
    public Set<Capitalist> getChildren(FatCat fatCat) {
        
    	return hierarchy.get(fatCat);
    	
    }

    /**
     * @return a map in which the keys represent the parent elements in the hierarchy,
     * and the each value is a set of the direct children of the associate parent, or an
     * empty map if the hierarchy is empty.
     */
    @Override
    public Map<FatCat, Set<Capitalist>> getHierarchy() {
    	
    	return hierarchy;
    }

    /**
     * @param capitalist
     * @return the parent chain of the given element, starting with its direct parent,
     * then its parent's parent, etc, or an empty list if the given element has no parent
     * or if its parent is not in the hierarchy
     */
    @Override
    public List<FatCat> getParentChain(Capitalist capitalist) {
    	
    	List<FatCat> fatCatList = new ArrayList<FatCat>();
    	if(capitalist.hasParent()){
    		fatCatList.add(capitalist.getParent());
        	FatCat catTemp = capitalist.getParent();
    		while(catTemp.hasParent()){
    			fatCatList.add(catTemp.getParent());
    			catTemp = catTemp.getParent();
    		}
    	}
    	return fatCatList;
    }
}
