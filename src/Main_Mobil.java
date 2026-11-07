public class Main_Mobil {
    public static void main(String[] args) {
        System.out.println("[1,2] State, Behavior, Konstanta global");
        System.out.println("Batas kecepatan global: " + Kendaraan.batas_kecepatan_global + " km/jam");

        System.out.println("\n[3] Overloaded constructor + getter/setter");
        Mobil mobil = new Mobil("MB-001", "Toyota Avanza", 100.0, 4);
        Motor motor = new Motor("MT-001", "Honda Beat");
        motor.setMemakaiHelm(true);
        mobil.tampilkanInfo();
        System.out.println();
        motor.tampilkanInfo();
        System.out.println("Sisa jarak mobil: " + mobil.hitungSisaJarak(10) + " km");

        System.out.println("\n[4,7,8] Abstract class + logika if/else (via superclass)");
        Kendaraan k1 = mobil;
        Kendaraan k2 = motor;
        k1.jalankan(100);
        k1.jalankan(250);
        k2.jalankan(80);
        motor.setMemakaiHelm(false);
        k2.jalankan(80);
        motor.setMemakaiHelm(true);
        k2.setEnergi(0);
        k2.jalankan(80);

        System.out.println("\n[9] Polimorfisme via interface");
        Servis s = new Mobil("MB-002", "Honda Brio", 60.0, 4);
        Bisa_Isi_Energi b = new Motor("MT-002", "Yamaha NMAX", 5.0, true);
        ((Kendaraan) s).jalankan(120);
        ((Kendaraan) s).jalankan(120);
        ((Kendaraan) s).jalankan(120);
        System.out.println("Perlu servis? " + s.perluServis());
        s.servis();
        System.out.println("Perlu servis? " + s.perluServis());
        b.isiEnergi(10);
        System.out.println("Energi motor sekarang: " + ((Kendaraan) b).getEnergi());

        System.out.println("\n[10] Multiple interface (Mobil implements Servisable, BisaIsiEnergi)");
        Mobil m = new Mobil("MB-003", "Suzuki Ertiga", 4);
        Servis sv = m;
        Bisa_Isi_Energi ie = m;
        ie.isiEnergi(20);
        System.out.println("Perlu servis? " + sv.perluServis());
        System.out.println("Energi: " + m.getEnergi());

        System.out.println("\n[2] Immutability: nomorRangka tidak punya setter");
        System.out.println("No. rangka mobil: " + mobil.getNomorRangka());
    }
}