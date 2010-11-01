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

public class VariableFieldDescriptor {
  public static final char TERMINATOR = '|';
  public String ID;
  public boolean required = true;
//  public int minLength;
//  public int maxLength;
//  public int version = 2;

  public VariableFieldDescriptor(String ID) {
    this.ID = ID;
    this.required = true;
//    this.maxLength = -1;
//    version = 2;
  }

  public VariableFieldDescriptor(String ID, boolean required) {
    this.ID = ID;
    this.required = required;
//    this.maxLength = -1;
//    version = 2;
  }

/**
 *   
  public VariableFieldDescriptor(String ID, int minLength, int maxLength, boolean required) {
	    this.ID = ID;
	    this.required = required;
	    this.minLength = minLength;
	    this.maxLength = maxLength;
//	    version = 2;
	  }
*/
/**  
  public VariableFieldDescriptor(String ID, boolean required, int version) {
    this.ID = ID;
    this.required = required;
    this.version = version;
  }
*/  
}
