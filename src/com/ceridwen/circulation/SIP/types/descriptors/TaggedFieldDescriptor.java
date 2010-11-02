/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * <http://www.gnu.org/licenses/>.
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
 *     Matthew J. Dovey - initial API and implementation
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

public class TaggedFieldDescriptor extends FieldDescriptor {
  public static final char TERMINATOR = '|';

  protected TaggedFieldDescriptor(FieldDescriptor d, Boolean required)
  {
	  this.tag = d.tag;
	  this.length = d.length;
	  if (d.required == null && required != null) {
		  this.required = required;
  	  } else if (d.required == null && required == null) {
		  throw new java.lang.AssertionError(d.tag + " mutable required state needs explicit value");																  
  	  } else if  (d.required != null && required == null) {
  		  this.required = d.required;
  	  } else {
		  throw new java.lang.AssertionError(d.tag + " immutable required state cannot be overriden");																  
  	  }
  }
  
  public TaggedFieldDescriptor(Boolean required) {
	  this.required = required;
  }
  
}
