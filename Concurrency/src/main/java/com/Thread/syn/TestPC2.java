package com.Thread.syn;
//信号灯法：标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        TvShow tvShow=new TvShow();
        new Player(tvShow).start();
        new Audience(tvShow).start();
    }
}
class Player extends Thread{
    TvShow tvShow;
    public Player(TvShow tvShow){
        this.tvShow=tvShow;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tvShow.play("abc");
            }else this.tvShow.play("eee");

        }
    }
}
class Audience extends Thread{
    TvShow tvShow;
    public Audience(TvShow tvShow){
        this.tvShow=tvShow;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tvShow.watch();
        }
    }
}
class TvShow{
    //演员表演，观众等待
    //观众观看，演员等待
    String voice;
    boolean flag=true;
    public synchronized void play(String voice){
        if (!flag){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("演员表演了"+voice);
        this.notifyAll();
        this.voice=voice;
        this.flag=!this.flag;
    }
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("观看了"+voice);
        this.notifyAll();
        this.flag=!this.flag;
    }
}