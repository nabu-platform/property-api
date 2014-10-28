package be.nabu.libs.property;

import be.nabu.libs.property.api.Property;
import be.nabu.libs.property.api.PropertyWithDefault;
import be.nabu.libs.property.api.Value;

public class ValueUtils {
	
	@SuppressWarnings("unchecked")
	public static <T> T getValue(Property<T> property, Value<?>...values) {
		for (Value<?> value : values) {
			if (value.getProperty().equals(property))
				return (T) value.getValue();
		}
		return property instanceof PropertyWithDefault ? ((PropertyWithDefault<T>) property).getDefault() : null;
	}
	
	public static boolean contains(Property<?> property, Value<?>...values) {
		for (Value<?> value : values) {
			if (value.getProperty().equals(property))
				return true;
		}
		return false;
	}
	
}
