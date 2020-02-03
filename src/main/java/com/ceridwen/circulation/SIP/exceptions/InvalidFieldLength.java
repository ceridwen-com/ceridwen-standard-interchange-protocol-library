/* 
 * Copyright (C) 2020 Ceridwen Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ceridwen.circulation.SIP.exceptions;

public class InvalidFieldLength extends Exception {

    /**
	 * 
	 */
    private static final long serialVersionUID = 5690108640895112742L;
    private String field;
    private int maxLength;

    public InvalidFieldLength(String field, int maxLength) {
        this.field = field;
        this.maxLength = maxLength;
    }

    @Override
    public String getMessage() {
        return this.field + " - Field Length: " + this.maxLength + " characters";
    }
}
