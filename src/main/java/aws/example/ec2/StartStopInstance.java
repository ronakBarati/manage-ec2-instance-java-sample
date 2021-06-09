package aws.example.ec2;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;
import software.amazon.awssdk.services.ec2.model.StopInstancesRequest;


public class StartStopInstance {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("incorrect input length...");
            System.exit(1);
        }

        String instanceId = args[0];

        Region region = Region.US_EAST_1;
        Ec2Client ec2 = Ec2Client.builder()
                .region(region)
                .build();

        if(args[1].equals("start")) {
            startInstance(ec2, instanceId);
        } else {
            stopInstance(ec2, instanceId);
        }
        ec2.close();
    }

    // snippet-start:[ec2.java2.start_stop_instance.start]
    public static void startInstance(Ec2Client ec2, String instanceId) {

        StartInstancesRequest request = StartInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.startInstances(request);

        // snippet-end:[ec2.java2.start_stop_instance.start]
        System.out.printf("Successfully started instance %s", instanceId);
    }

    // snippet-start:[ec2.java2.start_stop_instance.stop]
    public static void stopInstance(Ec2Client ec2, String instanceId) {

        StopInstancesRequest request = StopInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.stopInstances(request);

        // snippet-end:[ec2.java2.start_stop_instance.stop]
        System.out.printf("Successfully stop instance %s", instanceId);
    }
}