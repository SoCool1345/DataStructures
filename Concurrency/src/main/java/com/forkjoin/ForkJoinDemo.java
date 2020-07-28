package com.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp=10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        ForkJoinDemo task = new ForkJoinDemo(0L, 10_0000_0000L);
//        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
//        Long sum = submit.get();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(sum+" "+(end-start));

    }

    @Override
    protected Long compute() {
        if((end-start)<temp){
            //分支合并计算
            Long sum=0L;
            for (Long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;

        }else {
            long mid=(start+end)/2;
            ForkJoinDemo task1= new ForkJoinDemo(start, mid);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(mid+1, end);
            task2.fork();
            return task1.join()+task2.join();


        }
    }
}
