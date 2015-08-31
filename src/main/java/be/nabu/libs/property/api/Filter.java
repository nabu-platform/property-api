package be.nabu.libs.property.api;

import java.util.Collection;

public interface Filter<T> {
	public Collection<T> filter(Collection<T> elements);
}
