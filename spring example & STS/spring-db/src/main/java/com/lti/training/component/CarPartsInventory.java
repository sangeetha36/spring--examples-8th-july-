package com.lti.training.component;

import java.util.List;

public interface CarPartsInventory {

	public void addNewPart(CarPart carpart);
	
	public List<CarPart> getAvailableParts();
}
