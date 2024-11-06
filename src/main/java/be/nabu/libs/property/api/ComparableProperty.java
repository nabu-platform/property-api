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

package be.nabu.libs.property.api;

public interface ComparableProperty<T> extends Property<T> {
	/**
	 * Checks whether the subsetvalue is in fact a subset of the broader value
	 * For example if you have a "minlength" property and the subsetvalue is 5 whilst the broadervalue is 2, then it should return "true"
	 * This is because anything with the property value 5 for minlength is also valid for anything with the propery value 2
	 * In other words, the broader value is less specific than the subset value.
	 * 
	 * Conversely if you have a "maxlength" property which has a subsetvalue of 2 and a broadervalue of 5, this should also return true
	 * Anything that conforms to maxlength 2 is also valid for maxlength 5
	 * 
	 * @param subsetValue
	 * @param broaderValue
	 * @return
	 */
	public boolean isSubset(T subsetValue, T broaderValue);
}
