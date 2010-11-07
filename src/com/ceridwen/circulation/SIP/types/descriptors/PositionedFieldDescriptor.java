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
/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.types.descriptors;

public class PositionedFieldDescriptor extends FieldDescriptor {
    public int start;
    public int end;
    @SuppressWarnings("unused")
    private final String tag = null;

    protected PositionedFieldDescriptor(String name, int start, int end, FieldDescriptor d, Boolean required) {
        super(name, d, required);
        this.start = start;
        this.end = end;
    }

    public PositionedFieldDescriptor(int start, int end) {
        this.start = start;
        this.end = end;
        this.required = null;
    }

    public PositionedFieldDescriptor(int start, int end, Boolean required) {
        this.start = start;
        this.end = end;
        this.required = required;
    }
}
