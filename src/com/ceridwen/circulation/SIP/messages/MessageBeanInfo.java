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
package com.ceridwen.circulation.SIP.messages;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

import com.ceridwen.circulation.SIP.types.descriptors.FieldDefinitions;

public abstract class MessageBeanInfo extends SimpleBeanInfo {
	
	protected abstract PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException;

	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			PropertyDescriptor[] pds;
			pds = this.getPropertyDescriptorsInternal();
			FieldDefinitions.fixupFieldDescriptors(this.getClass().getSimpleName(), pds);
			return pds;
		} catch (IntrospectionException e) {
			throw new java.lang.AssertionError(e);
		}
	}

	public java.awt.Image getIcon(int iconKind) {
        return null;
	}
}

