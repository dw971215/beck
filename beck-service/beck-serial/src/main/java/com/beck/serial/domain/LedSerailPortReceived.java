package com.beck.serial.domain;

import com.beck.common.utils.sign.Encodes;
import com.beck.serial.core.SerialReaderReceived;
import gnu.io.SerialPortEvent;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author dawei
 * @Date 2021/1/27 21:47
 */
public class LedSerailPortReceived extends SerialReaderReceived {

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
           String receivedStr = Encodes.bytesToHexString(buffer,len);
//                System.out.println("来自串口的消息：-->"+new String(buffer,0,len));
            System.out.println("串口用16进制返回的消息：-->"+ receivedStr);
        } catch ( IOException e ) {
            System.out.println("获取串口信息失败-->");
//                System.exit(-1);
        }
    }
}
