package com.example.tr.Mock.Controller;

import com.example.tr.Mock.DTO.MockOneResponse;
import com.example.tr.Mock.DTO.MockTwoResponse;
import com.example.tr.Mock.DTO.MockThreeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class MockController {

    @GetMapping("/mock1")
    public ResponseEntity<MockOneResponse> getMock1() {
        MockOneResponse response = new MockOneResponse("M1-001", "SUCCESS", "Validasi Pengguna Berhasil");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mock2")
    public ResponseEntity<MockTwoResponse> getMock2() {
        MockTwoResponse response = new MockTwoResponse("M2-001", "SUCCESS", "Cek Saldo Berhasil");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mock3")
    public ResponseEntity<MockThreeResponse> getMock3() {
        MockThreeResponse response = new MockThreeResponse("M3-001", "SUCCESS", "Pengiriman Barang Diproses");
        return ResponseEntity.ok(response);
    }
}
//Arvid