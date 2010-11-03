package com.ceridwen.circulation.SIP.types.descriptors;

import java.beans.PropertyDescriptor;
import java.util.Date;
import java.util.Hashtable;

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
	    fields.put("alert", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("available", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("blockedCardMessage", new FieldDescriptor("AL", String.class, null, true));
		fields.put("cancel", new FieldDescriptor("BI", Boolean.class, 1, false));
		fields.put("cardRetained", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("circulationStatus", new FieldDescriptor(null, CirculationStatus.class, 2, true));
		fields.put("chargedItems", new FieldDescriptor("AU", String[].class, null, false));
		fields.put("chargedItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
		fields.put("chargedItemsLimit", new FieldDescriptor("CB", Integer.class, 4, false));
		fields.put("checkInOk", new FieldDescriptor(null, Boolean.class, 1, true));
	    fields.put("checkOutOk", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("currencyType", new FieldDescriptor("BH", CurrencyType.class, 3, null));
		fields.put("currentLocation", new FieldDescriptor("AP", String.class, null, null));
		fields.put("dateTimeSync", new FieldDescriptor(null, Date.class, 18, false));
		fields.put("desensitize", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("dueDate", new FieldDescriptor("AH", String.class, null, null));
		fields.put("eMailAddress", new FieldDescriptor("BE", String.class, null, false));
		fields.put("endItem", new FieldDescriptor("BQ", Integer.class, null, false));
	    fields.put("endSession", new FieldDescriptor(null, Boolean.class, 1, true));		
		fields.put("expirationDate", new FieldDescriptor("BW", Date.class, 18, false));
		fields.put("feeAcknowledged", new FieldDescriptor("BO", Boolean.class, 1,false));
		fields.put("feeAmount", new FieldDescriptor("BV", String.class, null, null));
		fields.put("feeLimit", new FieldDescriptor("CC", String.class, null, false));
		fields.put("feeIdentifier", new FieldDescriptor("CG", String.class, null, false));
		fields.put("feeType", new FieldDescriptor("BT", FeeType.class, 2, null));
		fields.put("fineItems", new FieldDescriptor("AV", String[].class, null, false));
		fields.put("fineItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
		fields.put("holdItems", new FieldDescriptor("AS", String[].class, null, false));
		fields.put("holdItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
		fields.put("holdItemsLimit", new FieldDescriptor("BZ", Integer.class, 4, false));
		fields.put("holdMode", new FieldDescriptor(null, HoldMode.class, 1, true));
		fields.put("holdPickupDate", new FieldDescriptor("CM", Date.class, 18, false));
		fields.put("holdQueueLength", new FieldDescriptor("CF", Integer.class, null, false));
		fields.put("holdType", new FieldDescriptor("BY", HoldType.class, 1, false));
		fields.put("homeAddress", new FieldDescriptor("BD", String.class, null, false));
		fields.put("homePhoneNumber", new FieldDescriptor("BF", String.class, null, false));
		fields.put("institutionId", new FieldDescriptor("AO", String.class, null, true));
		fields.put("itemIdentifier", new FieldDescriptor("AB", String.class, null, null));
		fields.put("itemProperties", new FieldDescriptor("CH", String.class, null, null));
		fields.put("language", new FieldDescriptor(null, Language.class, 3, true));
		fields.put("libraryName", new FieldDescriptor("AM", String.class, null, false));
		fields.put("locationCode", new FieldDescriptor("CP", String.class, null, false));
		fields.put("loginUserId", new FieldDescriptor("CN", String.class, null, true));
		fields.put("loginPassword", new FieldDescriptor("CO", String.class, null, true));
		fields.put("magneticMedia", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("maxPrintWidth", new FieldDescriptor(null, Integer.class, 3, true)); 
		fields.put("mediaType", new FieldDescriptor("CK", MediaType.class, 3, false));
		fields.put("nbDueDate", new FieldDescriptor(null, Date.class, 18, false));
		fields.put("noBlock", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("offlineOk", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("ok", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("onLineStatus", new FieldDescriptor(null, Boolean.class, 1, true)); //TODO consistency with offline
		fields.put("overdueItems", new FieldDescriptor("AT", String[].class, null, false));
		fields.put("overdueItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
		fields.put("overdueItemsLimit", new FieldDescriptor("CA", Integer.class, 4, false));
		fields.put("owner", new FieldDescriptor("BG", String.class, null, false));
		fields.put("patronIdentifier", new FieldDescriptor("AA", String.class, null, null));
		fields.put("patronPassword", new FieldDescriptor("AD", String.class, null, null));
		fields.put("patronStatus", new FieldDescriptor(null, PatronStatus.class, 14, false));
		fields.put("paymentAccepted", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("paymentType", new FieldDescriptor(null, PaymentType.class, 2, true));
		fields.put("permanentLocation", new FieldDescriptor("AQ", String.class, null, null));
        fields.put("personalName", new FieldDescriptor("AE", String.class, null, true));
		fields.put("pickupLocation", new FieldDescriptor("BS", String.class, null, false));	
		fields.put("printLine", new FieldDescriptor("AG", String.class, null, false));
		fields.put("protocolVersion", new FieldDescriptor(null, ProtocolVersion.class, 4, true));
		fields.put("PWDAlgorithm", new FieldDescriptor(null, String.class, 1, false));
		fields.put("queuePosition", new FieldDescriptor("BR", Integer.class, null, false));
		fields.put("recallDate", new FieldDescriptor("CJ", Date.class, 18, false));
		fields.put("recallItems", new FieldDescriptor("BU", String[].class, null, false));
		fields.put("recallItemsCount", new FieldDescriptor(null, Integer.class, 4, false));
		fields.put("renewalOk", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("renewalPolicy", new FieldDescriptor(null, Boolean.class, 1, true)); // TODO change to ACSRenewalPolicy
		fields.put("renewedCount", new FieldDescriptor(null, Integer.class, 4, true));
		fields.put("resensitize", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("retriesAllowed", new FieldDescriptor(null, Integer.class, 3, true));
		fields.put("returnDate", new FieldDescriptor(null, Date.class, 18, false));
		fields.put("securityMarker", new FieldDescriptor(null, SecurityMarker.class, 2, true));
		fields.put("screenMessage", new FieldDescriptor("AF", String.class, null, false));
		fields.put("securityInhibit", new FieldDescriptor("CI", Boolean.class, 1, false));
		fields.put("sortBin", new FieldDescriptor("CL", String.class, null, false));
		fields.put("startItem", new FieldDescriptor("BP", Integer.class, null, false));
		fields.put("statusCode", new FieldDescriptor(null, StatusCode.class, 1, true));
		fields.put("statusUpdateOk", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("summary", new FieldDescriptor(null, Summary.class, 10, false));
		fields.put("supportedMessages", new FieldDescriptor("BX", SupportedMessages.class, 16, true));
		fields.put("terminalLocation", new FieldDescriptor("AN", String.class, null, false));
	    fields.put("terminalPassword", new FieldDescriptor("AC", String.class, null, null));	
		fields.put("thirdPartyAllowed", new FieldDescriptor(null, Boolean.class, 1, true));
		fields.put("timeoutPeriod", new FieldDescriptor(null, Integer.class, 3, true));
		fields.put("titleIdentifier", new FieldDescriptor("AJ", String.class, null, null));
		fields.put("transactionDate", new FieldDescriptor(null, Date.class, 18, true));
		fields.put("transactionId", new FieldDescriptor("BK", String.class, null, false));
		fields.put("UIDAlgorithm", new FieldDescriptor(null, String.class, 1, false));
		fields.put("unavailableHoldsCount", new FieldDescriptor(null, Integer.class, 4, false));		
		fields.put("unavailableHoldItems", new FieldDescriptor("CD", String[].class, null, false));
		fields.put("unrenewedCount", new FieldDescriptor(null, Integer.class, 4, true));
		fields.put("validPatron", new FieldDescriptor("BL", Boolean.class, 1, false));
		fields.put("validPatronPassword", new FieldDescriptor("CQ", Boolean.class, 1, false));
	}

    static public void fixupFieldDescriptors(String messageName, PropertyDescriptor[] pds)
	{
		for (PropertyDescriptor pd: pds) {
			String name = pd.getName();
			FieldDescriptor field = fields.get(name);
			if (field == null) {
				throw new java.lang.AssertionError(messageName + " - Unknown field: " + name);
			}
			
			if (field.type != pd.getPropertyType()) {
				throw new java.lang.AssertionError(messageName + " - Invalid type: " + name);				
			}
			
			FieldDescriptor fd = (FieldDescriptor)pd.getValue("SIPFieldDescriptor");
			
			if (fd != null) { 
				if (fd.getClass() == PositionedFieldDescriptor.class) {
					if (field.length == null) {
						throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptor must explicit length: " + name);																				
					}
					if ((((PositionedFieldDescriptor)fd).end - ((PositionedFieldDescriptor)fd).start + 1) != field.length) {
						throw new java.lang.AssertionError(messageName + " - Positioned FieldDescriptors length mismatch: " + name);														
					}	
					PositionedFieldDescriptor pfd = new PositionedFieldDescriptor(((PositionedFieldDescriptor)fd).start, ((PositionedFieldDescriptor)fd).end, field, ((PositionedFieldDescriptor)fd).required);
					pd.setValue("SIPFieldDescriptor", pfd);
				} else if (fd.getClass() == TaggedFieldDescriptor.class) {
					TaggedFieldDescriptor tfd = new TaggedFieldDescriptor(field, fd.required);
					pd.setValue("SIPFieldDescriptor", tfd);					
				} else {
					throw new java.lang.AssertionError(messageName + " - Unknown field descriptor: " + name);
				}
			} else {
				if (field.tag == null) {
					throw new java.lang.AssertionError(messageName + " - Tagged FieldDescriptor must have explicit tag: " + name);					
				}
				TaggedFieldDescriptor tfd = new TaggedFieldDescriptor(field, null);
				pd.setValue("SIPFieldDescriptor", tfd);					
			}
		}
	}
}
