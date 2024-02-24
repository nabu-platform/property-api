package be.nabu.libs.property;

import be.nabu.libs.property.api.Property;
import be.nabu.libs.property.api.PropertyWithDefault;
import be.nabu.libs.property.api.Value;

public class ValueUtils {
	
	@SuppressWarnings("unchecked")
	public static <T> T getValue(Property<T> property, Iterable<Value<?>> values) {
		T result = null;
		for (Value<?> value : values) {
			if (value != null && value.getProperty() != null && value.getProperty().equals(property)) {
				result = (T) value.getValue();
				break;
			}
		}
		return result == null && property instanceof PropertyWithDefault ? ((PropertyWithDefault<T>) property).getDefault() : result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getValue(Property<T> property, Value<?>...values) {
		T result = null;
		for (Value<?> value : values) {
			if (value != null && value.getProperty() != null && value.getProperty().equals(property)) {
				result = (T) value.getValue();
				break;
			}
		}
		return result == null && property instanceof PropertyWithDefault ? ((PropertyWithDefault<T>) property).getDefault() : result;
	}
	
	public static boolean contains(Property<?> property, Value<?>...values) {
		for (Value<?> value : values) {
			if (value.getProperty().equals(property))
				return true;
		}
		return false;
	}
}
