# manage-ec2-instance-java-sample
Manage Amazon EC2 instances

Prerequisites :

To build and run these examples, you need the following:

Apache Maven (>3.0)

AWS SDK for Java (downloaded and extracted somewhere on your machine)


How to Run :

mvn exec:java  -Dexec.args="c2_instance_id start"
mvn exec:java  -Dexec.args="c2_instance_id stop"
