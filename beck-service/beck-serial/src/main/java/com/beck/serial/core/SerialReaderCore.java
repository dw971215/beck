package com.beck.serial.core;

import com.beck.common.utils.sign.Encodes;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * 串口监听返回信息监听类实现
 * @Author dawei
 * @Date 2021/1/27 21:15
 */
public class SerialReaderCore implements SerialPortEventListener {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private InputStream in;
    private byte[] buffer = new byte[1024];

    public  void valueInput(InputStream in){
        this.in = in;
    }
    public void serialEvent(SerialPortEvent arg0) {
        int data;
        try {
            int len = 0;
            while ( ( data = in.read()) > -1 ) {
                if ( data == '\n' ) {
                    break;
                }
                buffer[len++] = (byte) data;
            }
//                System.out.println("来自串口的消息：-->"+new String(buffer,0,len));
            logger.info("来自串口的消息：-->"+ Encodes.bytesToHexString(buffer,len));
        } catch ( IOException e ) {
            logger.info("获取串口信息失败-->");
//                System.exit(-1);
        }
    }
}
