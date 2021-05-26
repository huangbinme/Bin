package adapter.combine;

public class MyAudioPlayer implements AudioPlayer {
    @Override
    public void playAudio(String file) {
        System.out.println("MyAudioPlayer - > file " + file + " has been playing");
    }
}
