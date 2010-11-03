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
package com.ceridwen.circulation.SIP.types.descriptors;

public class FieldDescriptor {
	public String tag;
	public Class<?> type;
	public Integer length;
	public Boolean required;
	
	protected FieldDescriptor()
	{
	}
	
	protected FieldDescriptor(String name, FieldDescriptor d, Boolean required) {
 	  this.tag = d.tag;
	  this.length = d.length;
	  if (d.required == null && required != null) {
		  this.required = required;
  	  } else if (d.required == null && required == null) {
		  throw new java.lang.AssertionError(name + " mutable required state needs explicit value");																  
  	  } else if  (d.required != null && required == null) {
  		  this.required = d.required;
  	  } else {
		  throw new java.lang.AssertionError(name + " immutable required state cannot be overriden");																  
  	  }
//	  FieldStatisticsGatherer.getFieldStatisticsGatherer().RecordUsage(name, this.required);
	}	
	
	protected FieldDescriptor(String tag, Class<?> type, Integer length, Boolean required)
	{
		this.tag = tag;
		this.type = type;
		this.length = length;
		this.required = required;
	}	
}
