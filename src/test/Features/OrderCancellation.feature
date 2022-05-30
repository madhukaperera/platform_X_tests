Feature: Order Cancellation

  @Test_CancelOrder
  Scenario: Cancelling a submitted order
#    Given orderbook contains below orders
#      |price|quantity|side|symbol|type|owner|
#      |118.00|200.00|BUY|SUGAR|NEW|ownerOne|

    When user cancels order
      |symbol|orderID|
      |SUGAR |MC     |

#    Then receives execution reports
#      |symbol|orderId|version|price|quantity|side|type|status|reason|owner|
#      |SUGAR|null|1|12.00|1000|BUY|0|NEW|Order Accepted|ownerOne|