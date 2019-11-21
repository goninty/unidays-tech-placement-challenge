# UNiDAYS Discounts Coding Challenge

## How to Build and Run

My implementation uses the Java JDK Version 13, so please make sure you have this version installed.

Since I've used JUnit5 for testing, the easiest way to run these tests is to simply clone my repo and open it in your preferred Java IDE (hopefully IntelliJ or Eclipse). Then, **run the class named `UnidaysDiscountChallengeTest` that can be found in the /src directory**. This should run the test suite and output the result of each test.

The library dependency for JUnit5 is specified in the `unidays-tech-placement-challenge.iml` file in the root of this project, so it should be picked up by the IDE. If not, please use [this](https://www.jetbrains.com/help/idea/configuring-testing-libraries.html) guide to configure JUnit in IntelliJ and [this](https://www.eclipse.org/community/eclipse_newsletter/2017/october/article5.php) one for Eclipse.

If all fails and you aren't able to compile or run my code as specified above, please don't hesitate to contact me so I can try and sort it out.

## My approach

I ended up settling on using Java as not only am I pretty experienced with the language but the challenge itself seemed - at least to me - to lend itself well to a purely OOP approach. It felt like a lot of things could be nicely represented as classes/objects.

So, I created a few classes:
>`UnidaysDiscountChallenge`: The "main" class which is used to add items to a basket, calculate the total price and apply any eligible discounts.

>`Item`: Represents an item that can be added to a basket. This class stores an item's name and it's price.

>`Price`: Will be returned once a basket's total price has been calculated. This object's fields can then be accessed via getters in order to get the price of the items (with discount) and the delivery charge separately.

>`Discount`: Discount objects can be created and linked to items (such as via a HashMap, as seen in my test class) in order to specify any discounts that are applicable to an item. This discount class stores the quantity of an item required to meet the discount and the new price of these items under the discount. For example, a *"2 for £20"* discount would set the `numberForDiscount` field to `2` and the `discountPrice` to `20.00`. An `amountToDeduct` is then calculated, which is the amount to deduct from the current basket's total price in order to apply the discount. This is then accessed via a getter in order to apply any discounts in the `UnidaysDiscountChallenge` class.

I also then created a test class - utilising JUnit - named `UnidaysDiscountChallengeTest`. This class  does the following:
>Several items are instantiated as per the `pricingRules`.

>The `pricingRules` are then established as a HashMap, in which these `Item` objects are mapped to `Discount` objects.

>Before each test, an instance of the `UnidaysDiscountChallenge` class is then created and the `pricingRules` are passed to it. This is done before each test in order to prevent the state from any previous tests persisting.

>Each test then calls the `.AddToBasket()` method of the `UnidaysDiscountChallenge` class to add item(s) to the basket.

>After each test, the returned `Price` object is compared to the expected amounts for the items and the delivery.

All of the example tests have been implemented.

Thanks for reading! The original brief can be found below for reference.

# UNiDAYS Discounts Coding Challenge (Original brief)

## Introduction

This challenge is for you to make use of your problem solving skills as well as demonstrate your understanding of good object-oriented programming and SOLID design principles.

At UNiDAYS our business is built on providing discounts to students. Your challenge is to build a basic discount system that applies discounts to an online shopping order and calculates the total price based on a set of pricing rules.

You may complete the challenge in any programming language you wish.

## Pricing Rules

| Item | Price  | Discount |
| ---- | ------ | -------- |
| A    | £8.00  | None |
| B    | £12.00 | 2 for £20.00 |
| C    | £4.00  | 3 for £10.00 |
| D    | £7.00  | Buy 1 get 1 free |
| E    | £5.00  | 3 for the price of 2 |

## Delivery Charges

Delivery charge £7.00

Free delivery on orders over £50.00 (inclusive)

## Interface

Implement a `UnidaysDiscountChallenge` class with two public methods.

1. `AddToBasket` - Pass in an item
2. `CalculateTotalPrice` - Calculate and return the total price, result should include the following
    - `Total` - Total price of all items after applying any discounts
    - `DeliveryCharge` - The delivery charge for the order

It should be possible to initialise your `UnidaysDiscountChallenge` class with the pricing rules. The example below shows how the interface might be used.

```
example = new UnidaysDiscountChallenge(pricingRules);

example.AddToBasket(itemOne);
example.AddToBasket(itemTwo);

result = example.CalculateTotalPrice();

totalPrice = result.Total;
deliveryCharge = result.DeliveryCharge;
overallTotal = totalPrice + deliveryCharge;
```

## Example Test Cases

| Items          | Total  | Delivery Charge |
| -------------- | ------ | --------------- |
| _None_         | £0.00  | £0.00 |
| A              | £8.00  | £7.00 |
| B              | £12.00 | £7.00 |
| C              | £4.00  | £7.00 |
| D              | £7.00  | £7.00 |
| E              | £5.00  | £7.00 |
| BB             | £20.00 | £7.00 |
| BBB            | £32.00 | £7.00 |
| BBBB           | £40.00 | £7.00 |
| CCC            | £10.00 | £7.00 |
| CCCC           | £14.00 | £7.00 |
| DD             | £7.00  | £7.00 |
| DDD            | £14.00 | £7.00 |
| EE             | £10.00 | £7.00 |
| EEE            | £10.00 | £7.00 |
| EEEE           | £15.00 | £7.00 |
| DDDDDDDDDDDDDD | £49.00 | £7.00 |
| BBBBCCC        | £50.00 | £0.00 |
| ABBCCCDDEE     | £55.00 | £0.00 |
| EDCBAEDCBC     | £55.00 | £0.00 |

## Deliverables

You should provide a copy of your code in a publicly accessible location (e.g. Github, Bitbucket etc).

Your solution should include documentation describing how to build and run your code as well your approach to the problem. 

We're not too fussy about what platform your program runs on, but we do require that we're able to build and run your code ourselves.