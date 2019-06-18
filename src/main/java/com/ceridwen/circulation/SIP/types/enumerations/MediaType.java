/* 
 * Copyright (C) 2019 Ceridwen Limited
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

public enum MediaType implements AbstractEnumeration {
    OTHER("000"),
    BOOK("001"),
    MAGAZINE("002"),
    BOUND_JOURNAL("003"),
    AUDIO_TAPE("004"),
    VIDEO_TAPE("005"),
    CD("006"),
    DISKETTE("007"),
    BOOK_WITH_DISKETTE("008"),
    BOOK_WITH_CD("009"),
    BOOK_WITH_AUDIO_TAPE("010");

    private final String code;

    private MediaType(String code) {
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
        for (AbstractEnumeration i : MediaType.values()) {
            if (i.getCode().equals(code)) {
                return i;
            }
        }
        return null;
    }
}
