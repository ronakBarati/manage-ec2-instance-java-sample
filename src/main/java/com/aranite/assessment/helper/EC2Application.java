package com.aranite.assessment.helper;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import org.apache.log4j.Logger;


public class EC2Application {

    static final Logger logger = Logger.getLogger(Configuration.class);

    private static final AWSCredentials credentials;
    private static final Configuration ec2Configuration;

    static {
        ec2Configuration = new Configuration();
        // read access key and secret key from config properties
        credentials = new BasicAWSCredentials(
                ec2Configuration.getProperty("amazon.aws.access.key", ""),
                ec2Configuration.getProperty("amazon.aws.secret.key", "")
        );
    }

    // Set up the client
    public AmazonEC2 setupClient() {
        return AmazonEC2ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.fromName(ec2Configuration.getProperty("region", "")))
                .build();
    }

    //start ec2 instance
    public void startInstance(AmazonEC2 ec2Client, String instanceId) {
        StartInstancesRequest startInstancesRequest = new StartInstancesRequest()
                .withInstanceIds(instanceId);

        ec2Client.startInstances(startInstancesRequest);
    }

    //stop ec2 instance
    public void stopInstance(AmazonEC2 ec2Client, String instanceId) {
        StopInstancesRequest stopInstancesRequest = new StopInstancesRequest()
                .withInstanceIds(instanceId);

        ec2Client.stopInstances(stopInstancesRequest)
                .getStoppingInstances()
                .get(0)
                .getPreviousState()
                .getName();
    }

    public void getInstanceDescription(AmazonEC2 ec2Client) {
        DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest();
        DescribeInstancesResult response = ec2Client.describeInstances(describeInstancesRequest);
        logger.info(response.getReservations()
                .get(0)
                .getInstances()
                .get(0)
                .getKernelId());
    }
}
