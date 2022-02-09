package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {


  @Autowired
  BoardDao boardDao;  //  = new JsonBoardDao(); // 다형적 변수 클래스 이름도 통상적으로 인터페이스의 이름을 뒤에 준다. 또는 클래스명+impl를 붙임

  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) throws Exception {
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardDao.insert(board);
    return boardDao.countAll();
  }


  @RequestMapping("/board/get")
  public Object get(int index) throws Exception {
    Board board = boardDao.findByNo(index);
    if (board == null) {
      return "";
    }
    boardDao.increaseViewCount(index);
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) throws Exception {
    Board old = boardDao.findByNo(index);
    if (old == null) {
      return 0;
    }

    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());

    return boardDao.update(index, board);
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) throws Exception {
    return boardDao.delete(index);
  }
}



