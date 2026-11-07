public abstract class Kendaraan {
    public static final int batas_kecepatan_global = 200;
    private final String nomorRangka;

    private String merek;
    private int kecepatan;
    private double energi;

    public Kendaraan(String nomorRangka, String merek) {
        this(nomorRangka, merek, 50.0);
    }

    public Kendaraan(String nomorRangka, String merek, double energi) {
        this.nomorRangka = nomorRangka;
        this.merek = merek;
        this.energi = energi;
        this.kecepatan = 0;
    }

    public String getNomorRangka() {
        return nomorRangka;
    }
    public String getMerek() {
        return merek;
    }
    public void setMerek(String merek) {
        this.merek = merek;
    }
    public int getKecepatan() {
        return kecepatan;
    }
    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }
    public double getEnergi() {
        return energi;
    }
    public void setEnergi(double energi) {
        this.energi = Math.max(0, energi);
    }

    public void tampilkanInfo() {
        System.out.println("Merek        : " + merek);
        System.out.println("No. Rangka   : " + nomorRangka);
        System.out.println("Kecepatan    : " + kecepatan + " km/jam");
        System.out.println("Energi       : " + energi);
    }

    public double hitungSisaJarak(double kmPerUnitEnergi) {
        return energi * kmPerUnitEnergi;
    }

    public abstract void jalankan(int kecepatanTarget);
}