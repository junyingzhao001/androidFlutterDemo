package com.example.flutterdemo.comm;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

/**
 *
 */
public class EventChannelPlugin implements EventChannel.StreamHandler {
    private final String ElectricityQuantity;

    /**
     *
     * @param messenger 发送消息工具
     * @param ElectricityQuantity   当前电量
     */
    public static void registerWith(BinaryMessenger messenger, String ElectricityQuantity) {
        new EventChannelPlugin(messenger, ElectricityQuantity);
    }

    private EventChannelPlugin(BinaryMessenger messenger,String ElectricityQuantity) {
        this.ElectricityQuantity = ElectricityQuantity;

        EventChannel eventChannelPlugin = new EventChannel(messenger, "demo.ht.com.androidproject/EventChannelPlugin");
        eventChannelPlugin.setStreamHandler(this);
    }
    @Override
    public void onListen(Object args, EventChannel.EventSink eventSink) {
        //要发送消息
        eventSink.success(ElectricityQuantity);
    }

    @Override
    public void onCancel(Object o) {
    }

}