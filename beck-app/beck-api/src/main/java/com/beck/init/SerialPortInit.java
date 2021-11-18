//package com.beck.init;
//
//import com.beck.serial.domain.LedSerailPortReceived;
//import com.beck.serial.utils.SerialPortUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
///**
// * DisallowConcurrentExecution 阻止并行操作 实现串行任务
// * Order 执行的顺序
// * 串口初始化连接
// * @Author dawei
// * @Date 2021/1/25 11:53
// */
//@Component
//@Order(value = 1)
//public class SerialPortInit implements CommandLineRunner {
//
//    protected Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public void run(String... args){
//        try {
//          SerialPortUtils.connect(new LedSerailPortReceived());
//        } catch (Exception e) {
//          logger.info("Error:--> 串口信息连接或接收消息错误！");
//        }
//    }
//}
