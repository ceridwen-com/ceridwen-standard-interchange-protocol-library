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
package com.ceridwen.circulation.SIP.types.flagfields;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class AbstractFlagField implements Serializable {

    private static final long serialVersionUID = -3439876098750195408L;
    String flags;

    @Deprecated
    public String getFlags() {
        return this.flags;
    }

    @Deprecated
    public void setFlags(String flags) {
        this.flags = flags;
        this.checkLength();
    }

    AbstractFlagField(String flags) {
        this.flags = flags;
        this.checkLength();
    }

    abstract protected int getLength();

    abstract protected char[] getValid();

    private boolean isValid(char ch) {
        for (char valid : this.getValid()) {
            if (ch == valid) {
                return true;
            }
        }
        return false;
    }

    private void checkLength() {
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < this.getLength(); i++) {
            if (i < this.flags.length()) {
                char ch = this.flags.charAt(i);
                if (this.isValid(ch)) {
                    result.append(ch);
                } else {
                    result.append(this.getValid()[0]);
                }
            } else {
                result.append(this.getValid()[0]);
            }
        }
        this.flags = result.toString();
    }

    @Override
    public String toString() {
        this.checkLength();
        return this.flags;
    }

    public boolean isSet(int field) {
        this.checkLength();
        if ((field < this.flags.length()) && (this.getValid().length > 0)) {
            if (this.flags.charAt(field) == this.getValid()[this.getValid().length - 1]) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void set(int field) {
        this.checkLength();
        if ((field < this.flags.length()) && (this.getValid().length > 0)) {
            this.flags = this.flags.substring(0, field) + this.getValid()[this.getValid().length - 1] + this.flags.substring(field + 1);
        }
    }

    public void unset(int field) {
        this.checkLength();
        if ((field < this.flags.length()) && (this.getValid().length > 0)) {
            this.flags = this.flags.substring(0, field) + this.getValid()[0] + this.flags.substring(field + 1);
        }
    }

    public void unsetAll() {
        this.flags = "";
        this.checkLength();
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }

}
