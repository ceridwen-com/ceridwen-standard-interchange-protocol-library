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
package com.ceridwen.circulation.SIP.messages;

import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.enumerations.StatusCode;



/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class SCStatus extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6198644705404364776L;
	private StatusCode statusCode;
	private Integer maxPrintWidth;
	private ProtocolVersion protocolVersion;

  public String getCommand() {
    return "99";
  }
  public Integer getMaxPrintWidth() {
    return maxPrintWidth;
  }
  public ProtocolVersion getProtocolVersion() {
    return protocolVersion;
  }
  public StatusCode getStatusCode() {
    return statusCode;
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
