package be.nabu.libs.property.api;

public interface PropertyWithDefault<T> extends Property<T> {
	public T getDefault();
}
