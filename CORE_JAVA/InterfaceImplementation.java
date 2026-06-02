
interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing guitar: Strumming strings...");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing piano: Pressing keys...");
    }
}

public class InterfaceImplementation {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        
        System.out.println("Musical Instruments:");
        guitar.play();
        piano.play();
    }
}
