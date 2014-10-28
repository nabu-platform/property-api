package be.nabu.libs.property.api;

public interface ModifiableValue<T> extends Value<T> {
	public void setValue(T value);
}
