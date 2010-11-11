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

import java.beans.PropertyDescriptor;
import java.util.Date;
import java.util.Hashtable;

import com.ceridwen.circulation.SIP.annotations.FieldPolicy;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TaggedField;
import com.ceridwen.circulation.SIP.types.enumerations.CirculationStatus;
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.HoldMode;
import com.ceridwen.circulation.SIP.types.enumerations.HoldType;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;
import com.ceridwen.circulation.SIP.types.enumerations.PaymentType;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.enumerations.SecurityMarker;
import com.ceridwen.circulation.SIP.types.enumerations.StatusCode;
import com.ceridwen.circulation.SIP.types.flagfields.PatronStatus;
import com.ceridwen.circulation.SIP.types.flagfields.Summary;
import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;

public class FieldDefinitions {
    private static Hashtable<String, FieldDescriptor> fields = new Hashtable<String, FieldDescriptor>();

    static {
        /**
         * Static Fields
         */
        FieldDefinitions.fields.put("ACSRenewalPolicy", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("alert", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("available", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("blockedCardMessage", new FieldDescriptor("AL", String.class, null, true));
        FieldDefinitions.fields.put("cancel", new FieldDescriptor("BI", Boolean.class, 1, false));
        FieldDefinitions.fields.put("cardRetained", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("circulationStatus", new FieldDescriptor(null, CirculationStatus.class, 2, true));
        FieldDefinitions.fields.put("chargedItems", new FieldDescriptor("AU", String[].class, null, false));
        FieldDefinitions.fields.put("chargedItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
        FieldDefinitions.fields.put("chargedItemsLimit", new FieldDescriptor("CB", Integer.class, 4, false));
        FieldDefinitions.fields.put("checkInOk", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("checkOutOk", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("currencyType", new FieldDescriptor("BH", CurrencyType.class, 3, null));
        FieldDefinitions.fields.put("currentLocation", new FieldDescriptor("AP", String.class, null, null));
        FieldDefinitions.fields.put("dateTimeSync", new FieldDescriptor(null, Date.class, 18, true));
        FieldDefinitions.fields.put("desensitize", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("dueDate", new FieldDescriptor("AH", String.class, null, null));
        FieldDefinitions.fields.put("eMailAddress", new FieldDescriptor("BE", String.class, null, false));
        FieldDefinitions.fields.put("endItem", new FieldDescriptor("BQ", Integer.class, null, false));
        FieldDefinitions.fields.put("endSession", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("expirationDate", new FieldDescriptor("BW", Date.class, 18, false));
        FieldDefinitions.fields.put("feeAcknowledged", new FieldDescriptor("BO", Boolean.class, 1, false));
        FieldDefinitions.fields.put("feeAmount", new FieldDescriptor("BV", String.class, null, null));
        FieldDefinitions.fields.put("feeLimit", new FieldDescriptor("CC", String.class, null, false));
        FieldDefinitions.fields.put("feeIdentifier", new FieldDescriptor("CG", String.class, null, false));
        FieldDefinitions.fields.put("feeType", new FieldDescriptor("BT", FeeType.class, 2, null));
        FieldDefinitions.fields.put("fineItems", new FieldDescriptor("AV", String[].class, null, false));
        FieldDefinitions.fields.put("fineItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
        FieldDefinitions.fields.put("holdItems", new FieldDescriptor("AS", String[].class, null, false));
        FieldDefinitions.fields.put("holdItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
        FieldDefinitions.fields.put("holdItemsLimit", new FieldDescriptor("BZ", Integer.class, 4, false));
        FieldDefinitions.fields.put("holdMode", new FieldDescriptor(null, HoldMode.class, 1, true));
        FieldDefinitions.fields.put("holdPickupDate", new FieldDescriptor("CM", Date.class, 18, false));
        FieldDefinitions.fields.put("holdQueueLength", new FieldDescriptor("CF", Integer.class, null, false));
        FieldDefinitions.fields.put("holdType", new FieldDescriptor("BY", HoldType.class, 1, false));
        FieldDefinitions.fields.put("homeAddress", new FieldDescriptor("BD", String.class, null, false));
        FieldDefinitions.fields.put("homePhoneNumber", new FieldDescriptor("BF", String.class, null, false));
        FieldDefinitions.fields.put("institutionId", new FieldDescriptor("AO", String.class, null, true));
        FieldDefinitions.fields.put("itemIdentifier", new FieldDescriptor("AB", String.class, null, null));
        FieldDefinitions.fields.put("itemProperties", new FieldDescriptor("CH", String.class, null, null));
        FieldDefinitions.fields.put("language", new FieldDescriptor(null, Language.class, 3, true));
        FieldDefinitions.fields.put("libraryName", new FieldDescriptor("AM", String.class, null, false));
        FieldDefinitions.fields.put("locationCode", new FieldDescriptor("CP", String.class, null, false));
        FieldDefinitions.fields.put("loginUserId", new FieldDescriptor("CN", String.class, null, true));
        FieldDefinitions.fields.put("loginPassword", new FieldDescriptor("CO", String.class, null, true));
        FieldDefinitions.fields.put("magneticMedia", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("maxPrintWidth", new FieldDescriptor(null, Integer.class, 3, true));
        FieldDefinitions.fields.put("mediaType", new FieldDescriptor("CK", MediaType.class, 3, false));
        FieldDefinitions.fields.put("nbDueDate", new FieldDescriptor(null, Date.class, 18, false));
        FieldDefinitions.fields.put("noBlock", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("offlineOk", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("ok", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("onlineStatus", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("overdueItems", new FieldDescriptor("AT", String[].class, null, false));
        FieldDefinitions.fields.put("overdueItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
        FieldDefinitions.fields.put("overdueItemsLimit", new FieldDescriptor("CA", Integer.class, 4, false));
        FieldDefinitions.fields.put("owner", new FieldDescriptor("BG", String.class, null, false));
        FieldDefinitions.fields.put("patronIdentifier", new FieldDescriptor("AA", String.class, null, null));
        FieldDefinitions.fields.put("patronPassword", new FieldDescriptor("AD", String.class, null, null));
        FieldDefinitions.fields.put("patronStatus", new FieldDescriptor(null, PatronStatus.class, 14, false));
        FieldDefinitions.fields.put("paymentAccepted", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("paymentType", new FieldDescriptor(null, PaymentType.class, 2, true));
        FieldDefinitions.fields.put("permanentLocation", new FieldDescriptor("AQ", String.class, null, null));
        FieldDefinitions.fields.put("personalName", new FieldDescriptor("AE", String.class, null, true));
        FieldDefinitions.fields.put("pickupLocation", new FieldDescriptor("BS", String.class, null, false));
        FieldDefinitions.fields.put("printLine", new FieldDescriptor("AG", String.class, null, false));
        FieldDefinitions.fields.put("protocolVersion", new FieldDescriptor(null, ProtocolVersion.class, 4, true));
        FieldDefinitions.fields.put("PWDAlgorithm", new FieldDescriptor(null, String.class, 1, false));
        FieldDefinitions.fields.put("queuePosition", new FieldDescriptor("BR", Integer.class, null, false));
        FieldDefinitions.fields.put("recallDate", new FieldDescriptor("CJ", Date.class, 18, false));
        FieldDefinitions.fields.put("recallItems", new FieldDescriptor("BU", String[].class, null, false));
        FieldDefinitions.fields.put("recallItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
        FieldDefinitions.fields.put("renewalOk", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("renewedCount", new FieldDescriptor(null, Integer.class, 4, true));
        FieldDefinitions.fields.put("resensitize", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("retriesAllowed", new FieldDescriptor(null, Integer.class, 3, true));
        FieldDefinitions.fields.put("returnDate", new FieldDescriptor(null, Date.class, 18, false));
        FieldDefinitions.fields.put("SCRenewalPolicy", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("securityMarker", new FieldDescriptor(null, SecurityMarker.class, 2, true));
        FieldDefinitions.fields.put("screenMessage", new FieldDescriptor("AF", String.class, null, false));
        FieldDefinitions.fields.put("securityInhibit", new FieldDescriptor("CI", Boolean.class, 1, false));
        FieldDefinitions.fields.put("sortBin", new FieldDescriptor("CL", String.class, null, false));
        FieldDefinitions.fields.put("startItem", new FieldDescriptor("BP", Integer.class, null, false));
        FieldDefinitions.fields.put("statusCode", new FieldDescriptor(null, StatusCode.class, 1, true));
        FieldDefinitions.fields.put("statusUpdateOk", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("summary", new FieldDescriptor(null, Summary.class, 10, false));
        FieldDefinitions.fields.put("supportedMessages", new FieldDescriptor("BX", SupportedMessages.class, 16, true));
        FieldDefinitions.fields.put("terminalLocation", new FieldDescriptor("AN", String.class, null, false));
        FieldDefinitions.fields.put("terminalPassword", new FieldDescriptor("AC", String.class, null, null));
        FieldDefinitions.fields.put("thirdPartyAllowed", new FieldDescriptor(null, Boolean.class, 1, true));
        FieldDefinitions.fields.put("timeoutPeriod", new FieldDescriptor(null, Integer.class, 3, true));
        FieldDefinitions.fields.put("titleIdentifier", new FieldDescriptor("AJ", String.class, null, null));
        FieldDefinitions.fields.put("transactionDate", new FieldDescriptor(null, Date.class, 18, true));
        FieldDefinitions.fields.put("transactionId", new FieldDescriptor("BK", String.class, null, false));
        FieldDefinitions.fields.put("UIDAlgorithm", new FieldDescriptor(null, String.class, 1, false));
        FieldDefinitions.fields.put("unavailableHoldsCount", new FieldDescriptor(null, Integer.class, 4, false));
        FieldDefinitions.fields.put("unavailableHoldItems", new FieldDescriptor("CD", String[].class, null, false));
        FieldDefinitions.fields.put("unrenewedCount", new FieldDescriptor(null, Integer.class, 4, true));
        FieldDefinitions.fields.put("validPatron", new FieldDescriptor("BL", Boolean.class, 1, false));
        FieldDefinitions.fields.put("validPatronPassword", new FieldDescriptor("CQ", Boolean.class, 1, false));

        // FieldStatisticsGatherer.getFieldStatisticsGatherer().LoadFieldDefinitions(fields);
    }
    
    static public PositionedFieldDescriptor getPositionedFieldDescriptor(String messageName, String fieldName, PositionedField annotation) {
        FieldDescriptor field = FieldDefinitions.fields.get(fieldName);
        if (field.length == null) {
            throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptor must explicit length: " + fieldName);
        }
        if ((annotation.end() - annotation.start() + 1) != field.length) {
            throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptors length mismatch: " + fieldName);
        }
        FieldPolicy policy = annotation.policy();
        Boolean required = null;
        if (policy == FieldPolicy.REQUIRED) {
            required = true;
        }
        if (policy == FieldPolicy.NOT_REQUIRED) {
            required = false;
        }
        PositionedFieldDescriptor pfd = new PositionedFieldDescriptor(fieldName, annotation.start(),
                annotation.end(), field, required);
        return pfd;
        
    }

    static public TaggedFieldDescriptor getTaggedFieldDescriptor(String messageName, String fieldName, TaggedField annotation) {
        FieldDescriptor field = FieldDefinitions.fields.get(fieldName);
        FieldPolicy policy = annotation.value();
        Boolean required = null;
        if (policy == FieldPolicy.REQUIRED) {
            required = true;
        }
        if (policy == FieldPolicy.NOT_REQUIRED) {
            required = false;
        }
        TaggedFieldDescriptor tfd = new TaggedFieldDescriptor(fieldName, field, required);
        return tfd;
    }
    
    
    static public void fixupFieldDescriptors(String messageName, PropertyDescriptor[] pds) {
        for (PropertyDescriptor pd : pds) {
            String name = pd.getName();
            FieldDescriptor field = FieldDefinitions.fields.get(name);
            if (field == null) {
                throw new java.lang.AssertionError(messageName + " - Unknown field: " + name);
            }

            if (field.type != pd.getPropertyType()) {
                throw new java.lang.AssertionError(messageName + " - Invalid type: " + name);
            }

            FieldDescriptor fd = (FieldDescriptor) pd.getValue("SIPFieldDescriptor");

            if (fd != null) {
                if (fd.getClass() == PositionedFieldDescriptor.class) {
                    if (field.length == null) {
                        throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptor must explicit length: " + name);
                    }
                    if ((((PositionedFieldDescriptor) fd).end - ((PositionedFieldDescriptor) fd).start + 1) != field.length) {
                        throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptors length mismatch: " + name);
                    }
                    PositionedFieldDescriptor pfd = new PositionedFieldDescriptor(name, ((PositionedFieldDescriptor) fd).start,
                            ((PositionedFieldDescriptor) fd).end, field, ((PositionedFieldDescriptor) fd).required);
                    pd.setValue("SIPFieldDescriptor", pfd);
                } else if (fd.getClass() == TaggedFieldDescriptor.class) {
                    TaggedFieldDescriptor tfd = new TaggedFieldDescriptor(name, field, fd.required);
                    pd.setValue("SIPFieldDescriptor", tfd);
                } else {
                    throw new java.lang.AssertionError(messageName + " - Unknown field descriptor: " + name);
                }
            } else {
                if (field.tag == null) {
                    throw new java.lang.AssertionError(messageName + " - Tagged FieldDescriptor must have explicit tag: " + name);
                }
                TaggedFieldDescriptor tfd = new TaggedFieldDescriptor(name, field, null);
                pd.setValue("SIPFieldDescriptor", tfd);
            }
        }
    }
}
