# SNSMessageSender
Sends a message to an `SNS` topic so that the subscribers will receive it.

## Design
* `SNSMessengerServiceImpl` has the method that is capable of sending a message to `SNS`.

* `ClientBuilderManager` utility class build an `SNS` client to access `SNS` service APIs.

* `PropertyManager` reads required properties from the configuration file makes them available across the application.

## Configuring AWS Infrastructure
* Create an `IAM Group`.

* Create an `IAM User`.

* Add created `IAM User` to `IAM Group`'s `Amazon SNS` service.

* Go to `IAM Users`, select the created user and generate `key`/`value` pair in `Security credentials` tab.

* Create an `SNS` topic.

* In the `SNS` topic, create a subscription with your email id.

## How to test
This is a simple `Java` `Maven` project.

Fill in the values in the `properties` file.

Run `App` class.
