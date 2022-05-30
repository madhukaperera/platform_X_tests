Feature: Submit New Orders & Receiving Respective OrderIDs
 @Test_SubmitOrderSingle
  Scenario: Submit Single BUY & a SELL order
  Given orderbook contains below orders
      |price|quantity|side|symbol|type|owner|
      |0.6571|10000.00|BUY|SUGAR-WHT-G2|NEW|ownerOne|
      |0.6572|10000.00|SELL|SUGAR-WHT-G2|NEW|ownerOne|
      |0.6573|10000.00|SELL|SUGAR-WHT-G2|NEW|ownerOne|
      |0.6574|10000.00|SELL|SUGAR-WHT-G2|NEW|ownerOne|
      |0.6575|10000.00|SELL|SUGAR-WHT-G2|NEW|ownerOne|
      |0.6576|10000.00|SELL|SUGAR-WHT-G2|NEW|ownerOne|
      |0.6576|60000.00|BUY|SUGAR-WHT-G2|NEW|ownerOne|

   When user submits contra orders
     |price|quantity|side|symbol|type|owner|
     |12.32|100.00|SELL|SUGAR-WHT-G2|NEW|ownerOne|
   Then receives execution reports
     |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
     |SUGAR-WHT-G2|null|1|12.32|2000|SELL|0|NEW|Order Accepted|ownerOne|
     |SUGAR-WHT-G2|null|1|12.32|1000|SELL|0|NEW|Order Accepted|ownerOne|
     |SUGAR-WHT-G2|null|1|12.32|1000|BUY|0|NEW|Order Accepted|ownerOne|
     |SUGAR-WHT-G2|null|1|12.32|500|SELL|0|NEW|Order Accepted|ownerOne|
     |SUGAR-WHT-G2|null|1|12.32|1000|SELL|0|NEW|Order Accepted|ownerOne|


  @Test_SubmitOrderPartiallyFilled
  Scenario: Submit BUY & a SELL order for a partial fill
    Given orderbook contains below orders
      |price|quantity|side|symbol|type|owner|
      |12.12|10000.00|BUY|SUGAR|NEW|ownerOne|
      |3.5|1000.00|SELL|SUGAR|NEW|ownerOne|
      |3.5|2000.00|BUY|WHITESUGARG131JULY|NEW|ownerOne|

    When user submits contra orders
      |price|quantity|side|symbol|type|owner|
      |121.00|1000.00|BUY|SUGAR|NEW|ownerOne|
    Then receives execution reports
      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
      |SUGAR|null|1|121.25|1000|BUY|0|NEW|Order Accepted|ownerTwo|
      |SUGAR|null|1|121.25|1000|SELL|0|FILL|Order Executed|ownerOne|
      |SUGAR|null|1|122.68|1000|SELL|0|NEW|Order Accepted|ownerTwo|
      |SUGAR|null|1|123.75|1000|SELL|0|NEW|Order Accepted|ownerOne|
      |SUGAR|null|1|122.35|1000|SELL|0|NEW|Order Accepted|ownerTwo|
      |SUGAR|null|1|121.00|4000|BUY|0|FILL|Order Executed|ownerOne|
      |SUGAR|null|1|121.00|1000|BUY|0|FILL|Order Executed|ownerOne|

  @Test_SubmitOrderFullyFilled
  Scenario: Submit BUY & a SELL order for a full fill
    Given orderbook contains below orders
      |price|quantity|side|symbol|type|owner|
      |121.00|1000.00|SELL|SUGAR|NEW|ownerTwo|
    When user submits contra orders
      |price|quantity|side|symbol|type|owner|
      |121.00|1000.00|BUY|SUGAR|NEW|ownerOne|
    Then receives execution reports
      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
      |SUGAR|null|1|121.00|1000|SELL|0|Fill|Fully Executed|ownerOne|
      |SUGAR|null|1|121.00|1000|BUY|0|FILL|Fully Executed|ownerOne|

  @Test_SubmitOrderToContraOrderSweepingBook
  Scenario: Submit BUY & SELL orders to sweep the book
    Given orderbook contains below orders
      |price|quantity|side|symbol|type|owner|
      |121.00|1000.00|SELL|SUGAR|NEW|ownerTwo|
      |121.00|500.00|SELL|SUGAR|NEW|ownerTwo|
      |121.00|250.00|SELL|SUGAR|NEW|ownerTwo|
    When user submits contra orders
      |price|quantity|side|symbol|type|owner|
      |121.00|1750.00|BUY|SUGAR|NEW|ownerOne|
    Then receives execution reports
      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
      |SUGAR|null|1|121.00|1000|SELL|0|Fill|Fully Executed|ownerOne|
      |SUGAR|null|1|121.00|500|SELL|0|Fill|Fully Executed|ownerOne|
      |SUGAR|null|1|121.00|250|SELL|0|Fill|Fully Executed|ownerOne|
      |SUGAR|null|1|121.00|1750|BUY|0|FILL|Fully Executed|ownerOne|

