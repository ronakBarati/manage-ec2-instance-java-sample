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



|Tools| Atlassian Clover | Cobertura | JaCoCo  | jlk | JCov |  Code Cover |
|---| --- | --- | ---| --- | --- |  --- |
|Report types CSV| &cross; | &cross;|&check;| &cross; |&cross;|&check;|
|Coverage Method |&check;|&cross;|&check;|&check;|&check;|&cross;|
|Coverage Statement|&check;|&cross;|&cross;|&check;|&check;|&cross;|
|Coverage Line|&cross;|&check;|&check;|&check;|&cross;|&check;|
|Global coverage|&check;|&check;|&check;|&check;|&check;|&check;|
|Sonar Integration |&check;|&check;|&check;|&check;|&cross;|&cross;|
|Advantages|Clover has great and highly configurable HTML reports (showing not only code coverage but also top risks etc), per-test code coverage and test optimization, distributed per-test coverage and many tool integrations; it is being actively developed and supported.|compliant to use thanks to off-line byte code instrumentation. You can measure coverage without having the source code. It has very nice and to navigate HTML report.|Very compliant to integrate thanks to the on-the-fly byte code instrumentation. You can measure coverage without having the source code. It has nice HTML report| - |It has the most detailed code coverage metric (MC/DC), which may be useful for critical systems (medical, aeronautical etc). The Eclipse plug-in comes also with a cool Boolean Expression Analyzer view and a Test Correlation matrix. It has also an interesting feature to start/stop test case via JMX, which can be useful for manual testing.|tool for mutation coverage, which means it will not only measure line coverage of your code but will also perform mutations in application logic in order to check how well written your tests are.|
|Disadvantages|Due to a fact that Clover is based on source code instrumentation, integration requires a build - it's necessary to recompile code with Clover. Most Clover's integrations have an automatic integration feature, but in some cases you may need to add Clover JAR to a class path or set some Clover options.|Classes must be compiled with debug option.|Classes must be compiled with debug option.| - |Last release has been performed 3 years ago. The HTML report generated is quite fragmented - source code is shown separately for every method.| |

        mvn install

        mvn exec:java -Dexec.args="-command start -instanceId instance-id"

command line arguments :
        -command         start or stop
        -instanceId         our ec2 instance id
