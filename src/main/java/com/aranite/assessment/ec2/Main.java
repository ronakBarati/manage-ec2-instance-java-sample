package com.aranite.assessment.ec2;

import com.aranite.assessment.helper.EC2Application;
import com.amazonaws.services.ec2.AmazonEC2;
import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {

        Options options = new Options();

        Option command = new Option("command", "command", true, "start or stop");
        command .setRequired(true);
        options.addOption(command);

        Option instanceId = new Option("instanceId", "instanceId", true, "our ec2 instance id");
        instanceId .setRequired(true);
        options.addOption(instanceId);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("my-program", options);
            System.exit(1);
            return;
        }

        EC2Application ec2Application = new EC2Application();
        AmazonEC2 ec2Client= ec2Application.setupClient();
        if(cmd.getOptionValue("command").equalsIgnoreCase("start")) {
            ec2Application.startInstance(ec2Client,cmd.getOptionValue("instanceId"));
        } else {
            ec2Application.stopInstance(ec2Client,cmd.getOptionValue("instanceId"));
        }
    }

}
