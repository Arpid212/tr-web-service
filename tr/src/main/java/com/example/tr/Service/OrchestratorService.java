package com.example.tr.Service;

public class OrchestratorService {
    
}
// TUGAS HARTA
// Menggunakan WebClient dari Anggota 1 untuk memanggil /mock1 dan /mock2. 
// Dia harus memastikan response dari kedua mock ini berhasil ditangkap, 
// disimpan di memori/variabel, dan diberi print log 
// (misal: [INFO] Step 1: Berhasil memanggil mock 1)

// TUGAS CHRISTIVAL
// Melanjutkan pekerjaan Anggota 2 dengan memanggil /mock3. 
// Sama seperti sebelumnya, hasilnya harus disimpan dan diberikan log yang jelas

//TUGAS ANDANG
// Ini bagian yang paling menantang. 
// Anggota 4 menyuntikkan logika penanganan error (Saga). 
// Dia harus membuat skenario: Bagaimana jika mock 1 sukses, tapi mock 2 gagal? 
// Anggota 4 harus membuat fungsi kompensasi (compensating transaction) 
// untuk "membatalkan" transaksi sebelumnya agar konsistensi data terjaga, 
// lengkap dengan log pembatalannya 
// (misal: [ERROR] Mock 3 gagal. [INFO] Menjalankan rollback untuk Mock 1 dan 2...)