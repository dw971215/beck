package com.beck.serial.core;

import com.beck.common.utils.sign.Encodes;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/*
 *  串口通信核心类
 * @author  dawei
 * @date  2021/1/25 11:25
 *
 */
@Component
@ConfigurationProperties(prefix = "serial")
@PropertySource(value = { "classpath:serial-port.yml" })
public class SerialPortCore {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 波特率
     */
    @Value("${baudRate}")
    private  int baudRate;

    /**
     * 数据位
     */
    @Value("${dataBits}")
    private  int dataBits;

    /**
     * 停止位
     */
    @Value("${stopBits}")
    private  int stopBits;

    /**
     * 校验位
     */
    @Value("${parity}")
    private  int parity; // 0 表示none

    /**
     * 串口名称
     */
    @Value("${portName}")
    private  String portName;

    /**
     *端口等待时间
     */
    @Value("${timeout}")
    private  int timeout ;
    /**
     * 已经建立连接的串口信息
     */
    private  SerialPort serialPort ;

    public static String serialPortName;

    /**
     * 本方法给静态代码赋值
     */
    @PostConstruct
    public void init(){
        serialPortName = this.portName;
    }


    /**
     * @方法名称 :listPort
     * @功能描述 :列出所有可用的串口
     * @返回值类型 :void
     */
    @SuppressWarnings("rawtypes")
    public List<CommPortIdentifier> listPort(){
        List<CommPortIdentifier> cpidList = new ArrayList<>();
        Enumeration en = CommPortIdentifier.getPortIdentifiers();
        logger.info("now to list all Port of this PC：" +en);
        while(en.hasMoreElements()){
            CommPortIdentifier cpid = (CommPortIdentifier)en.nextElement();
            if(cpid.getPortType() == CommPortIdentifier.PORT_SERIAL){
                cpidList.add(cpid);
            }
        }
        return cpidList;
    }

    /**
     * 与端口建立连接
     * @param portName
     * COM3
     * @throws Exception
     */
    public void connect (String portName, SerialReaderCore serialReader) throws Exception {
        //判断serialPort是否为空
        if(serialPort!=null){
            logger.info("已经连接端口-->"+portName);
            return;
        }
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if ( portIdentifier.isCurrentlyOwned() ) {
            logger.info(portName+"===端口被占用===");
        } else {
            CommPort commPort = null;
            try {
                commPort = portIdentifier.open(this.getClass().getName(),timeout);
            } catch (PortInUseException e) {
                logger.info(portName+"===端口被占用===");
            }
            if ( commPort instanceof SerialPort) {
                serialPort = (SerialPort) commPort;
                // 参数
                serialPort.setSerialPortParams(baudRate,dataBits,stopBits,parity);
                InputStream in = serialPort.getInputStream();
                serialReader.valueInput(in);//给读取数据的类赋值
                serialPort.addEventListener(serialReader);
                //当数据传输进来是唤醒
                serialPort.notifyOnDataAvailable(true);
                logger.info("连接 " + portName + " 成功");
            } else {
                logger.info("Error: Only serial ports are handled by this example.");
            }
        }
    }


    /**
     * 向端口里面写数据
     * */
    private class SerialWriter implements Runnable {
        OutputStream out;
        public SerialWriter (OutputStream out) {
            this.out = out;
        }

        public void run () {
            try {
                int c = 0;
                while ( ( c = System.in.read()) > -1 ) {
                    this.out.write(c);
                }
            } catch ( IOException e ) {
                logger.info("向 -->"+portName+"写入数据失败！");
            }
        }
    }

    /**
     * 发送和写都单独开了一个线程
     * 向串口发送数据
     * @param msg
     */
    public String sendMsg(String msg) {
        if (!StringUtils.isEmpty(msg)) {
            try {
                OutputStream out = serialPort.getOutputStream();
              //  out.write(msg.getBytes());
                out.write(Encodes.hexStrToBinaryStr(msg));
                (new Thread(new SerialPortCore.SerialWriter(out))).start();
                logger.info("串口消息发送成功！");
                return "success";
            } catch (IOException e) {
                logger.info("串口消息发送失败");
            }
        }
        return  "fail";
    }

    /**
     * 关闭串口
     *
     * @param serialPort
     *            待关闭的串口对象
     */
    public void closePort(SerialPort serialPort) {

        if (serialPort != null) {
            serialPort.close();
            serialPort = null;
        }
    }
}
