/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey (www.ceridwen.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at 
 * <http://www.gnu.org/licenses/>
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Matthew J. Dovey (www.ceridwen.com) - initial API and implementation
 ******************************************************************************/
package com.ceridwen.circulation.SIP.types.enumerations;

public enum CirculationStatus implements AbstractEnumeration {
    OTHER("01"),
    ON_ORDER("02"),
    AVAILABLE("03"),
    CHARGED("04"),
    CHARGED_UNTIL_RECALL_DATE("05"),
    IN_PROCESS("06"),
    RECALLED("07"),
    ON_HOLD_SHELF("08"),
    AWAITING_RESHELVING("09"),
    IN_TRANSIT("10"),
    CLAIMED_RETURN("11"),
    LOST("12"),
    MISSING("13");

    private final String code;

    private CirculationStatus(String code) {
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
        for (AbstractEnumeration i : CirculationStatus.values()) {
            if (i.getCode().equals(code)) {
                return i;
            }
        }
        return null;
    }
}
