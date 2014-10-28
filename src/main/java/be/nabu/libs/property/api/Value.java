package be.nabu.libs.property.api;

public interface Value<T> {
	public Property<T> getProperty();
	public T getValue();
}
