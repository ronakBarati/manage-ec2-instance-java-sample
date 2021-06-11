# Manage Ec2 Instance

# Overview
The following repo contains examples to control EC2 resources using the Java SDK.

# Maven Dependencies
Before we get started, we need to declare AWS SDK dependency in our project :

<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-java-sdk</artifactId>
    <version>${aws-java-sdk.version}</version>
</dependency>

# Prerequisites
The Maven dependencies, AWS account settings and client connection needed to use the Amazon AWS SDK for EC2 .

To use AWS SDK, we'll need a few things:
1.	AWS Account: we need an Amazon Web Services account. 
2.	AWS Security Credentials: These are our access keys that allow us to make programmatic calls to AWS API actions. 
3.	Choosing AWS Region: We have to select an AWS region(s) where we want to store our Amazon S3 data. Keep in mind that S3 storage prices vary by region. 

# How to run
We should change the parameters of our aws account in the config.properties for use in our project.
config.properties :
amazon.aws.access.key=key
amazon.aws.secret.key=key1
region=ca-central-1


After that run following command to start and stop our instance : 

< mvn exec:java -Dexec.args="-command start -instanceId instance-id">

command line arguments :
-command         start or stop
-instanceId         our ec2 instance id
