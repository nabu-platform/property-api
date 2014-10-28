package be.nabu.libs.property.api;

import be.nabu.libs.validator.api.Validator;

public interface Property<T> {
	public String getName();
	public Validator<T> getValidator();
	public Class<T> getValueClass();
}
