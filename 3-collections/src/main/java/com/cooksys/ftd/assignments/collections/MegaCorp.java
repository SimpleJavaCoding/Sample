package com.cooksys.ftd.assignments.collections;

import com.cooksys.ftd.assignments.collections.hierarchy.Hierarchy;
import com.cooksys.ftd.assignments.collections.model.Capitalist;
import com.cooksys.ftd.assignments.collections.model.FatCat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.Map.Entry;

public class MegaCorp implements Hierarchy<Capitalist, FatCat> {
	
	private Set<Capitalist> hierarchySet = new HashSet<Capitalist>();
	
	private Map<FatCat, Set<Capitalist>> hierarchy = new HashMap<FatCat, Set<Capitalist>>();

	private Map<Hierarchy, Set<Capitalist>> hirachical = new HashMap<Hierarchy, Set<Capitalist>>();

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
    	boolean status = false;

		/*Set<Capitalist> catelistSet = new HashSet<Capitalist>();
		catelistSet.add(capitalist);

    	hierarchy.put(capitalist,catelistSet);

    	boolean status = false;

    	if(capitalist.hasParent()){

    		FatCat cat = capitalist.getParent();
    		if(hierarchy.containsKey(cat)){
    			hierarchy.put(cat,null);
			}
		}*/

		if(!hierarchySet.contains(capitalist)){

			hierarchySet.add(capitalist);
			status = true;
			return status;
		}else{
			status = false;
		}

		if(capitalist.hasParent()){
			FatCat cat = capitalist.getParent();
			if(hierarchySet.contains(cat)){
				hierarchySet.add(cat);
				hierarchySet.add(capitalist);
				status = true;
				return status;
			}
		}else {
			hierarchySet.add(capitalist);
			status = true;
			return status;

		}
		return status;

    	
    	/*if(hierarchy.containsKey(capitalist.getParent())){
			catelistSet = hierarchy.get(capitalist.getParent());
			if (catelistSet.contains(capitalist)) {
				status = false;
				return status;
			}
    	}

    	*/
    	

    }

    /**
     * @param capitalist the element to search for
     * @return true if the element has been added to the hierarchy, false otherwise
     */
    @Override
    public boolean has(Capitalist capitalist) {
    	
    	
    	return hierarchySet.contains(capitalist);
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
    	
    	/*Set<FatCat> parents = new HashSet<FatCat>();
    	for (Entry<FatCat, Set<Capitalist>> entry : hierarchy.entrySet()) {
    		parents.add(entry.getKey());
    	}*/
    	return hierarchy.keySet();
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
		Map<FatCat, Set<Capitalist>> hierarchyLocal = new HashMap<FatCat, Set<Capitalist>>();
		Set<Capitalist> elements = new HashSet<Capitalist>();

		for (Capitalist cap:hierarchySet) {
			if(!hierarchyLocal.containsKey(cap)){
				if(cap.hasParent()){
					hierarchyLocal.put(cap.getParent(),elements);
				}
			}else if(cap.hasParent()){
					elements.add(cap);
					hierarchyLocal.put(cap.getParent(),elements);
				}
			}


		return hierarchyLocal;
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
