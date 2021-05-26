package adapter.extand;

public class MyVideoPlayerAdapter extends VideoPlayer implements PlayerAdapter {
    @Override
    public void playing(String name) {
        startup(name);
        playVideo(name);
        shutdown(name);
    }
}
