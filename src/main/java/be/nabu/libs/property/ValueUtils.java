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
