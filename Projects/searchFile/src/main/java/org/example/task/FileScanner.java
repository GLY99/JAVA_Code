package org.example.task;

import org.example.model.FileMeta;
import org.example.service.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanner {
    private final FileService fileService = new FileService();
    //线程池
    private ExecutorService threadPool = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
    private CountDownLatch flag = new CountDownLatch(1);//信号量
    private AtomicInteger count = new AtomicInteger();//任务数
    //文件扫描
    public void scan(File root) throws InterruptedException {
        ScanJod jod = new ScanJod(root,fileService,threadPool,flag,count);
        count.incrementAndGet();//任务数增加
        threadPool.execute(jod);//将任务加入线程池
        flag.await();
        //任务结束
        threadPool.shutdown();//关闭线程池
    }
    //扫描任务
    private class ScanJod implements Runnable{
        private File root;
        private FileService fileService;
        private ExecutorService threadPool;
        private CountDownLatch flag;
        private AtomicInteger count;
        public ScanJod(File root,FileService fileService,ExecutorService threadPool,CountDownLatch flag,AtomicInteger count){
            this.root = root;
            this.fileService = fileService;
            this.threadPool = threadPool;
            this.flag = flag;
            this.count = count;
        }
        @Override
        public void run() {
            File[] files = root.listFiles();
            if (files != null){
                List<FileMeta> scanList = new ArrayList<>();
                for (File child : files){
                    if (child.isDirectory()){
                        ScanJod jod = new ScanJod(child,fileService,threadPool,flag,count);
                        count.incrementAndGet();
                        threadPool.execute(jod);
                    }else if (child.isFile()){
                        scanList.add(new FileMeta(child));
                    }
                }
                //一个文件夹完毕
                fileService.service(root.getAbsolutePath(),scanList);
                if (count.decrementAndGet() == 0){
                    flag.countDown();
                }
            }
        }
    }
}
