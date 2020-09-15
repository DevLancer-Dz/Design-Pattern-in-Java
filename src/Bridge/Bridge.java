package Bridge;


public class Bridge {
    public static void main(String[] args) {
        Tv sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        Tv sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        Tv philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        Tv philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}

abstract class Tv {
    Remote remote;

    public Tv(Remote remote) {
        this.remote = remote;
    }

    abstract void on();

    abstract void off();
}

class Sony extends Tv {
    Remote remoteType;

    public Sony(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    @Override
    void on() {
        System.out.println("Sony tv on : ");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Sony tv off : ");
        remoteType.off();
    }
}

class Philips extends Tv {
    Remote remoteType;

    public Philips(Remote remote) {
        super(remote);
        this.remoteType=remote;
    }

    @Override
    void on() {
        System.out.println("Philips tv on : ");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Philips tv off : ");
        remoteType.off();
    }
}

interface Remote {
    public void on();
    public void off();
}

class OldRemote implements Remote{

    @Override
    public void on() {
        System.out.println("on with old Remote");
    }

    @Override
    public void off() {
        System.out.println("off with old Remote");
    }
}

class NewRemote implements Remote{

    @Override
    public void on() {
        System.out.println("on with New Remote");
    }

    @Override
    public void off() {
        System.out.println("off with New Remote");
    }
}
