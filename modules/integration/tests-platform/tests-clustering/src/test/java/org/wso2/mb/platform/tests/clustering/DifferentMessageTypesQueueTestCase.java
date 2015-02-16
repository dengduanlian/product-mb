/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.mb.platform.tests.clustering;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.automation.engine.context.TestUserMode;
import org.wso2.mb.integration.common.clients.AndesClient;
import org.wso2.mb.integration.common.clients.configurations.AndesJMSConsumerClientConfiguration;
import org.wso2.mb.integration.common.clients.configurations.AndesJMSPublisherClientConfiguration;
import org.wso2.mb.integration.common.clients.operations.queue.AndesAdminClient;
import org.wso2.mb.integration.common.clients.operations.utils.AndesClientConstants;
import org.wso2.mb.integration.common.clients.operations.utils.AndesClientException;
import org.wso2.mb.integration.common.clients.operations.utils.AndesClientUtils;
import org.wso2.mb.integration.common.clients.operations.utils.ExchangeType;
import org.wso2.mb.integration.common.clients.operations.utils.JMSMessageType;
import org.wso2.mb.platform.common.utils.MBPlatformBaseTest;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


/**
 * This class includes test cases to test different types of messages (e.g. byte, map, object,
 * stream) which can be sent to a topic.
 */
public class DifferentMessageTypesQueueTestCase extends MBPlatformBaseTest {

    /**
     * Prepare environment for tests.
     *
     * @throws Exception
     */
    @BeforeClass(alwaysRun = true)
    public void init() throws Exception {
        super.initCluster(TestUserMode.SUPER_TENANT_ADMIN);
        super.initAndesAdminClients();
    }

    /**
     * Publish byte messages to a queue in a single node and receive from the same node with one
     * subscriber
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "single publisher single subscriber byte messages",
            enabled = true)
    public void testByteMessageSingleSubSinglePub()
            throws XPathExpressionException, AndesClientException, NamingException, JMSException,
                   IOException {

        this.runMessageTypeTestCase(JMSMessageType.BYTE, 1, "byteMessageQueue1");

//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:byteMessageQueue1",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "1",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:byteMessageQueue1",
//                "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "1",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("byte");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Publish byte messages to a queue in a single node and receive from the same node with
     * multiple publishers and subscribe to that queue using multiple subscribers
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "multiple publisher multiple subscriber byte " +
            "messages", enabled = true)
    public void testByteMessageMultipleSubMultiplePub() throws Exception {

        this.runMessageTypeTestCase(JMSMessageType.BYTE, 10, "byteMessageQueue2");


//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:byteMessageQueue2",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "10",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:byteMessageQueue2",
//                "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "10",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("byte");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Publish map messages to a queue in a single node and receive from the same node with one
     * subscriber
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "single publisher single subscriber map messages",
            enabled = true)
    public void testMapMessageSingleSubSinglePub() throws Exception {
        this.runMessageTypeTestCase(JMSMessageType.MAP, 1, "mapMessageQueue1");

//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:mapMessageQueue1",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "1",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:mapMessageQueue1", "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "1",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("map");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Publish map messages to a queue in a single node and receive from the same node with
     * multiple publishers and subscribe to that queue using multiple subscribers
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "multiple publisher multiple subscriber map " +
            "messages", enabled = true)
    public void testMapMessageMultiplePubMultipleSub() throws Exception {
        this.runMessageTypeTestCase(JMSMessageType.MAP, 10, "mapMessageQueue2");
//
//
//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:mapMessageQueue2",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "10",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:mapMessageQueue2",
//                "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "10",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("map");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Publish Object messages to a queue in a single node and receive from the same node with one
     * subscriber
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "single publisher single subscriber object messages",
            enabled = true)
    public void testObjectMessageSingleSubSinglePub() throws Exception {
        this.runMessageTypeTestCase(JMSMessageType.OBJECT, 1, "objectMessageQueue1");


//
//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:objectMessageQueue1",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "1",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:objectMessageQueue1", "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "1",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("object");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Publish object messages to a queue in a single node and receive from the same node with
     * multiple publishers and subscribe to that queue using multiple subscribers
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "multiple publisher multiple subscriber object " +
            "messages", enabled = true)
    public void testObjectMessageMultiplePubMultipleSub() throws Exception {
        this.runMessageTypeTestCase(JMSMessageType.OBJECT, 10, "objectMessageQueue2");

//
//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:objectMessageQueue2",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "10",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:objectMessageQueue2",
//                "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "10",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("object");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Publish stream messages to a queue in a single node and receive from the same node with one
     * subscriber
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "single publisher single subscriber stream messages",
            enabled = true)
    public void testStreamMessageSingleSubSinglePub() throws Exception {
        this.runMessageTypeTestCase(JMSMessageType.STREAM, 1, "streamMessageQueue1");
//
//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:streamMessageQueue1",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "1",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:streamMessageQueue1", "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "1",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("stream");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Publish stream messages to a queue in a single node and receive from the same node with
     * multiple publishers and subscribe to that queue using multiple subscribers
     *
     * @throws Exception
     */
    @Test(groups = "wso2.mb", description = "multiple publisher multiple subscriber stream " +
            "messages", enabled = true)
    public void testStreamMessageMultiplePubMultipleSub() throws Exception {
        this.runMessageTypeTestCase(JMSMessageType.STREAM, 10, "streamMessageQueue2");
//
//        // Max number of seconds to run the client
//        int maxRunningTime = 80;
//        // Expected message count
//        int expectedCount = 2000;
//        // Number of messages send
//        int sendCount = 2000;
//
//        String brokerUrl = getRandomAMQPBrokerUrl();
//
//        AndesClient receivingClient = new AndesClient("receive", brokerUrl,
//                "queue:streamMessageQueue2",
//                "100", "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(expectedCount),
//                "10",
//                "listener=true,ackMode=0," +
//                        "delayBetweenMsg=0," +
//                        "stopAfter=" + expectedCount,
//                "");
//        receivingClient.startWorking();
//
//        AndesClient sendingClient = new AndesClient("send", brokerUrl, "queue:streamMessageQueue2",
//                "100",
//                "false",
//                String.valueOf(maxRunningTime),
//                String.valueOf(sendCount), "10",
//                "ackMode=0,delayBetweenMsg=0," +
//                        "stopAfter=" + sendCount,
//                "");
//        sendingClient.setMessageType("stream");
//        sendingClient.startWorking();
//
//        Assert.assertTrue(AndesClientUtils.waitUntilMessagesAreReceived(receivingClient,
//                expectedCount,
//                maxRunningTime),
//                "Message receiving failed.");
//
//        Assert.assertTrue(AndesClientUtils.getIfPublisherIsSuccess(sendingClient, sendCount),
//                "Message sending failed.");
//
//        Assert.assertEquals(receivingClient.getReceivedqueueMessagecount(), sendCount,
//                "All messages are not received.");

    }

    /**
     * Cleanup after running tests.
     *
     * @throws Exception
     */
    @AfterClass(alwaysRun = true)
    public void destroy() throws Exception {

        String randomInstanceKey = getRandomMBInstance();

        AndesAdminClient tempAndesAdminClient = getAndesAdminClientWithKey(randomInstanceKey);

        if (tempAndesAdminClient.getQueueByName("byteMessageQueue1") != null) {
            tempAndesAdminClient.deleteQueue("byteMessageQueue1");
        }
        if (tempAndesAdminClient.getQueueByName("byteMessageQueue2") != null) {
            tempAndesAdminClient.deleteQueue("byteMessageQueue2");
        }
        if (tempAndesAdminClient.getQueueByName("mapMessageQueue1") != null) {
            tempAndesAdminClient.deleteQueue("mapMessageQueue1");
        }
        if (tempAndesAdminClient.getQueueByName("mapMessageQueue2") != null) {
            tempAndesAdminClient.deleteQueue("mapMessageQueue2");
        }
        if (tempAndesAdminClient.getQueueByName("objectMessageQueue1") != null) {
            tempAndesAdminClient.deleteQueue("objectMessageQueue1");
        }
        if (tempAndesAdminClient.getQueueByName("objectMessageQueue2") != null) {
            tempAndesAdminClient.deleteQueue("objectMessageQueue2");
        }
        if (tempAndesAdminClient.getQueueByName("streamMessageQueue1") != null) {
            tempAndesAdminClient.deleteQueue("streamMessageQueue1");
        }
        if (tempAndesAdminClient.getQueueByName("streamMessageQueue2") != null) {
            tempAndesAdminClient.deleteQueue("streamMessageQueue2");
        }
    }



    private void runMessageTypeTestCase(JMSMessageType messageType, int numberOfPublishers,
                                        String destinationName)
            throws XPathExpressionException, AndesClientException, NamingException, JMSException,
                   IOException {

        long expectedCount = 2000L;
        // Number of messages send
        long sendCount = 2000L;

        String brokerUrl = getRandomAMQPBrokerUrl();


        // Creating a initial JMS consumer client configuration
        AndesJMSConsumerClientConfiguration consumerConfig = new AndesJMSConsumerClientConfiguration(brokerUrl, ExchangeType.QUEUE, destinationName);
        // Amount of message to receive
        consumerConfig.setMaximumMessagesToReceived(expectedCount);
        consumerConfig.setPrintsPerMessageCount(expectedCount / 10L);

        AndesJMSPublisherClientConfiguration publisherConfig = new AndesJMSPublisherClientConfiguration(brokerUrl, ExchangeType.QUEUE, destinationName);
        publisherConfig.setNumberOfMessagesToSend(sendCount);
        publisherConfig.setPrintsPerMessageCount(sendCount/10L);
        publisherConfig.setJMSMessageType(messageType);

        AndesClient consumerClient = new AndesClient(consumerConfig);
        consumerClient.startClient();

        AndesClient publisherClient = new AndesClient(publisherConfig, numberOfPublishers);
        publisherClient.startClient();

        AndesClientUtils.waitUntilNoMessagesAreReceivedAndShutdownClients(consumerClient, AndesClientConstants.DEFAULT_RUN_TIME);

        Assert.assertEquals(publisherClient.getSentMessageCount(), sendCount, "Message sending failed.");
        Assert.assertEquals(consumerClient.getReceivedMessageCount(), expectedCount, "Message receiving failed.");
    }

}
