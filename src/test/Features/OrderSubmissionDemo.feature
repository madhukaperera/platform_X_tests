Feature: Submit Orders and Executions

  @Test_SubmitSingleOrder
  Scenario: Submit new orders demo
    Given orderbook contains below orders
      |price|quantity|side|symbol|type|owner|
      |150.00|2000.00|BUY|WHITESUGAR131JULY|NEW|ownerOne|
    When commodity instrument is in regular trading session
    Then receives execution reports
      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
      |SUGAR|null|1|12.00|1000|BUY|0|NEW|Order Accepted|ownerOne|

#  @Test_SubmitOrderPartialFill
#    Scenario: Submit Orders for partial fill
#    Given orderbook contains below orders
#      |price|quantity|side|symbol|type|owner|
#      |120.00|200.00|BUY|SUGAR|NEW|ownerOne|
#    When commodity instrument is in regular trading session
#    Then user submits contra orders
#      |price|quantity|side|symbol|type|owner|
#      |120.00|2000.00|SELL|SUGAR|NEW|ownerOne|
#    And receives execution reports
#      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
#      |SUGAR|null|1|12.00|1000|BUY|0|NEW|Order Accepted|ownerOne|
#
#  @Test_SubmitOrderFilled
#    Scenario: Submit orders for a full fill
#    Given orderbook contains below orders
#      |price|quantity|side|symbol|type|owner|
#      |121.00|200.00|BUY|SUGAR|NEW|ownerOne|
#    When commodity instrument is in regular trading session
#    Then user submits contra orders
#      |price|quantity|side|symbol|type|owner|
#      |121.00|200.00|SELL|SUGAR|NEW|ownerOne|
#    And receives execution reports
#      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
#      |SUGAR|null|1|121.00|200|BUY|0|NEW|Order Accepted|ownerOne|

#  @Test_CancelOrder
#  Scenario: Cancelling a submitted order
#    Given orderbook contains below orders
#      |price|quantity|side|symbol|type|owner|
#      |118.00|200.00|BUY|SUGAR|NEW|ownerOne|
#
#    When user cancels order
#
#    Then receives execution reports
#      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
#      |SUGAR|null|1|12.00|1000|BUY|0|NEW|Order Accepted|ownerOne|

#    @Test_SubmitOrder
#    Scenario: Submit a new order
#      Given orderbook contains below orders
#        |price|quantity|side|symbol|type|owner|
#        |118.00|200.00|BUY|SUGAR|NEW|ownerOne|
