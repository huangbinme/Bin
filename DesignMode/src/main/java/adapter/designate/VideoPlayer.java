package adapter.designate;

public class VideoPlayer {
    public void playVideo(String name) {
        System.out.println("VideoPlayer : Playing video " + name);
    }

    public void startup(String name) {
        System.out.println("VideoPlayer : VideoPlayer is starting ");
    }

    public void shutdown(String name) {
        System.out.println("VideoPlayer : VideoPlayer is shutdown ");
    }
}
