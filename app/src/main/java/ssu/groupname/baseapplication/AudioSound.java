package ssu.groupname.baseapplication;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.util.SparseArray;

import java.io.InputStream;

public class AudioSound {
    private SparseArray<ThreadPlay> mapThread = null;
    private Context context;
    private static final SparseArray<String> MAP_SOUND = new SparseArray<>();
    public static final int MAX = 100, CURRENT = 90;

    static { // White Keys
        MAP_SOUND.put(1, "c");
        MAP_SOUND.put(2, "d");
        MAP_SOUND.put(3, "e");
        MAP_SOUND.put(4, "f");
        MAP_SOUND.put(5, "g");
        MAP_SOUND.put(6, "a");
        MAP_SOUND.put(7, "b");
        MAP_SOUND.put(8, "c");
        MAP_SOUND.put(9, "D1");
        MAP_SOUND.put(10, "E1");
        MAP_SOUND.put(11, "F1");
        MAP_SOUND.put(12, "G1");
        MAP_SOUND.put(13, "A1");
        MAP_SOUND.put(14, "B1");
        MAP_SOUND.put(15, "C1");
        MAP_SOUND.put(16, "D1");

        // Black Keys
        MAP_SOUND.put(17, "c#");
        MAP_SOUND.put(18, "d#");
        MAP_SOUND.put(19, "f#");
        MAP_SOUND.put(20, "c#");
        MAP_SOUND.put(21, "a#");
        MAP_SOUND.put(22, "c#");
        MAP_SOUND.put(23, "d#");
        MAP_SOUND.put(24, "f#");
        MAP_SOUND.put(25, "G#1");
        MAP_SOUND.put(26, "C#1");
        MAP_SOUND.put(27, "G#1");
        MAP_SOUND.put(28, "C#1");
    }

    public AudioSound(Context context) {
        this.context = context;
        mapThread = new SparseArray<>();
    }

    public void notePlay(int note) {
        if (!notePlaying(note)) {
            ThreadPlay thread = new ThreadPlay(note);
            thread.start();
            mapThread.put(note, thread);
        }
    }

    public void noteStop (int note) {
        ThreadPlay thread = mapThread.get(note);
        if(thread != null) {
            mapThread.remove(note);
        }
    }

    public boolean notePlaying(int note) {
        return mapThread.get(note) != null;
    }

    private class ThreadPlay extends Thread {
        int note;
        AudioTrack audioTrack;

        public ThreadPlay(int note) {
            this.note = note;
        }

        @Override
        public void run() {
            try {
                String path = MAP_SOUND.get(note) + ".wav";
                AssetManager assetManager = context.getAssets();
                AssetFileDescriptor afd = assetManager.openFd(path);
                long fileSize = afd.getLength();
                int Buffer = 4096;
                byte[] buffer = new byte[Buffer];
                audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT, Buffer, AudioTrack.MODE_STREAM);

                float Volume = (float) (1 - (Math.log(MAX - CURRENT) / Math.log(MAX)));
                audioTrack.setStereoVolume(Volume, Volume);

                audioTrack.play();
                InputStream audioStream = null;
                int headerOff = 0x2C;
                long bytes = 0;
                int readBytes = 0;

                audioStream = assetManager.open(path);
                audioStream.read(buffer, 0, headerOff);

                while (bytes < fileSize - headerOff) {
                    readBytes = audioStream.read(buffer, 0, Buffer);
                    bytes += audioTrack.write(buffer, 0, readBytes);
                }

                audioTrack.stop();
                audioTrack.release();

            } catch (Exception e) {
            } finally {
                if (audioTrack != null) {
                    audioTrack.release();
                }
            }
        }
    }
}
