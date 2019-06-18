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
package com.ceridwen.circulation.SIP.messages;

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TestCaseDefault;
import com.ceridwen.circulation.SIP.annotations.TestCasePopulated;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.enumerations.StatusCode;

@Command("99")
@TestCaseDefault("9900002.00")
@TestCasePopulated("9921231.00")
public class SCStatus extends Message {
    private static final long serialVersionUID = -6198644705404364776L;
    @PositionedField(start = 2, end = 2)
    private StatusCode statusCode;
    @PositionedField(start = 3, end = 5)
    private Integer maxPrintWidth;
    @PositionedField(start = 6, end = 9)
    private ProtocolVersion protocolVersion;

    public Integer getMaxPrintWidth() {
        return this.maxPrintWidth;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protocolVersion;
    }

    public StatusCode getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public void setMaxPrintWidth(Integer maxPrintWidth) {
        this.maxPrintWidth = maxPrintWidth;
    }
}
