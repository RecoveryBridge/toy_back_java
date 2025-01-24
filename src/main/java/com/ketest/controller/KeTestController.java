package com.ketest.controller;

import com.ketest.service.KeTestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.text.ParseException;

@Controller
public class KeTestController {

    @Autowired
    private KeTestService keTestService;

    @PostMapping("/insertBoard")
    public ResponseEntity<Void> insertBoard(HttpServletRequest request) throws IOException {
        System.out.println("-------------------------백엔드 테스트 시작-------------------------");
        keTestService.insertBoard(request);
        System.out.println("-------------------------백엔드 테스트 종료-------------------------");

        return ResponseEntity.ok().build();
    }

}
