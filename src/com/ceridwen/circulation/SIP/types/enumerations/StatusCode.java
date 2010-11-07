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

public enum StatusCode implements AbstractEnumeration {
    OK("0"),
    OUT_OF_PAPER("1"),
    SHUTTING_DOWN("2");

    private final String code;

    private StatusCode(String code) {
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
        for (AbstractEnumeration i : StatusCode.values()) {
            if (i.getCode().equals(code)) {
                return i;
            }
        }
        return null;
    }
}
