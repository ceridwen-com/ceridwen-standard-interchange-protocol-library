**Version 2.9.8: 03/02/2020**
Fixed checksum generation (courtesy of https://github.com/zcc39r)
Dependencies: ceridwen utility 1.7.1
              apache commons beanutils 1.9.4
              apache commons lang 3.9
              apache commons logging 1.2 
              apache commons net 3.6
              io.netty transport 4.1.45.Final
              io.netty handler 4.1.45.Final

**Version 2.9.7: 18/06/2019**
Updated pom.xml to maven central requirements
Updated copyright notice to current year
Dependencies: ceridwen utility 1.7.1
              apache commons beanutils 1.9.3
              apache commons lang 3.9
              apache commons logging 1.2 
              apache commons net 3.6
              io.netty transport 4.1.36.Final
              io.netty handler 4.1.36.Final

**Version 2.9.6: 16/06/2019**
Set onlinestatus to true in AbstractDriver.java
Reduce force disconnect scenarios
Fix sequence checking logic (Courtesy of https://github.com/pranavbhatt)
String handling optimisations (Courtesy of https://github.com/pranavbhatt)
Make SocketConnection autoclosable (Courtesy of https://github.com/pranavbhatt)
Perform verification of server hostname (Courtesy of https://github.com/xanc)
Dependencies: ceridwen utility 1.7.0
              apache commons beanutils 1.9.3
              apache commons lang 3.9
              apache commons logging 1.2 
              apache commons net 3.6
              io.netty transport 4.1.36.Final
              io.netty handler 4.1.36.Final

**Version 2.9.5: 20/06/2017**
Refactored flag field type to be more bean-like
Fixed unwanted array index out of bounds exception if repeating field is set to zero length array
Dependencies: ceridwen utility 1.6.2
              apache commons beanutils 1.9.3
              apache commons lang 3.6
              apache commons logging 1.2 
              apache commons net 3.6
              io.netty transport 4.1.12.Final
              io.netty handler 4.1.12.Final

**Version 2.9.4: 20/02/2017**
Made field ordering option constants publicly accessible
Update dependencies apache commons lang and net
Dependencies: ceridwen utility 1.6.2
              apache commons beanutils 1.9.3
              apache commons lang 3.5
              apache commons logging 1.2 
              apache commons net 3.6
              io.netty transport 4.1.5.Final
              io.netty handler 4.1.5.Final

**Version 2.9.3: 10/10/2016**
Update sample to use netty server
Added SSL Socket client connection
Updated Netty SSL server to load certificates
Dependencies: ceridwen utility 1.6.2
              apache commons beanutils 1.9.3
              apache commons lang 3.4
              apache commons logging 1.2 
              apache commons net 3.5
              io.netty transport 4.1.5.Final
              io.netty handler 4.1.5.Final

**Version 2.9.2: 20/04/2016**
Added netty server implementation
Added field ordering options (alphabetic or specification listed)
Changed holdQueueLength definition to match 3M emulator rather than specification
Dependencies: ceridwen utility 1.6.2
              apache commons beanutils 1.9.2
              apache commons lang 3.4
              apache commons logging 1.2 
              apache commons net 3.4
              io.netty transport 4.0.36.Final
              io.netty handler 4.0.36.Final
          

Version 2.91: 02/02/2013 (525)
Fixed issues in handling non-ASCII data: corrected checksum calculation; allowed configuration of code page encoding.
Dependencies: ceridwen utilities 1.60
              apache commons beanutils 1.8.3
              apache commons lang 3.1
              apache commons logging 1.1.1 
              apache commons net 3.1

**Version 2.90: 27/07/2012 (479)**
Sample code connected to wrong port for demo server
Commands terminated by \n rather than \r on linux platforms
Dependencies: ceridwen utilities 1.60
              apache commons beanutils 1.8.3
              apache commons lang 3.1
              apache commons logging 1.1.1 
              apache commons net 3.1

**Version 2.81: 25/03/2012 (469)**
Update Ceridwen Utilities from 1.51 to 1.60
Some jUnit tests were dependent on timezone
Dependencies: ceridwen utilities 1.60
              apache commons beanutils 1.8.3
              apache commons lang 3.1
              apache commons logging 1.1.1 
              apache commons net 3.1

**Version 2.80: 15/03/2012 (426)**
Update Ceridwen Utilities from 1.40 to 1.51
Update Apache Commons Lang3 from 3.0 to 3.1
Update Apache Commons Net from 2.0 to 3.1
Dependencies: ceridwen utilities 1.51
              apache commons beanutils 1.8.3
              apache commons lang 3.1
              apache commons logging 1.1.1 
              apache commons net 3.1

**Version 2.70: 10/08/2011 (372)**
Merge with annotation refactoring
Fixed bugs when autopopulation is not bidirectional 
Requires Ceridwen Utilities Library 1.40

**Version 2.60: 22/7/2011 (363)**
AutoPopulationEmptyRequiredFields can now be set to off, decode, encode or bidirectional (default)
Refactored to use StringUtils.isEmpty
Changed boolean getter methods to is... from get...
Added system property com.ceridwen.circulation.SIP.messages.AutoPopulationEmptyRequiredFields
  If true (default will generate default values for empty required fields, e.g. false for bool, 0 for integer, initial value for Enumerations etc.)
  If false will generate MandatoryFieldOmmitted exception is require field not explicitly set
  Previous behaviour equivalent to true
ACS/SCRenevalPolicy and onlineStatus named to be consistent with spec.
Requires Ceridwen Utilities Library 1.40

**Version 2.50: 3/11/2010 (255) - Public Release**
Refactoring to consolidated the message fields definitions into FieldDefinitions class
Changed ProtocolVersion to enumerated type
Added handling of required Enumerated types when encoding
Added code for handling required Integer, Date and Boolean fields during encoding
Change relevant fields from String to Integer
Added length checking, padding and trimming
Added jUnit tests for message encoding/decoding
Bugfix: Corrected HoldResponse definition (tagged field was defined as a positioned field)
Bugfix: Corrected spelling of Magnetic
Bugfix: Change noBlockDueDate to nbDueDate and printling to printLine for consistency
Bugfix: Incorrect positionedfield definition for overdueItemsCount in PatronInformationResponose
Bugfix: Incorrect positionedfield definition for nbDueDate in Renew
Requires Ceridwen Utility Library 1.20

**Version 2.20:31/10/2010 (209**)
Added enumerated fields
Added flag fields
Fixed default values for ok property if not explicitly set
Bugfix: Change boolean to Boolean in Renew properties
Bugfix: Fixed ItemInformationBeanInfo incorrect start/end for transaction date
Bugfix: Corrected incorrect getter/setter in EndSessionResponseBeanInfo
Bugfix: Fixed error in CurrencyType.getCode
Bugfix: Tightened Message.setProp code

**Version 2.10: 30/10/2010 (170)**
Added basic socket server implementation
Refactored SCResend and ACSResend as Message subclasses
Added options to connection for checksum checking and checksum generation
Added strictSequenceChecking option
Connect now throws exceptions rather than true/false status
Added repeated field support
Updated commons logging from 1.1 to 1.1.1
Updated commons net from 1.4.1 to 2.0
Updated commons beanutils from 1.7.0 to 1.8.3
Templated classes based on JDK 1.6 warnings

**Version 2.03: 12/1/2007 (82)**
Added MessageNotUnderstood exception

**Version 2.02: 11/5/2005 (42)**
Modified so that required variable fields are always present even if blank, optional variable fields are omitted if blank.

**Version 2.01 9/3/2005 (38) - Public Release**
Minor logging revisions

**Version 2.00: 25/10/2004 (36)**
Complete rewrite of initial library to use javabean and introspection