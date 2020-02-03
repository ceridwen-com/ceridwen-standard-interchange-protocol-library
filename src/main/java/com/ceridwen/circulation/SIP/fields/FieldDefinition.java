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

import java.util.Date;

import com.ceridwen.circulation.SIP.annotations.Field;

public class FieldDefinition {
    public String tag;
    public Class<?> type;
    public int length;
    public FieldPolicy policy = FieldPolicy.DEFAULT;

    protected FieldDefinition() {
    }

    protected FieldDefinition(String name, FieldDefinition d, FieldPolicy policy) {
        this.tag = d.tag;
        this.length = d.length;
        if ((d.policy == FieldPolicy.DEFAULT) && (policy != FieldPolicy.DEFAULT)) {
            this.policy = policy;
        } else if ((d.policy == FieldPolicy.DEFAULT) && (policy == FieldPolicy.DEFAULT)) {
            throw new java.lang.AssertionError(name + " mutable required state needs explicit value");
        } else if ((d.policy != FieldPolicy.DEFAULT) && (policy == FieldPolicy.DEFAULT)) {
            this.policy = d.policy;
        } else {
            throw new java.lang.AssertionError(name + " immutable required state cannot be overriden");
        }
        // FieldStatisticsGatherer.getFieldStatisticsGatherer().RecordUsage(name,
        // this.required);
    }

    public FieldDefinition(Field field, Class<?> type) {
        this.tag = field.tag();
        this.type = type;
        this.length = field.length();
        this.policy = field.policy();
        if (this.length == 0) {
            if (this.type == Boolean.class) {
                this.length = 1;
            }
            if (this.type == Date.class) {
                this.length = 18;
            }
        }
        if (this.tag == null) {
            this.tag = "";
        }            
        if (this.policy == null) {
            this.policy = FieldPolicy.DEFAULT;
        }
    }
}
