package com.beck.serial.utils;

import com.beck.common.utils.spring.SpringUtils;
import com.beck.serial.core.SerialPortCore;
import com.beck.serial.core.SerialReaderReceived;
import org.springframework.stereotype.Component;

/**
 * @Author dawei
 * @Date 2021/1/25 10:02
 */
@Component
public class SerialPortUtils {

    private static SerialPortCore serialPortCore = null;

    static {
        serialPortCore = (SerialPortCore) SpringUtils.getBean("serialPortCore");
    }

    /**
     * 向串口发送消息
     * success 发送成功
     * fail 发送失败
     * @param msg 发送的指令信息
     * @param serialReader 接收消息的处理类
     * @throws Exception
     */
    public static String sendMsg(String msg, SerialReaderReceived serialReader) throws Exception {
        // 创建连接
        serialPortCore.connect(SerialPortCore.serialPortName,serialReader);
        // 线程休眠
        Thread.sleep(2000);
        // 发送消息
        String status = serialPortCore.sendMsg(msg);
        return  status;
    }

    /**
     * 连接串口
     * @param serialReader 接收消息的处理类
     * @throws Exception
     */
    public static void connect(SerialReaderReceived serialReader) throws Exception {
        // 创建连接
        serialPortCore.connect(SerialPortCore.serialPortName,serialReader);
        // 线程休眠
        Thread.sleep(2000);
    }

}
