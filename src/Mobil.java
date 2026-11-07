public class Mobil extends Kendaraan implements Servis, Bisa_Isi_Energi {
    private static final int batas_mobil = 180;
    private static final int jarak_per_jalan = 10;
    private static final int batas_jarak_servis = 30;

    private int jumlahPintu;
    private int jarakSejakServis;

    public Mobil(String nomorRangka, String merek, int jumlahPintu) {
        super(nomorRangka, merek);
        this.jumlahPintu = jumlahPintu;
    }

    public Mobil(String nomorRangka, String merek, double energi, int jumlahPintu) {
        super(nomorRangka, merek, energi);
        this.jumlahPintu = jumlahPintu;
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }
    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public void jalankan(int kecepatanTarget) {
        if (getEnergi() <= 0) {
            setKecepatan(0);
            System.out.println("[Mobil] Energi habis, mobil berhenti.");
        } else if (kecepatanTarget > batas_mobil) {
            setKecepatan(batas_mobil);
            setEnergi(getEnergi() - 8);
            jarakSejakServis += jarak_per_jalan;
            System.out.println("[Mobil] Target melebihi batas, dibatasi " + batas_mobil + " km/jam.");
        } else {
            setKecepatan(kecepatanTarget);
            setEnergi(getEnergi() - 5);
            jarakSejakServis += jarak_per_jalan;
            System.out.println("[Mobil] Melaju " + kecepatanTarget + " km/jam.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jumlah Pintu : " + jumlahPintu);
    }

    @Override
    public void servis() {
        jarakSejakServis = 0;
        System.out.println("[Mobil] Servis selesai, jarak servis direset.");
    }

    @Override
    public boolean perluServis() {
        return jarakSejakServis >= batas_jarak_servis;
    }

    @Override
    public void isiEnergi(double jumlah) {
        setEnergi(getEnergi() + jumlah);
        System.out.println("[Mobil] Isi bensin " + jumlah + " liter.");
    }
}