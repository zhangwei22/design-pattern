package com.concurrent.handle.example.test02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class LoanApplyBatchTaskThread extends Thread {
    private static final Logger logger = LoggerFactory
            .getLogger(LoanApplyBatchTaskThread.class);

    LoanApplyBatchTaskThread() {
        super.setName("LoanApplyTaskThread");
    }

    public synchronized void run() {
        logger.info("do something...");
    }

    public static void main(String[] args) {
        LoanApplyBatchTaskThread latt1 = new LoanApplyBatchTaskThread();
        latt1.start();
    }
}
