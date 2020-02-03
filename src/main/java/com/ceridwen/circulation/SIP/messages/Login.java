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
package com.ceridwen.circulation.SIP.messages;

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TaggedField;
import com.ceridwen.circulation.SIP.annotations.TestCaseDefault;
import com.ceridwen.circulation.SIP.annotations.TestCasePopulated;

@Command("93")
@TestCaseDefault("93  CN|CO|")
@TestCasePopulated("93UPCNloginUserId|COloginPassword|CPlocationCode|")
public class Login extends Message {
    private static final long serialVersionUID = -5732581787865741081L;
    @PositionedField(start = 2, end = 2)
    private String UIDAlgorithm;
    @PositionedField(start = 3, end = 3)
    private String PWDAlgorithm;
    @TaggedField
    private String loginUserId;
    @TaggedField
    private String loginPassword;
    @TaggedField
    private String locationCode;

    public String getUIDAlgorithm() {
        return this.UIDAlgorithm;
    }

    public void setUIDAlgorithm(String UIDAlgorithm) {
        this.UIDAlgorithm = UIDAlgorithm;
    }

    public String getPWDAlgorithm() {
        return this.PWDAlgorithm;
    }

    public void setPWDAlgorithm(String PWDAlgorithm) {
        this.PWDAlgorithm = PWDAlgorithm;
    }

    public String getLoginUserId() {
        return this.loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

}
