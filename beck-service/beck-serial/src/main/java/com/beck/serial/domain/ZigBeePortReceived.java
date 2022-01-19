package com.beck.serial.domain;

import com.beck.serial.core.SerialReaderCore;
import gnu.io.SerialPortEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * ZigBee串口接收类
 * @Author dawei
 * @Date 2021/2/25 8:54
 */
public class ZigBeePortReceived extends SerialReaderCore {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
            //单片机接收的数据
            String receivedStr ="";
            receivedStr = new String(buffer,0,len);
//            receivedStr  = Encodes.bytesToHexString(buffer,len);
            logger.info("串口用16进制返回的消息：-->"+ receivedStr+"字节类型传入的字符串:+"+receivedStr);
            receivedStr = receivedStr.replace("Coord Card ID:","");

        } catch ( IOException e ) {
            System.out.println("获取串口信息失败-->");
//                System.exit(-1);
        }
    }

}
