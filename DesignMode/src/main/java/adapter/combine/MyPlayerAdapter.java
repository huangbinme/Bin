package adapter.combine;

public class MyPlayerAdapter implements PlayerAdapter{
    private AudioPlayer audioPlayer = new MyAudioPlayer();
    private VedioPlayer vedioPlayer = new MyVedioPlayer();


    @Override
    public void play(String playerType, String file) {
        if("audio".equals(playerType)){
            audioPlayer.playAudio(file);
        }else if ("vedio".equals(playerType)){
           vedioPlayer.playVedio(file);
        }else {
            System.out.println("Unknown type");
        }
    }
}
