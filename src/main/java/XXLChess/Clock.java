package XXLChess;

import processing.core.PApplet;

public class Clock {
    private long start_time;
    private long elapsed_time;
    private boolean running = false;
    private long time_left;
    private int increment ;


    public Clock (int minutes, int seconds, int increment){
        this.time_left = minutes*60*1000 + seconds*1000+0;
        this.increment = increment;
    }


    public void start(){
        if(!running){
            this.start_time = System.currentTimeMillis();
            this.running = true;
        }

    }

    public void stop(){
        if(running){
            this.elapsed_time = System.currentTimeMillis() - this.start_time ;
            this.time_left -= this.elapsed_time;
            this.time_left += this.increment * 1000;
            this.running = false;
        }

    }

    public void reset() {
        this.start_time = System.currentTimeMillis();
        this.elapsed_time = 0;
        this.running = true;
    }
    public void finish(){
        if(running){
            this.elapsed_time = System.currentTimeMillis() - this.start_time;
            this.time_left -= this.elapsed_time;
        }
        if(time_left < 0){
            time_left = 0;
        }
        running = false;
    }

    public long getTime(){
        long time = this.time_left;
        if (running){
            this.elapsed_time = System.currentTimeMillis() - this.start_time;
            time = this.time_left - (this.elapsed_time);
        }
        return time/1000;
    }

    public boolean isRunning(){
        return this.running;
    }

    public int getIncrement() {
        return this.increment;
    }

}
