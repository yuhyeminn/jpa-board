package com.jpa.bbs.controller;

import com.jpa.bbs.domain.Board;
import com.jpa.bbs.domain.Member;
import com.jpa.bbs.dto.BoardDTO;
import com.jpa.bbs.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //메인 페이지 및 게시판 목록 조회
    @GetMapping("/board")
    public String test(Model model, @PageableDefault(sort={"boardNo"},direction = Sort.Direction.DESC, size = 5) Pageable pageable){
        try{

            Page<BoardDTO> boardList = boardService.getAllBoard(pageable);
            model.addAttribute("boardList", boardList);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "board/main";
    }

    //게시글 번호로 게시글 상세조회
    @GetMapping("/board/{boardNo}")
    public String test2(Model model, @PathVariable("boardNo") long boardNo){
        try{

            BoardDTO board = boardService.getOneBoard(boardNo);
            model.addAttribute("board", board);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "board/board_detail";
    }

    //게시글 작성 폼 뷰로 이동
    @RequestMapping("/board/write")
    public String boardWriteView(){
        return "board/board_write";
    }

    //게시글 수정 폼 뷰로 이동
    @RequestMapping("/board/edit/{boardNo}")
    public String boardEditView(@PathVariable("boardNo") long boardNo, Model model){
        BoardDTO board = boardService.getOneBoard(boardNo);
        model.addAttribute("board", board);

        return "board/board_edit";
    }

    //게시글 등록
    @PostMapping("/board")
    public String enrollBoard(Board board, MultipartHttpServletRequest request, HttpSession session){
        try{
            //헌재 로그인 한 회원 = 작성자
            Member m = (Member)session.getAttribute("memberLoggedIn");
            board.setBoardWriter(m);

////////////파일 업로드 로직
            String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/board");
            MultipartFile f = request.getFile("upFile");

            //동적으로 directory 생성하기
            File dir = new File(saveDirectory);
            if(dir.exists() == false)
                dir.mkdir();

            //MultipartFile 객체 파일 업로드 처리 시작
            if(!f.isEmpty()){
                String originalFileName = f.getOriginalFilename();
                //파일명 재생성(메소드 분리)
                String renamedFileName = renamedFile(originalFileName);

                //서버 컴퓨터에 파일 저장
                f.transferTo(new File(saveDirectory + "/" + renamedFileName));

                board.setOriginalFileName(originalFileName);
                board.setRenamedFileName(renamedFileName);
            }
            //MultipartFile 객체 파일 업로드 처리 끝
////////////파일 업로드 로직 end

            //XSS공격대비&문자변환
            String boardContent = board.getBoardContent().replaceAll("<", "&lt;")
                                 .replaceAll(">", "&gt")
                                 .replaceAll("\\n", "<br/>");
            board.setBoardContent(boardContent);

            //board 등록
            BoardDTO enrolledBoard = boardService.enrollBoard(board);

            System.out.println(enrolledBoard.toString());

        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/board";
    }

    //게시글 수정
    @PostMapping(value = "/board/edit/{boardNo}")
    public String boardEdit(@PathVariable("boardNo") long boardNo, BoardDTO editedBoard,
                                         @RequestParam String oldOriginalFileName, @RequestParam String oldRenamedFileName, @RequestParam boolean del_flag,
                                         MultipartHttpServletRequest request){
        try{
            //기존 게시글 객체
            BoardDTO olderBoard = boardService.getOneBoard(boardNo);

            String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/board");
            MultipartFile f = request.getFile("upFile");
            //신규첨부파일 존재할 경우
            if(!f.isEmpty()){
                String originalFileName = f.getOriginalFilename();
                String renamedFileName = renamedFile(originalFileName);
                f.transferTo(new File(saveDirectory + "/" + renamedFileName));
                olderBoard.setOriginalFileName(originalFileName);
                olderBoard.setRenamedFileName(renamedFileName);
            }

            //기존첨부파일이 존재했던 경우
            if(!"".equals(olderBoard.getOriginalFileName())) {
                // 기존첨부파일
                File delFile = new File(saveDirectory, oldRenamedFileName);
                //신규첨부파일이 존재할 경우 => 기존 파일 삭제
                if(!f.isEmpty()) {
                    delFile.delete();
                }
                //신규첨부파일이 없지만 기존첨부파일을 삭제하는 경우 => 기존 파일 삭제 후 컬럼 null로 변경
                else if(del_flag){
                    delFile.delete();
                    olderBoard.setOriginalFileName(null);
                    olderBoard.setRenamedFileName(null);
                }
            }
            //나머지 변경사항 처리
            //XSS공격대비&문자변환
            String boardContent = editedBoard.getBoardContent().replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt")
                    .replaceAll("\\n", "<br/>");
            olderBoard.setBoardContent(boardContent);
            olderBoard.setBoardTitle(editedBoard.getBoardTitle());

            //업데이트
            BoardDTO updatedBoard = boardService.updateBoard(olderBoard);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/board/"+boardNo;
    }

    //게시글 삭제
    @RequestMapping("/board/delete/{boardNo}")
    public String boardDelete(@PathVariable("boardNo") long boardNo){
        try{

            boardService.deleteBoard(boardNo);


        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/board";
    }

    public String renamedFile(String originalFileName){
        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        int rndNum = (int)(Math.random()*1000);
        //재생성된 파일 이름
        String renamedFileName = sdf.format(new Date()) + "_" + rndNum + ext;
        return renamedFileName;
    }
}
