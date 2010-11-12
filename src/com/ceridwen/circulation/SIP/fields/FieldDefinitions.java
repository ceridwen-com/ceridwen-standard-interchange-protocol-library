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
package com.ceridwen.circulation.SIP.fields;

import java.util.Date;
import java.util.Hashtable;

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
    private static Hashtable<String, FieldDefinition> fields = new Hashtable<String, FieldDefinition>();

    static {
        /**
         * Static Fields
         */
        FieldDefinitions.fields.put("ACSRenewalPolicy", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("alert", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("available", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("blockedCardMessage", new FieldDefinition("AL", String.class, null, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("cancel", new FieldDefinition("BI", Boolean.class, 1, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("cardRetained", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("circulationStatus", new FieldDefinition(null, CirculationStatus.class, 2, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("chargedItems", new FieldDefinition("AU", String[].class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("chargedItemsCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("chargedItemsLimit", new FieldDefinition("CB", Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("checkInOk", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("checkOutOk", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("currencyType", new FieldDefinition("BH", CurrencyType.class, 3, null));
        FieldDefinitions.fields.put("currentLocation", new FieldDefinition("AP", String.class, null, null));
        FieldDefinitions.fields.put("dateTimeSync", new FieldDefinition(null, Date.class, 18, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("desensitize", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("dueDate", new FieldDefinition("AH", String.class, null, null));
        FieldDefinitions.fields.put("emailAddress", new FieldDefinition("BE", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("endItem", new FieldDefinition("BQ", Integer.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("endSession", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("expirationDate", new FieldDefinition("BW", Date.class, 18, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("feeAcknowledged", new FieldDefinition("BO", Boolean.class, 1, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("feeAmount", new FieldDefinition("BV", String.class, null, null));
        FieldDefinitions.fields.put("feeLimit", new FieldDefinition("CC", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("feeIdentifier", new FieldDefinition("CG", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("feeType", new FieldDefinition("BT", FeeType.class, 2, null));
        FieldDefinitions.fields.put("fineItems", new FieldDefinition("AV", String[].class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("fineItemsCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("holdItems", new FieldDefinition("AS", String[].class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("holdItemsCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("holdItemsLimit", new FieldDefinition("BZ", Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("holdMode", new FieldDefinition(null, HoldMode.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("holdPickupDate", new FieldDefinition("CM", Date.class, 18, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("holdQueueLength", new FieldDefinition("CF", Integer.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("holdType", new FieldDefinition("BY", HoldType.class, 1, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("homeAddress", new FieldDefinition("BD", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("homePhoneNumber", new FieldDefinition("BF", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("institutionId", new FieldDefinition("AO", String.class, null, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("itemIdentifier", new FieldDefinition("AB", String.class, null, null));
        FieldDefinitions.fields.put("itemProperties", new FieldDefinition("CH", String.class, null, null));
        FieldDefinitions.fields.put("language", new FieldDefinition(null, Language.class, 3, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("libraryName", new FieldDefinition("AM", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("locationCode", new FieldDefinition("CP", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("loginUserId", new FieldDefinition("CN", String.class, null, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("loginPassword", new FieldDefinition("CO", String.class, null, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("magneticMedia", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("maxPrintWidth", new FieldDefinition(null, Integer.class, 3, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("mediaType", new FieldDefinition("CK", MediaType.class, 3, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("nbDueDate", new FieldDefinition(null, Date.class, 18, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("noBlock", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("offlineOk", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("ok", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("onlineStatus", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("overdueItems", new FieldDefinition("AT", String[].class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("overdueItemsCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("overdueItemsLimit", new FieldDefinition("CA", Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("owner", new FieldDefinition("BG", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("patronIdentifier", new FieldDefinition("AA", String.class, null, null));
        FieldDefinitions.fields.put("patronPassword", new FieldDefinition("AD", String.class, null, null));
        FieldDefinitions.fields.put("patronStatus", new FieldDefinition(null, PatronStatus.class, 14, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("paymentAccepted", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("paymentType", new FieldDefinition(null, PaymentType.class, 2, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("permanentLocation", new FieldDefinition("AQ", String.class, null, null));
        FieldDefinitions.fields.put("personalName", new FieldDefinition("AE", String.class, null, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("pickupLocation", new FieldDefinition("BS", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("printLine", new FieldDefinition("AG", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("protocolVersion", new FieldDefinition(null, ProtocolVersion.class, 4, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("PWDAlgorithm", new FieldDefinition(null, String.class, 1, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("queuePosition", new FieldDefinition("BR", Integer.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("recallDate", new FieldDefinition("CJ", Date.class, 18, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("recallItems", new FieldDefinition("BU", String[].class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("recallItemsCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("renewalOk", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("renewedCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("resensitize", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("retriesAllowed", new FieldDefinition(null, Integer.class, 3, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("returnDate", new FieldDefinition(null, Date.class, 18, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("SCRenewalPolicy", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("securityMarker", new FieldDefinition(null, SecurityMarker.class, 2, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("screenMessage", new FieldDefinition("AF", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("securityInhibit", new FieldDefinition("CI", Boolean.class, 1, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("sortBin", new FieldDefinition("CL", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("startItem", new FieldDefinition("BP", Integer.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("statusCode", new FieldDefinition(null, StatusCode.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("statusUpdateOk", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("summary", new FieldDefinition(null, Summary.class, 10, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("supportedMessages", new FieldDefinition("BX", SupportedMessages.class, 16, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("terminalLocation", new FieldDefinition("AN", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("terminalPassword", new FieldDefinition("AC", String.class, null, null));
        FieldDefinitions.fields.put("thirdPartyAllowed", new FieldDefinition(null, Boolean.class, 1, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("timeoutPeriod", new FieldDefinition(null, Integer.class, 3, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("titleIdentifier", new FieldDefinition("AJ", String.class, null, null));
        FieldDefinitions.fields.put("transactionDate", new FieldDefinition(null, Date.class, 18, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("transactionId", new FieldDefinition("BK", String.class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("UIDAlgorithm", new FieldDefinition(null, String.class, 1, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("unavailableHoldsCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("unavailableHoldItems", new FieldDefinition("CD", String[].class, null, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("unrenewedCount", new FieldDefinition(null, Integer.class, 4, FieldPolicy.REQUIRED));
        FieldDefinitions.fields.put("validPatron", new FieldDefinition("BL", Boolean.class, 1, FieldPolicy.NOT_REQUIRED));
        FieldDefinitions.fields.put("validPatronPassword", new FieldDefinition("CQ", Boolean.class, 1, FieldPolicy.NOT_REQUIRED));

        // FieldStatisticsGatherer.getFieldStatisticsGatherer().LoadFieldDefinitions(fields);
    }
    
    static public PositionedFieldDefinition getPositionedFieldDefinition(String messageName, String fieldName, PositionedField annotation) {
        FieldDefinition field = FieldDefinitions.fields.get(fieldName);
        if (field == null) {
            throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptor not defined: " + fieldName);            
        }
        if (field.length == null) {
            throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptor must explicit length: " + fieldName);
        }
        if ((annotation.end() - annotation.start() + 1) != field.length) {
            throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptors length mismatch: " + fieldName);
        }
        PositionedFieldDefinition pfd = new PositionedFieldDefinition(fieldName, annotation.start(),
                annotation.end(), field, annotation.policy());
        return pfd;        
    }

    static public TaggedFieldDefinition getTaggedFieldDefinition(String messageName, String fieldName, TaggedField annotation) {
        FieldDefinition field = FieldDefinitions.fields.get(fieldName);
        if (field == null) {
            throw new java.lang.AssertionError(messageName + " - Tagged FieldDescriptor not defined: " + fieldName);            
        }
        TaggedFieldDefinition tfd = new TaggedFieldDefinition(fieldName, field, annotation.value());
        return tfd;
    }    
}
