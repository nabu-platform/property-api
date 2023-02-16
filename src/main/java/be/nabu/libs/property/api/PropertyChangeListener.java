package be.nabu.libs.property.api;

public interface PropertyChangeListener<T> {
	public void changed(Property<T> property, Value<T> oldValue, Value<T> newValue);
}
