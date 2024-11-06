/*
* Copyright (C) 2014 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package be.nabu.libs.property;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import be.nabu.libs.property.api.Property;

public class PropertyFactory {
	
	private Map<String, Property<?>> properties = new HashMap<String, Property<?>>();

	private static PropertyFactory instance;
	
	public static PropertyFactory getInstance() {
		if (instance == null) {
			instance = new PropertyFactory();
		}
		return instance;
	}
	
	@SuppressWarnings("rawtypes")
	public Property<?> getProperty(String name) {
		if (properties.isEmpty()) {
			ServiceLoader<Property> serviceLoader = ServiceLoader.load(Property.class);
			for (Property<?> property : serviceLoader)
				properties.put(property.getName(), property);
		}
		return properties.get(name);
	}
	
	public void addProperty(Property<?> property) {
		properties.put(property.getName(), property);
	}
	
	public void removeProperty(Property<?> property) {
		properties.remove(property.getName());
	}
	
	@SuppressWarnings("unused")
	private void activate() {
		instance = this;
	}
	@SuppressWarnings("unused")
	private void deactivate() {
		instance = null;
	}
}
