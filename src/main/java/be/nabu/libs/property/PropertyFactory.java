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
