public class Motor extends Kendaraan implements Bisa_Isi_Energi {
    private static final int batas_motor = 120;

    private boolean memakaiHelm;

    public Motor(String nomorRangka, String merek) {
        super(nomorRangka, merek);
        this.memakaiHelm = false;
    }

    public Motor(String nomorRangka, String merek, double energi, boolean memakaiHelm) {
        super(nomorRangka, merek, energi);
        this.memakaiHelm = memakaiHelm;
    }

    public boolean isMemakaiHelm() {
        return memakaiHelm;
    }
    public void setMemakaiHelm(boolean memakaiHelm) {
        this.memakaiHelm = memakaiHelm;
    }

    @Override
    public void jalankan(int kecepatanTarget) {
        if (!memakaiHelm) {
            setKecepatan(0);
            System.out.println("[Motor] Pengendara belum memakai helm, ditilang");
        } else if (getEnergi() <= 0) {
            setKecepatan(0);
            System.out.println("[Motor] Bensin habis, motor mati");
        } else if (kecepatanTarget > batas_motor) {
            setKecepatan(batas_motor);
            setEnergi(getEnergi() - 4);
            System.out.println("[Motor] Pengendara melebihi batas kecepatan, ditegur " + batas_motor + " km/jam.");
        } else {
            setKecepatan(kecepatanTarget);
            setEnergi(getEnergi() - 2);
            System.out.println("[Motor] Jalan " + kecepatanTarget + " km/jam.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Pakai Helm   : " + (memakaiHelm ? "Ya" : "Tidak"));
    }

    @Override
    public void isiEnergi(double jumlah) {
        setEnergi(getEnergi() + jumlah);
        System.out.println("[Motor] Isi bensin " + jumlah + " liter.");
    }
}