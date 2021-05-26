package adapter.designate;

public class MyVideoPlayerAdapter implements PlayerAdapter{
    private VideoPlayer videoPlayer;

    public MyVideoPlayerAdapter(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    public MyVideoPlayerAdapter() {
        this.videoPlayer = new VideoPlayer();
    }

    @Override
    public void playing(String name) {
        videoPlayer.startup(name);
        videoPlayer.playVideo(name);
        videoPlayer.shutdown(name);
    }
}
