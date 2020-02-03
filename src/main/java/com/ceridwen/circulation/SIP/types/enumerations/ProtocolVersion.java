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
package com.ceridwen.circulation.SIP.types.enumerations;

public enum ProtocolVersion implements AbstractEnumeration {
    VERSION_2_00("2.00"),
    VERSION_1_00("1.00");

    private final String code;

    private ProtocolVersion(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getCode();
    }

    @Override
    public final String getCode() {
        return this.code;
    }

    @Override
    public final AbstractEnumeration getKey(String code) {
        for (AbstractEnumeration i : ProtocolVersion.values()) {
            if (i.getCode().equals(code)) {
                return i;
            }
        }
        return null;
    }
}
