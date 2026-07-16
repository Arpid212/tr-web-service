package com.example.tr.Service;

import com.example.tr.Mock.DTO.MockOneResponse;
import com.example.tr.Mock.DTO.MockTwoResponse;
import com.example.tr.Mock.DTO.MockThreeResponse;
import com.example.tr.Model.SharedDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class OrchestratorService {
        private static final Logger log = LoggerFactory.getLogger(OrchestratorService.class);   
        private final WebClient webClient;

        public OrchestratorService(
                WebClient.Builder webClientBuilder,
                @Value("${orchestrator.mock-base-url:http://localhost:8080}") String mockBaseUrl) {
        this.webClient = webClientBuilder.baseUrl(mockBaseUrl).build();
        }

    /**
     * Menjalankan Step 1 dan Step 2 secara berurutan lalu menyimpan responsnya
     * dalam satu objek yang dapat dipakai oleh langkah selanjutnya.
     */
        public SharedDto executeStep1And2() {
        MockOneResponse mock1Response = Objects.requireNonNull(
                webClient.get()
                        .uri("/mock/mock1")
                        .retrieve()
                        .bodyToMono(MockOneResponse.class)
                        .block(),
                "Respons dari mock1 tidak boleh kosong");
        log.info("Step 1: Berhasil memanggil mock 1");

        MockTwoResponse mock2Response = Objects.requireNonNull(
                webClient.get()
                        .uri("/mock/mock2")
                        .retrieve()
                        .bodyToMono(MockTwoResponse.class)
                        .block(),
                "Respons dari mock2 tidak boleh kosong");
        log.info("Step 2: Berhasil memanggil mock 2");

        MockThreeResponse mock3Response = Objects.requireNonNull(
                webClient.get()
                        .uri("/mock/mock3")
                        .retrieve()
                        .bodyToMono(MockThreeResponse.class)
                        .block(),
                "Respons dari mock3 tidak boleh kosong");
        log.info("Step 3: Berhasil memanggil mock 3");

        return new SharedDto(mock1Response, mock2Response, mock3Response);
        }
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
// Anggota 4 menyuntikkan logika penanganan error (Saga). 
// Dia harus membuat skenario: Bagaimana jika mock 1 sukses, tapi mock 2 gagal? 
// Anggota 4 harus membuat fungsi kompensasi (compensating transaction) 
// untuk "membatalkan" transaksi sebelumnya agar konsistensi data terjaga, 
// lengkap dengan log pembatalannya 
// (misal: [ERROR] Mock 3 gagal. [INFO] Menjalankan rollback untuk Mock 1 dan 2...)
