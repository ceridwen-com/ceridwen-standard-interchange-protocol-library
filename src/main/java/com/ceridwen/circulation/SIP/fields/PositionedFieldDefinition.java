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
package com.ceridwen.circulation.SIP.fields;

public class PositionedFieldDefinition extends FieldDefinition {
    public int start;
    public int end;
    @SuppressWarnings("unused")
    private final String tag = null;

    protected PositionedFieldDefinition(String name, int start, int end, FieldDefinition d, FieldPolicy policy) {
        super(name, d, policy);
        this.start = start;
        this.end = end;
    }

    public PositionedFieldDefinition(int start, int end) {
        this.start = start;
        this.end = end;
        this.policy = FieldPolicy.DEFAULT;
    }

    public PositionedFieldDefinition(int start, int end, FieldPolicy policy) {
        this.start = start;
        this.end = end;
        this.policy = policy;
    }
}
