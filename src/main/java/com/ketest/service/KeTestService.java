package com.ketest.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ketest.domain.board.Board;
import com.ketest.domain.board.BoardRepository;
import com.ketest.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeTestService {

    @Autowired
    BoardRepository boardRepository;

    @Transactional
    public void insertBoard(HttpServletRequest request) throws IOException {

        // 1. 요청 본문(JSON) 읽기
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String requestBody = stringBuilder.toString();

        // 2. JSON 파싱
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(requestBody);

        // 3. 값 추출
        String reqTitle = jsonNode.get("title").asText();
        String reqContent = jsonNode.get("content").asText();

        // 4. 실제 값 insert
        if(!"".equals(reqTitle) && !"".equals(reqContent)){
            Board  saveBoard = Board.builder()
                    .title(reqTitle)
                    .content(reqContent)
                    .build();

            boardRepository.save(saveBoard);
        }

    }

    public List<Board> selectBoardList() {
        List<Board> boardList = boardRepository.findAll();

        return boardList;
    }

}
